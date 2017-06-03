package com.gkpoter.dazuoye.bean;

import java.util.Date;

/**
 * Created by 12153 on 2017/6/3.
 */
public class WatchVideoBean {

    private Integer watchVideoid;
    private Integer userid;
    private Integer videoid;
    private Date time;

    public Integer getWatchVideoid() {
        return watchVideoid;
    }

    public void setWatchVideoid(Integer watchVideoid) {
        this.watchVideoid = watchVideoid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
