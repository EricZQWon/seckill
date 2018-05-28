package org.seckill.service;



import org.junit.Test;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.exception.RepeatkillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dell on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private SeckillService seckillService;
    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list=seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        long id=1000;
        Seckill seckill=seckillService.getById(id);
        logger.info("seckillId={}",seckill );
    }

    @Test
    public void testSeckillLogic() throws Exception {
        long id=1002;
        Exposer exposer=seckillService.exposedSeckillUrl(id);
        if(exposer.isExposed()){
            long phone=13350253334L;
            String md5="bdf1a7a46bca34ded8fdc301e9150870";
            try{
                SeckillExecution execution=seckillService.executeSeckill(id,phone,md5);
                logger.info("result={}",execution);
            }catch (RepeatkillException e){
                logger.error(e.getMessage());
            }catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }catch (SeckillException e){
                logger.error(e.getMessage());
            }


        }else
        //秒杀未开启
        logger.warn("exposer={}",exposer);
    }
    /*
        MD5='bdf1a7a46bca34ded8fdc301e9150870
     */


}