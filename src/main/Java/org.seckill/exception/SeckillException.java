package org.seckill.exception;

/**
 * 秒杀异常总类
 * Created by dell on 2017/6/10.
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
