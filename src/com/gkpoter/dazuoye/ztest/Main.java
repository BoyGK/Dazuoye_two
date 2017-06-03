package com.gkpoter.dazuoye.ztest;


import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.dao.VideoDAO;

import java.util.Date;


/**
 * Created by 12153 on 2017/5/31.
 */
public class Main {

    public static void main(String[] args) {

        VideoDAO dao = new VideoDAO();
        VideoBean bean = new VideoBean();
        bean.setURL("http://www.baidu.com3");
        bean.setTitle("逗比");
        bean.setGranter(1);
        bean.setWatchNum(0);
        bean.setUpdate(new Date().toString());
        bean.setSubject("逗比");
        bean.setVideoid(3);
        dao.save(bean);

    }

}
