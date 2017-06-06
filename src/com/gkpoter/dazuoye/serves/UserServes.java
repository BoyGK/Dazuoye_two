package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.bean.STuserBean;
import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.dao.UserDAO;
import com.gkpoter.dazuoye.dao.VideoDAO;
import com.gkpoter.dazuoye.model.LoginModel;
import com.gkpoter.dazuoye.model.STHomeModel;
import com.gkpoter.dazuoye.util.JwxtUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/28.
 */
public class UserServes {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public LoginModel login(String username, String password) {
        STuserBean sTuserBean = new STuserBean();
        sTuserBean.setUsername(username);
        sTuserBean.setPassword(password);
        UserDAO dao = new UserDAO();
        STuserBean stu = dao.find(sTuserBean);
        LoginModel model = new LoginModel();
        if (stu != null && stu.getPassword().equals(password)) {
            model.setState(1);
            model.setMsg("");
            model.setUser(stu);
        } else {
            try {
                JwxtUtil jwxtUtil = new JwxtUtil();
                JwxtUtil.StudentInfo studentInfo = jwxtUtil.getStudentInfo(username, password);
                if (studentInfo != null) {
                    List<STuserBean> stus = dao.find();
                    int id;
                    if (stus != null && stus.size() != 0) {
                        id = stus.get(stus.size() - 1).getUserid() + 1;
                    } else {
                        id = 1;
                    }
                    sTuserBean.setUserid(id);
                    sTuserBean.setUsername(studentInfo.getNumber());
                    sTuserBean.setPassword(studentInfo.getPassword());
                    sTuserBean.setTruename(studentInfo.getTruename());
                    sTuserBean.setKind(1);
                    sTuserBean.setSex(studentInfo.getSex());
                    sTuserBean.setSchool("内蒙古大学");
                    sTuserBean.setCollage(studentInfo.getFaculty());
                    sTuserBean.setDept(studentInfo.getClazz());
                    sTuserBean.setCourse(jwxtUtil.getSyllabus(username, password));
                    dao.save(sTuserBean);
                    model.setState(1);
                    model.setMsg("");
                    model.setUser(sTuserBean);
                } else {
                    model.setState(0);
                    model.setMsg("用户名或密码错误");
                    model.setUser(new STuserBean());
                }
            }catch (Exception e){
                model.setState(0);
                model.setMsg("用户名或密码错误");
                model.setUser(new STuserBean());
            }
//            model.setState(0);
//            model.setMsg("用户名或密码错误");
//            model.setUser(new STuserBean());
        }
        return model;
    }

    /**
     * 获取首页信息
     *
     * @param userid
     * @return
     */
    public STHomeModel getHome(int userid) {
        STHomeModel model = new STHomeModel();
        UserDAO dao = new UserDAO();
        List<STuserBean> stus = dao.query("select * from stuser where userid = '" + userid + "'");
        if (stus != null && stus.size() != 0) {
            STuserBean stu = stus.get(0);
            VideoDAO videoDAO = new VideoDAO();
            List<VideoBean> videoBeans;
            if (stu.getKind() == 1) {
                videoBeans = videoDAO.find();
            } else {
                videoBeans = videoDAO.query("select * from video where granter = " + userid);
            }
            if (videoBeans != null && videoBeans.size() != 0) {
                model.setState(1);
                model.setMsg("");
                model.setVideos(videoBeans);
            } else {
                model.setState(0);
                model.setMsg("暂无列表信息");
                List<VideoBean> vs = new ArrayList<>();
                model.setVideos(vs);
            }
        }else{
            model.setState(0);
            model.setMsg("请求错误!!!");
            List<VideoBean> vs = new ArrayList<>();
            model.setVideos(vs);
        }
        return model;
    }
}
