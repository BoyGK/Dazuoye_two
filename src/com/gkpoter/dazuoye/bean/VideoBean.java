package com.gkpoter.dazuoye.bean;

/**
 * Created by lenovo on 2017/5/31.
 */
public class VideoBean {
    private Integer videoid;
    private String title;
    private String URL;
    private String subject;
    private Integer granter;
    private Integer watchNum;
    private String update;

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getGranter() {
        return granter;
    }

    public void setGranter(Integer granter) {
        this.granter = granter;
    }

    public Integer getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(Integer watchNum) {
        this.watchNum = watchNum;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
