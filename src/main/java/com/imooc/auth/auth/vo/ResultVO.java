package com.imooc.auth.auth.vo;

/**
 * httpq请求返回的最外层对象
 */

public class ResultVO<T> {
    //是否正确
    private  Integer code;
    //提示信息
    private  String msg;
    //具体内容
    private  T data;

    private boolean state;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
