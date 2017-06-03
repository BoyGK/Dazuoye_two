package com.gkpoter.dazuoye.model;

import java.util.List;

/**
 * Created by 12153 on 2017/6/3.
 */
public class SyllabusModel {
    private Integer state;
    private String msg;
    protected List<String> calssName;
    public List<String> getCalssName() {
        return calssName;
    }

    public void setCalssName(List<String> calssName) {
        this.calssName = calssName;
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
