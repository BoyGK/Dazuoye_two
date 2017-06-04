package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.bean.WatchVideoBean;
import com.gkpoter.dazuoye.dao.WatchVideoDao;
import com.gkpoter.dazuoye.model.BaseModel;

import java.util.Date;
import java.util.List;

/**
 * Created by 12153 on 2017/6/3.
 */
public class VideoLogServes {

    public BaseModel watch(Integer userid, Integer videoid){
        WatchVideoDao dao = new WatchVideoDao();
        List<WatchVideoBean> watchVideoBeans = dao.find();
        int id;
        if(watchVideoBeans!=null&&watchVideoBeans.size()!=0){
            id = watchVideoBeans.get(watchVideoBeans.size()-1).getVideoid()+1;
        }else{
            id = 1;
        }
        WatchVideoBean watchVideoBean=new WatchVideoBean();
        watchVideoBean.setWatchVideoid(id);
        watchVideoBean.setUserid(userid);
        watchVideoBean.setVideoid(videoid);
        watchVideoBean.setTime(new Date().toString());
        dao.save(watchVideoBean);
        return new BaseModel(1,"");
    }

}
