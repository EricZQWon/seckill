package org.seckill.service.impl;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.seckill.SeckillstatusEnum.SeckillstateEnum;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKillDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.Student;
import org.seckill.entity.SuccessKill;
import org.seckill.exception.RepeatkillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/6/10.
 */
@Service
public class SeckillServiceimpl implements SeckillService {
    //注入Service依赖
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKillDao successKillDao;
    //MD5盐值，用以混淆
    private final String slat="*hshfhi2C%Dhs~$sda24125";

    private String getMD5(long seckillId){
        String base= seckillId+"$"+slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    public List<Seckill> getSeckillList() {

        return seckillDao.queryAll(0,100);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Transactional
    /*
        注解式事务管理优点：
        1、达成团队约定
        2、保证事务处理时间尽可能短，将http/io操作剥离到事务方法之外，public
        3、并不是所有操作都需要事务，比如仅一行的操作、查找等
     */
    public Exposer exposedSeckillUrl(long seckillId) {
        String MD5=getMD5(seckillId);
        Seckill seckill=seckillDao.queryById(seckillId);
        //判断秒杀库中是否有此ID/有库存
        if(seckill==null){
            return  new Exposer(false,seckillId);
        }
        Date start_time=seckill.getStartTime();
        Date end_time=seckill.getEndTime();
        Date now_time=new Date();
        //判断是否处于秒杀时间段内
        if(now_time.getTime()<start_time.getTime()

                ||now_time.getTime()>end_time.getTime()){
            return  new Exposer(false,seckillId,now_time.getTime(),start_time.getTime(),end_time.getTime());
        }
        return new Exposer(true,seckillId,MD5);
    }

    public SeckillExecution executeSeckill(long seckillId, long userPhone, String MD5) throws SeckillException, SeckillCloseException, RepeatkillException {
        try{
            //判断MD5是否为空或不匹配
            if(MD5==null||!MD5.equals(getMD5(seckillId))){
                //不匹配则数据被篡改 拒绝执行
                throw new SeckillException("seckill data rewrite");
            }
            //执行秒杀逻辑：减库存+记录购买行为
            Date nowTime=new Date();
            int updateCount=seckillDao.reduceNumber(seckillId,nowTime);
            if(updateCount<=0){
                throw new SeckillCloseException("seckill closed");
            }else {
                //联合主键属性值唯一
                int insertCount=successKillDao.insertSuccessKilled(seckillId,userPhone);
                if(insertCount<=0){
                    //重复秒杀导致秒杀失败
                    throw  new RepeatkillException("seckill  repeated");
                }else {
                    //秒杀执行成功
                    SuccessKill successKill=successKillDao.queryByIdWithPhone(seckillId,userPhone);
                    return new SeckillExecution(seckillId, SeckillstateEnum.SUCCESS,successKill);
                }
            }
        }catch(SeckillCloseException e1){
            throw  e1;
        }catch (RepeatkillException e2){
            throw e2;
        }
        catch (Exception e){
            //rollback

           throw  new SeckillException("seckill inner error"+e.getMessage());
        }
    }

    public Student getStudent(long id, String pwd) {
        return seckillDao.getStudent(id,pwd);
    }

}
