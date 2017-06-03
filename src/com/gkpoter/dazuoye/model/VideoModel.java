package com.gkpoter.dazuoye.model;

import com.gkpoter.dazuoye.bean.VideoBean;

import java.util.Date;

/**
 * Created by 12153 on 2017/6/3.
 */
public class VideoModel {

    private VideoBean video;
    private Date time;
    private Integer granter;

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getGranter() {
        return granter;
    }

    public void setGranter(Integer granter) {
        this.granter = granter;
    }
}
