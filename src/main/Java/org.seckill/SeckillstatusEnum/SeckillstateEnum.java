package org.seckill.SeckillstatusEnum;

/**
 * 枚举状态常量字段
 * Created by dell on 2017/6/12.
 */
public enum  SeckillstateEnum {
    SUCCESS (1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据被篡改");

    SeckillstateEnum(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }

    private int status;
    private String statusInfo;

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
    public static SeckillstateEnum stateOf(int index){
        for(SeckillstateEnum state:values()){
            if(state.getStatus()==index){
                return state;
            }

        }
        return  null;

    }
}
