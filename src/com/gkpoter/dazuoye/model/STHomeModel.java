package com.gkpoter.dazuoye.model;

import com.gkpoter.dazuoye.bean.VideoBean;

import java.util.List;

/**
 * Created by 12153 on 2017/6/3.
 */
public class STHomeModel {

    private Integer state;
    private String msg;
    private List<VideoBean> videos;

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

    public List<VideoBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoBean> videos) {
        this.videos = videos;
    }
}
