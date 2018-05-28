package org.seckill.dto;

import org.seckill.SeckillstatusEnum.SeckillstateEnum;
import org.seckill.entity.SuccessKill;

/**
 * Created by dell on 2017/6/10.
 * 用以封装秒杀结束后的结果
 */
public class SeckillExecution {
    //Id
    private long seckillId;
    //状态标识
    private int status;
    //解释状态标识
    private String statusInfo;
    //若秒杀成功 则需要返回一个对象
    private SuccessKill successKill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public SuccessKill getSuccessKill() {
        return successKill;
    }

    public void setSuccessKill(SuccessKill successKill) {
        this.successKill = successKill;
    }
    //秒杀失败的构造
    public SeckillExecution(long seckillId, SeckillstateEnum seckillstateEnum) {
        this.seckillId = seckillId;
        this.status = seckillstateEnum.getStatus();
        this.statusInfo = seckillstateEnum.getStatusInfo();
    }

    public SeckillExecution(long seckillId, SeckillstateEnum seckillstateEnum, SuccessKill successKill) {

        this.seckillId = seckillId;
        this.status = seckillstateEnum.getStatus();
        this.statusInfo = seckillstateEnum.getStatusInfo();
        this.successKill = successKill;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", status=" + status +
                ", statusInfo='" + statusInfo + '\'' +
                ", successKill=" + successKill +
                '}';
    }
}
