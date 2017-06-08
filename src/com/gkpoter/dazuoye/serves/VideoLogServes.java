package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.bean.WatchVideoBean;
import com.gkpoter.dazuoye.dao.VideoDAO;
import com.gkpoter.dazuoye.dao.WatchVideoDao;
import com.gkpoter.dazuoye.model.BaseModel;
import com.gkpoter.dazuoye.model.STHomeModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 12153 on 2017/6/3.
 */
public class VideoLogServes {

    public BaseModel watch(Integer userid, Integer videoid) {
        WatchVideoDao dao = new WatchVideoDao();
        List<WatchVideoBean> watchVideoBeans = dao.find();
        int id;
        if (watchVideoBeans != null && watchVideoBeans.size() != 0) {
            id = watchVideoBeans.get(watchVideoBeans.size() - 1).getVideoid() + 1;
        } else {
            id = 1;
        }
        WatchVideoBean watchVideoBean = new WatchVideoBean();
        watchVideoBean.setWatchVideoid(id);
        watchVideoBean.setUserid(userid);
        watchVideoBean.setVideoid(videoid);
        watchVideoBean.setTime(new Date().toString());
        dao.save(watchVideoBean);
        return new BaseModel(1, "");
    }

    public STHomeModel getWatch(Integer userid) {
        STHomeModel model = new STHomeModel();
        WatchVideoDao dao = new WatchVideoDao();
        VideoDAO videoDAO = new VideoDAO();
        List<VideoBean> videoBeans=new ArrayList<>();
        List<WatchVideoBean> watchVideoBeans = dao.query("select * from watchvideo where userid = " + userid);
        for(WatchVideoBean watchVideoBean:watchVideoBeans){
            List<VideoBean> videoBean = videoDAO.query("select * from video where videoid = "+watchVideoBean.getVideoid());
            if(videoBean!=null&&videoBean.size()!=0){
                videoBeans.add(videoBean.get(0));
            }
        }
        model.setVideos(videoBeans);
        if(videoBeans.size()!=0){
            model.setMsg("");
            model.setState(1);
        }else{
            model.setMsg("暂无视频信息");
            model.setState(0);
        }
        return model;
    }

}
