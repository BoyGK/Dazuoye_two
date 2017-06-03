package com.gkpoter.dazuoye.model;

import java.util.List;

/**
 * Created by 12153 on 2017/6/3.
 */
public class STHomeModel {

    private Integer state;
    private String msg;
    private List<VideoModel> videos;

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

    public List<VideoModel> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoModel> videos) {
        this.videos = videos;
    }
}
