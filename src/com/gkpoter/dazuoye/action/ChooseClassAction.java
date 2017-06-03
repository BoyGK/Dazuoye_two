package com.gkpoter.dazuoye.action;

import com.gkpoter.dazuoye.bean.STuserBean;
import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.model.LoginModel;
import com.gkpoter.dazuoye.model.STHomeModel;
import com.gkpoter.dazuoye.serves.ChooseClassServes;
import com.gkpoter.dazuoye.serves.UserServes;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lenovo on 2017/6/3.
 */
public class ChooseClassAction {
    private String cnum;
    private String cno;

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String ChooseClass() {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            ChooseClassServes serves = new ChooseClassServes();
            STHomeModel model = serves.chooseClass(cnum, cno);
            String json = new Gson().toJson(model);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
