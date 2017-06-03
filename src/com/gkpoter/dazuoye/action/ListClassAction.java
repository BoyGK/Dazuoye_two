package com.gkpoter.dazuoye.action;

import com.gkpoter.dazuoye.model.STHomeModel;
import com.gkpoter.dazuoye.model.SyllabusModel;
import com.gkpoter.dazuoye.serves.ListClassServes;
import com.gkpoter.dazuoye.serves.UserServes;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by lenovo on 2017/6/3.
 */
public class ListClassAction {

    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String ListClass() {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            ListClassServes serves = new ListClassServes();
            SyllabusModel model = serves.listClass(userid);
            String json = new Gson().toJson(model);
            out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
