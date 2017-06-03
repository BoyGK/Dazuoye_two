package com.gkpoter.dazuoye.model;

import com.gkpoter.dazuoye.bean.STuserBean;

/**
 * Created by 12153 on 2017/6/3.
 */
public class LoginModel{

    private Integer state;
    private String msg;
    private STuserBean user;

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

    public STuserBean getUser() {
        return user;
    }

    public void setUser(STuserBean user) {
        this.user = user;
    }
}
