package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.Student;
import org.seckill.entity.SuccessKill;
import org.seckill.exception.RepeatkillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 站在“使用者”角度思考构造，接口不要太冗余的方法
 * 返回类型（return/异常）、方法定义粒度（不应该关注如何去减库存等等）、参数
 * Created by dell on 2017/6/10.
 */
public interface SeckillService {
    /*
        返回所有的参与秒杀的记录
     */
    List<Seckill> getSeckillList();
    /**
     * 根据ID查询单个秒杀记录
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启则输出秒杀结果 成功：失败
     * 反之输出系统时间和秒杀开启时间
     */
    Exposer exposedSeckillUrl(long seckillId);
    /**
     *MD5进行检验，若不同则用户URL被篡改进行有风险操作
     * 如使用第三方软件重复秒杀
     * 注意抛出异常顺序！
     */
    SeckillExecution executeSeckill(long seckillId,long userPhone,String MD5)
            throws SeckillException,SeckillCloseException,RepeatkillException;

    Student getStudent(long id,String pwd);
}
