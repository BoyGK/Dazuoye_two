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

    public Integer getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(Integer watchNum) {
        this.watchNum = watchNum;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid= videoid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL= URL;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String Subject) {
        this.subject = subject;
    }

    public Integer getGranter() {
        return granter;
    }

    public void setGranter(Integer Granter) {
        this.granter = granter;
    }
}
