package com.gkpoter.dazuoye.model;

import com.gkpoter.dazuoye.bean.STuserBean;
import com.gkpoter.dazuoye.bean.VideoBean;

/**
 * Created by lenovo on 2017/5/28.
 */
public class STVModel{
    private STuserBean sTuserBean;
    private VideoBean videoBean;

    public STuserBean getsTuserBean() {
        return sTuserBean;
    }

    public void setsTuserBean(STuserBean sTuserBean) {
        this.sTuserBean = sTuserBean;
    }

    public VideoBean getVideoBean() {
        return videoBean;
    }

    public void setVideoBean(VideoBean videoBean) {
        this.videoBean = videoBean;
    }
}
