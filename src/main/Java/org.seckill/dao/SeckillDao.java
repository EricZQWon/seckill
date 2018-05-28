package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.seckill.entity.Student;

/**
 * Created by dell on 2017/6/5.
 */
public interface SeckillDao {
    /*
       减库存
       如果影响行数>1，则表示更新的行数
     */
    int reduceNumber(@Param("seckill_id") long seckill_id,@Param("killtime") Date killtime);
    /*
        通过ID查询
     */
    Seckill queryById(long seckill_id);

    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    Student getStudent(@Param("id") long id,@Param("pwd") String pwd);
}
