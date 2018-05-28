package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Student;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.seckill.entity.Seckill;
import org.seckill.dao.SeckillDao;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/6/7.
 */

/**
 * 配置spring&Junit整合，Junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class seckillDaoTest {
    //注入DAO 实现类依赖
    @Resource
    private SeckillDao seckillDao;
    /*
    Caused by: java.lang.IllegalStateException: SpringJUnit4ClassRunner requires JUnit 4.12 or higher.
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.<clinit>(SpringJUnit4ClassRunner.java:102)
	... 14 more

     */
    @Test
    public void reduceNumber() throws Exception {
        Date killtime=new Date();
        int k=seckillDao.reduceNumber(1000L,killtime);
        System.out.print(k);

    }

    @Test

    public void queryById() throws Exception {
        //因为建表的时候Auto_increment设定的是1000
        long id=1000;
        Seckill seckill=seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void quertAll() throws Exception {
        List<Seckill> seckills=seckillDao.queryAll(0,100);
        for (Seckill s:seckills) {
            System.out.print(seckills);
        }
    }

    @Test
    public void getStudent(){
        long id=41512200;
        String pwd="a";
        Student student=seckillDao.getStudent(id,pwd);
        System.out.println(student);
    }

}