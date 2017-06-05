package com.gkpoter.dazuoye.action;

import com.gkpoter.dazuoye.model.BaseModel;
import com.gkpoter.dazuoye.serves.UpLoadServes;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by 12153 on 2017/6/3.
 */
public class UpLoadAction extends ActionSupport {

    private Integer userid;
    private String title;
    private String subject;

    public String upLoadFile(){
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            HttpServletRequest request = ServletActionContext.getRequest();
            InputStream videoFile = request.getInputStream();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            UpLoadServes serves = new UpLoadServes();
            BaseModel model = serves.upLoad(userid,videoFile,title,subject);
            String json = new Gson().toJson(model);
            out.println(json);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
