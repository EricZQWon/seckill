package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import javax.annotation.Resource;

/**
 * Created by dell on 2017/6/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class SuccessKillDaoTest {
    @Resource
    private SuccessKillDao secklillDao;
    @Test
    public void insertSuccessKilled() throws Exception {
        long phoneNumber=13350253332L;
        int inserCount=secklillDao.insertSuccessKilled(1002L,phoneNumber);
        System.out.print(inserCount);
    }

    @Test
    public void queryByIdWithPhone() throws Exception {
        long phoneNumber=17789135989L;
        SuccessKill answer=secklillDao.queryByIdWithPhone(1000L,phoneNumber);
        System.out.print(answer);
        System.out.println(answer.getSeckill().toString());
    }

}