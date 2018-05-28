package org.seckill.dto;

/**
 * 用以封装是否暴露接口
 * 以及暴露接口的数据
 * Created by dell on 2017/6/10.
 */
public class Exposer {
    //是否暴露接口
   private  boolean isExposed;

   //ID
   private long seckillId;

    //服务器当前时间
    private long now;
    //秒杀开始时间
    private long start;
    private long end;

    //采用MD5码加密信息
    private String MD5;

    public boolean isExposed() {
        return isExposed;
    }

    public void setExposed(boolean exposed) {
        isExposed = exposed;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public Exposer(boolean isExposed, long seckillId) {
        this.isExposed = isExposed;
        this.seckillId = seckillId;
    }

    public Exposer(boolean isExposed, long seckillId, long now, long start, long end) {
        this.seckillId=seckillId;
        this.isExposed = isExposed;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean isExposed, long seckillId, String MD5) {

        this.isExposed = isExposed;
        this.seckillId = seckillId;
        this.MD5 = MD5;
    }


    @Override
    public String toString() {
        return "Exposer{" +
                "isExposed=" + isExposed +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                ", MD5='" + MD5 + '\'' +
                '}';
    }
}
