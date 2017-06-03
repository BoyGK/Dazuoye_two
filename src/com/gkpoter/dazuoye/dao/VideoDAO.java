package com.gkpoter.dazuoye.dao;

import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/31.
 */
public class VideoDAO {

    private JdbcUtil jdbcUtil;
    private Connection connection;

    public VideoDAO() {
        jdbcUtil = JdbcUtil.getInstance();
    }

    /**
     * 条件语句执行操作
     * @param sql
     * @return
     */
    public List<VideoBean> query(String sql){
        List<VideoBean> stUsers = new ArrayList<>();
        try {
            connection = jdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = null;
            if(sql.contains("select")||sql.contains("SELECT")) {
                rs = ps.executeQuery();
                while (rs!=null&&rs.next()) {
                    VideoBean video = new VideoBean();
                    video.setVideoid(rs.getInt(1));
                    video.setURL(rs.getString(2));
                    video.setTitle(rs.getString(3));
                    video.setSubject(rs.getString(4));
                    video.setGranter(rs.getInt(5));
                    video.setWatchNum(rs.getInt(6));
                    video.setUpdate(rs.getString(7));
                    stUsers.add(video);
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
    public List<VideoBean> find(){
        return query("select * from video");
    }

    /**
     * 插入操作&更新操作
     * @param video 根据对象进行操作（暂时匹配username）
     */
    public boolean save(VideoBean video){
        if(video!=null){
            if(video.getURL()!=null){
                if(!"".equals(video.getURL())){
                    List<VideoBean> videobean = query("SELECT * FROM video WHERE url = '" + video.getURL() + "'");
                    //更新操作
                    if(videobean!=null&&videobean.size()!=0){
                        String sql="UPDATE video SET " +
                                "videoid=" + video.getVideoid()+ "," +
                                "title=\"" + video.getTitle() + "\"," +
                                "url=\"" + video.getURL() + "\"," +
                                "subject=\"" + video.getSubject() + "\"," +
                                "granter=" + video.getGranter() + "," +
                                "watchnum=" + video.getWatchNum() + "," +
                                "updt=\"" + video.getUpdate() + "\" " +
                                "WHERE url=\"" + video.getURL() + "\"";
                        query(sql);
                    }
                    //插入操作
                    else{
                        String sql="INSERT INTO video VALUES (\"" +
                                video.getVideoid() + "\",\"" +
                                video.getURL() + "\",\"" +
                                video.getTitle() + "\",\"" +
                                video.getSubject()+ "\",\"" +
                                video.getGranter()+ "\",\"" +
                                video.getWatchNum()+ "\",\"" +
                                video.getUpdate()+ "\")";
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
     * @param video 根据对象进行操作（暂时匹配username）
     */
    public boolean delete(VideoBean video) {
        if (video != null) {
            if (video.getURL() != null) {
                if (!"".equals(video.getURL())) {
                    List<VideoBean> videobean = query("SELECT * FROM video WHERE url = '" + video.getURL() + "'");
                    if(videobean==null||videobean.size()==0){
                        return false;
                    }else {
                        String sql = "DELETE FROM video WHERE username='" + video.getURL() + "'";
                        query(sql);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
