package com.gkpoter.dazuoye.ztest;

import com.gkpoter.dazuoye.util.JdbcUtil;
import com.gkpoter.dazuoye.util.JwxtUtil;

import java.sql.*;

/**
 * Created by 12153 on 2017/5/31.
 */
public class Main {

    public static void main(String[] args) {
        JwxtUtil jwxtUtil=JwxtUtil.getInstance();
        String[] s = jwxtUtil.getSyllabus("0151122384","1215356195");
        System.out.print(s);
    }

}
