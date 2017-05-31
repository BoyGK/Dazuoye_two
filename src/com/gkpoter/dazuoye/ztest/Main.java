package com.gkpoter.dazuoye.ztest;

import com.gkpoter.dazuoye.util.JdbcUtil;

import java.sql.*;

/**
 * Created by 12153 on 2017/5/31.
 */
public class Main {

    public static void main(String[] args) {
        try {
            JdbcUtil jdbcUtil = JdbcUtil.getInstance();
            Connection conn = jdbcUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from test");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("id : " + rs.getInt(1) + " name : "
                        + rs.getString("username") + " password : " + rs.getString(3));
            }
            jdbcUtil.closeConnection(rs,ps,conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
