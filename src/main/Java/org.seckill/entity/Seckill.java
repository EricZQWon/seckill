package org.seckill.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * Created by dell on 2017/6/4.
 */
public class Seckill {
    private  String name;
    private  long seckillId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date endTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date createTime;
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Seckill{" +
                "name='" + name + '\'' +
                ", seckillId=" + seckillId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", number=" + number +
                '}';
    }
}
