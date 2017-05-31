package com.gkpoter.dazuoye.dao;

import com.gkpoter.dazuoye.bean.STuserBean;
import com.gkpoter.dazuoye.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12153 on 2017/5/31.
 */
public class UserDAO {

    private JdbcUtil jdbcUtil;
    private Connection connection;

    public UserDAO() {
        jdbcUtil = JdbcUtil.getInstance();
    }

    /**
     * 条件语句执行操作
     * @param sql
     * @return
     */
    public List<STuserBean> query(String sql){
        List<STuserBean> stUsers = new ArrayList<>();
        try {
            connection = jdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = null;
            if(sql.contains("select")||sql.contains("SELECT")) {
                rs = ps.executeQuery();
                while (rs!=null&&rs.next()) {
                    STuserBean stuser = new STuserBean();
                    stuser = new STuserBean();
                    stuser.setUserid(rs.getInt(1));
                    stuser.setUsername(rs.getString(2));
                    stuser.setPassword(rs.getString(3));
                    stuser.setTruename(rs.getString(4));
                    stuser.setSex(rs.getInt(5));
                    stuser.setSchool(rs.getString(6));
                    stuser.setDept(rs.getString(7));
                    stuser.setCollage(rs.getString(8));
                    stuser.setKind(rs.getInt(9));
                    stUsers.add(stuser);
                }
            }else{
                ps.executeUpdate();
            }
            jdbcUtil.closeConnection(rs,ps,connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return stUsers;
    }

    /**
     * 整表查询操作
     * @return
     */
    public List<STuserBean> find(){
        return query("select * from stuser");
    }

    /**
     * 单条数据查询
     * @param user
     * @return
     */
    public STuserBean find(STuserBean user){
        if(user!=null) {
            if (user.getUsername() != null) {
                if (!"".equals(user.getUsername())) {
                    List<STuserBean> sTuserBean = query("SELECT * FROM stuser WHERE username = '" + user.getUsername() + "'");
                    if(sTuserBean!=null&&sTuserBean.size()!=0){
                        return sTuserBean.get(0);
                    }
                }
            }
        }
        return null;
    }

    /**
     * 插入操作&更新操作
     * @param user 根据对象进行操作（暂时匹配username）
     */
    public boolean save(STuserBean user){
        if(user!=null){
            if(user.getUsername()!=null){
                if(!"".equals(user.getUsername())){
                    List<STuserBean> sTuserBean = query("SELECT * FROM stuser WHERE username = " + user.getUsername() + "\"");
                    //更新操作
                    if(sTuserBean!=null&&sTuserBean.size()!=0){
                        String sql="UPDATE stuser SET " +
                                "username=" + user.getUsername() + "," +
                                "password=" + user.getPassword() + "," +
                                "truename=" + user.getTruename() + "," +
                                "sex=" + user.getSex() + "," +
                                "school=" + user.getSchool() + "," +
                                "dept=" + user.getDept() + "," +
                                "collage=" + user.getCollage() + "," +
                                "kind=" + user.getKind() + " " +
                                "WHERE username=" + user.getUsername();
                        query(sql);
                    }
                    //插入操作
                    else{
                        String sql="INSERT INTO stuser VALUES (" +
                                user.getUsername() + "," +
                                user.getPassword() + "," +
                                user.getTruename() + "," +
                                user.getSex() + "," +
                                user.getSchool() + "," +
                                user.getDept() + "," +
                                user.getCollage() + "," +
                                user.getKind() + ")";
                        query(sql);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除操作
     * @param user 根据对象进行操作（暂时匹配username）
     */
    public boolean delete(STuserBean user) {
        if (user != null) {
            if (user.getUsername() != null) {
                if (!"".equals(user.getUsername())) {
                    List<STuserBean> sTuserBean = query("SELECT * FROM stuser WHERE username = " + user.getUsername() + "\"");
                    if(sTuserBean==null||sTuserBean.size()==0){
                        return false;
                    }else {
                        String sql = "DELETE FROM stuser WHERE username=" + user.getUsername();
                        query(sql);
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
