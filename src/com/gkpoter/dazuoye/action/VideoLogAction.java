package com.gkpoter.dazuoye.action;

import com.gkpoter.dazuoye.model.BaseModel;
import com.gkpoter.dazuoye.serves.VideoLogServes;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by 12153 on 2017/6/3.
 */
public class VideoLogAction extends ActionSupport {

    private Integer userid;
    private Integer videoid;

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

    public String videoLog() {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            VideoLogServes serves = new VideoLogServes();
            BaseModel model = serves.watch(userid, videoid);
            String json = new Gson().toJson(model);
            out.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
