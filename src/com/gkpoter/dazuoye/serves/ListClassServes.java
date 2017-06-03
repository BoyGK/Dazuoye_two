package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.bean.STuserBean;
import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.dao.UserDAO;
import com.gkpoter.dazuoye.dao.VideoDAO;
import com.gkpoter.dazuoye.model.LoginModel;
import com.gkpoter.dazuoye.model.STHomeModel;
import com.gkpoter.dazuoye.model.SyllabusModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2017/6/3.
 */
public class ListClassServes {

    public SyllabusModel listClass(int userid) {
        SyllabusModel model = new SyllabusModel();
        UserDAO dao = new UserDAO();
        List<STuserBean> userBeans = dao.query("SELECT * FROM stuser WHERE userid = " + userid);
        if (userBeans != null && userBeans.size() != 0) {
            String s[] = userBeans.get(0).getCourse().split(",");
            List<String> classes = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                classes.add(s[i]);
            }
            model.setState(1);
            model.setMsg("");
            model.setCalssName(classes);
        } else {
            model.setState(0);
            model.setMsg("暂无列表信息");
            List<String> classes = new ArrayList<>();
            model.setCalssName(classes);
        }
        return model;
    }
}
