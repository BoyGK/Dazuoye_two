package com.gkpoter.dazuoye.action;

import com.gkpoter.dazuoye.dao.TestDAO;
import com.gkpoter.dazuoye.model.STVModel;
import com.gkpoter.dazuoye.serves.UserServes;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 12153 on 2017/5/26.
 */
public class IndexAction extends ActionSupport {

    String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getJson() throws Exception {
        UserServes serves=new UserServes();

        if(serves.login(user)){
            TestDAO dao=new TestDAO();
            List<STVModel> models = dao.query("select * from username where username = " + user);
            STVModel m=models.get(0);
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //out.println(m.tojson());
            /**
             *
             * {
             *     usernamme:"admin",
             *     age:18,
             *     xinxi:[
             *     {},{}
             *     ]
             * }
             *
             *
             */
        }else{
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("false");
        }

        return null;
    }
}
