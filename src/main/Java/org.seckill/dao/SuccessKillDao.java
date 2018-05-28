package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKill;

/**
 * Created by dell on 2017/6/5.
 */
public interface SuccessKillDao {
    int insertSuccessKilled(@Param("seckill_id") long seckill_id,@Param("user_phone") long user_phone);
    /*
        根据ID查询成功秒杀，并携带对象实体
     */

    SuccessKill queryByIdWithPhone(@Param("seckillId") long seckillId,@Param("phone") long phone);
}
