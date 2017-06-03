package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.bean.STuserBean;
import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.dao.UserDAO;
import com.gkpoter.dazuoye.dao.VideoDAO;
import com.gkpoter.dazuoye.model.LoginModel;
import com.gkpoter.dazuoye.model.STHomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/28.
 */
public class UserServes {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public LoginModel login(String username, String password){
        STuserBean sTuserBean = new STuserBean();
        sTuserBean.setUsername(username);
        sTuserBean.setPassword(password);
        UserDAO dao=new UserDAO();
        STuserBean stu = dao.find(sTuserBean);
        LoginModel model=new LoginModel();
        if(stu!=null&&stu.getPassword().equals(password)){
            model.setState(1);
            model.setMsg("");
            model.setUser(stu);
        }else{
            model.setState(0);
            model.setMsg("用户名或密码错误");
            model.setUser(new STuserBean());
        }
        return model;
    }

    /**
     * 获取首页信息
     * @param userid
     * @return
     */
    public STHomeModel getHome(int userid){
        STHomeModel model=new STHomeModel();
        VideoDAO dao=new VideoDAO();
        List<VideoBean> videoBeans=dao.find();
        if(videoBeans!=null&&videoBeans.size()!=0){
            model.setState(1);
            model.setMsg("");
            model.setVideos(videoBeans);
        }else{
            model.setState(0);
            model.setMsg("暂无列表信息");
            List<VideoBean> vs=new ArrayList<>();
            model.setVideos(vs);
        }
        return model;
    }
}
