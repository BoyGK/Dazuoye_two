package com.gkpoter.dazuoye.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by 12153 on 2017/5/26.
 */
public class IndexAction extends ActionSupport {

    public String getJson() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("seccess");
        return null;
    }
}
