package com.gkpoter.dazuoye.action;

import com.gkpoter.dazuoye.model.LoginModel;
import com.gkpoter.dazuoye.serves.UserServes;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 12153 on 2017/5/26.
 */
public class LoginAction extends ActionSupport {

    /**
     * HttpServletResponse response = ServletActionContext.getResponse();
     * response.setContentType("text/html;charset=UTF-8");
     * PrintWriter out = response.getWriter();
     * out.println("");
     */

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String Login() {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            UserServes serves=new UserServes();
            LoginModel model = serves.login(username,password);
            String json = new Gson().toJson(model);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
