package org.seckill.exception;

/**
 * Created by dell on 2017/6/10.
 */
public class RepeatkillException extends SeckillException {
    public RepeatkillException(String message) {
        super(message);
    }

    public RepeatkillException(String message, Throwable cause) {
        super(message, cause);
    }
}
