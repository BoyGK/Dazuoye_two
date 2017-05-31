package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.bean.STuserBean;
import com.gkpoter.dazuoye.dao.UserDAO;

/**
 * Created by lenovo on 2017/5/28.
 */
public class UserServes {

    public boolean login(String username,String password){
        STuserBean sTuserBean = new STuserBean();
        sTuserBean.setUsername(username);
        sTuserBean.setPassword(password);
        UserDAO dao=new UserDAO();
        STuserBean stu = dao.find(sTuserBean);
        if(stu!=null&&password.equals(stu.getPassword())){
            return true;
        }
        return false;
    }
}
