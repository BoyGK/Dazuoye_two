package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.bean.STuserBean;
import com.gkpoter.dazuoye.dao.UserDAO;
import com.gkpoter.dazuoye.model.LoginModel;
import com.gkpoter.dazuoye.model.STHomeModel;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by lenovo on 2017/6/3.
 */
public class ChooseClassServes {
    public STHomeModel chooseClass(String cnum, String cno){
        STHomeModel model=new STHomeModel();
        if(cnum.equals("123")&&cno.equals("123")) {
            model.setState(1);
            model.setMsg("选课成功！");
        }
        else{
                model.setState(0);
                model.setMsg("选课失败！");
        }
        return model;
    }
}
