package org.seckill.dto;

/**
 * Created by dell on 2017/7/11.
 */
//封装ajax请求返回，
public class SeckillResult<T> {


    private boolean IsSuccessed;

    private T data;

    private String error;

    public SeckillResult(boolean isSuccessed, String error) {
        IsSuccessed = isSuccessed;
        this.error = error;
    }

    public SeckillResult(boolean isSuccessed, T data) {
        IsSuccessed = isSuccessed;
        this.data = data;
    }

    public boolean isSuccessed() {
        return IsSuccessed;
    }

    public void setSuccessed(boolean successed) {
        IsSuccessed = successed;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
