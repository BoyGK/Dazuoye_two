package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.dao.VideoDAO;
import com.gkpoter.dazuoye.model.BaseModel;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 12153 on 2017/6/3.
 */
public class UpLoadServes {

    public BaseModel upLoad(Integer userid, InputStream in, String title, String subject){
        String url="" + new Date().getTime();
        try {
            File file = new File("C:\\Users\\12153\\Desktop\\" + url);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\12153\\Desktop\\" + url));
            int n = 0;
            byte[] bb = new byte[1024];
            while ((n = in.read(bb)) != -1) {
                out.write(bb, 0, n);
            }
            out.flush();
            out.close();
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        VideoDAO dao=new VideoDAO();
        List<VideoBean> videoBeans = dao.find();
        int id =0;
        if(videoBeans!=null&&videoBeans.size()!=0){
            id = videoBeans.get(videoBeans.size()-1).getVideoid()+1;
        }else{
            id=1;
        }
        VideoBean videoBean=new VideoBean();
        videoBean.setVideoid(id);
        videoBean.setURL(url);
        videoBean.setSubject(subject);
        videoBean.setGranter(userid);
        videoBean.setTitle(title);
        videoBean.setWatchNum(0);
        videoBean.setUpdate(new Date().toString());
        dao.save(videoBean);
        return new BaseModel(1,"上传成功");
    }

}
