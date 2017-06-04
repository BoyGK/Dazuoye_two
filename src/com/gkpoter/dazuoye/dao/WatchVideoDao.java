package com.gkpoter.dazuoye.dao;

import com.gkpoter.dazuoye.bean.WatchVideoBean;
import com.gkpoter.dazuoye.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12153 on 2017/6/4.
 */
public class WatchVideoDao {

    private JdbcUtil jdbcUtil;
    private Connection connection;

    public WatchVideoDao() {
        jdbcUtil = JdbcUtil.getInstance();
    }

    /**
     * 条件语句执行操作
     *
     * @param sql
     * @return
     */
    public List<WatchVideoBean> query(String sql) {
        List<WatchVideoBean> watchVideoBeans = new ArrayList<>();
        try {
            connection = jdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = null;
            if (sql.contains("select") || sql.contains("SELECT")) {
                rs = ps.executeQuery();
                while (rs != null && rs.next()) {
                    WatchVideoBean watchVideoBean = new WatchVideoBean();
                    watchVideoBean.setWatchVideoid(rs.getInt(1));
                    watchVideoBean.setUserid(rs.getInt(2));
                    watchVideoBean.setVideoid(rs.getInt(3));
                    watchVideoBean.setTime(rs.getString(4));
                    watchVideoBeans.add(watchVideoBean);
                }
            } else {
                ps.executeUpdate();
            }
            jdbcUtil.closeConnection(rs, ps, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return watchVideoBeans;
    }

    /**
     * 整表查询操作
     *
     * @return
     */
    public List<WatchVideoBean> find() {
        return query("select * from watchvideo");
    }

    /**
     * 单条数据查询
     *
     * @param watchVideoBean
     * @return
     */
    public WatchVideoBean find(WatchVideoBean watchVideoBean) {
        if (watchVideoBean != null) {
            if (watchVideoBean.getUserid() != null) {
                if (!"".equals(watchVideoBean.getUserid())) {
                    List<WatchVideoBean> sTuserBean =
                            query("SELECT * FROM watchvideo WHERE watchvideoid = '" + watchVideoBean.getWatchVideoid() + "'");
                    if (sTuserBean != null && sTuserBean.size() != 0) {
                        return sTuserBean.get(0);
                    }
                }
            }
        }
        return null;
    }

    /**
     * 插入操作&更新操作
     *
     * @param watchVideoBean 根据对象进行操作（暂时匹配username）
     */
    public boolean save(WatchVideoBean watchVideoBean) {
        if (watchVideoBean != null) {
            if (watchVideoBean.getUserid() != null) {
                if (!"".equals(watchVideoBean.getUserid())) {
                    List<WatchVideoBean> watchVideoBeans =
                            query("SELECT * FROM watchvideo WHERE watchvideoid = '" + watchVideoBean.getWatchVideoid() + "'");
                    //更新操作
                    if (watchVideoBeans != null && watchVideoBeans.size() != 0) {
                        String sql = "UPDATE watchvideo SET " +
                                "watchvideoid=" + watchVideoBean.getWatchVideoid() + "," +
                                "userid=" + watchVideoBean.getUserid() + "," +
                                "videoid=" + watchVideoBean.getVideoid() + "," +
                                "time=\"" + watchVideoBean.getTime() + "\" " +
                                "WHERE userid=\"" + watchVideoBean.getUserid() + "\"";
                        query(sql);
                    }
                    //插入操作
                    else {
                        String sql = "INSERT INTO watchvideo VALUES (" +
                                watchVideoBean.getWatchVideoid() + "," +
                                watchVideoBean.getUserid() + "," +
                                watchVideoBean.getVideoid() + ",\"" +
                                watchVideoBean.getTime() + "\")";
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
     *
     * @param user 根据对象进行操作（暂时匹配username）
     */
    public boolean delete(WatchVideoBean user) {
        if (user != null) {
            if (user.getUserid() != null) {
                if (!"".equals(user.getUserid())) {
                    List<WatchVideoBean> sTuserBean =
                            query("SELECT * FROM watchvideo WHERE userid = '" + user.getUserid() + "\'");
                    if (sTuserBean == null || sTuserBean.size() == 0) {
                        return false;
                    } else {
                        String sql = "DELETE FROM watchvideo WHERE userid='" + user.getUserid() + "'";
                        query(sql);
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
