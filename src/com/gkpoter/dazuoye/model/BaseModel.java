package com.gkpoter.dazuoye.model;

/**
 * Created by 12153 on 2017/5/31.
 */
public class BaseModel {
    private Integer state;
    private String msg;

    public BaseModel(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
