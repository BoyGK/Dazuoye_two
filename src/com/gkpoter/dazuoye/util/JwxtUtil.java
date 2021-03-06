package com.gkpoter.dazuoye.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 12153 on 2017/6/1.
 */
public class JwxtUtil {

    public JwxtUtil() {
    }

    private String cookie_key = null;
    private String cookie_value = null;

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    private String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if (cookie_value != null) {
                cookie_value = cookie_value.replaceAll("; path=/", "");
                connection.setRequestProperty("cookie", cookie_value);
            }

            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                //System.out.println(key + "--->" + map.get(key));
                if (key != null && key.equals("Set-Cookie")) {
                    cookie_key = key;
                    cookie_value = map.get(key).get(0);
                }
            }

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "GBK"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public String getCookie_key() {
        return cookie_key;
    }

    public void setCookie_key(String cookie_key) {
        cookie_key = cookie_key;
    }

    public String getCookie_value() {
        return cookie_value;
    }

    public void setCookie_value(String cookie_value) {
        cookie_value = cookie_value;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    private String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //对cookie进行处理：
            if (cookie_value != null) {
                cookie_value = cookie_value.replaceAll("; path=/", "");
                conn.setRequestProperty("cookie", cookie_value);
            }
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    private String Syllabus(String username, String password) {
        sendGet("http://jwxt.imu.edu.cn/loginAction.do", "zjh=" + username + "&mm=" + password);
        String string = sendGet("http://jwxt.imu.edu.cn/xkAction.do", "actionType=6");
        return string;

    }

    /**
     * 选课
     * @param cnum
     * @param cno
     * @return
     */
    public boolean chooseClass(String cnum,String cno){
        return false;
    }

    /**
     * 获取已选课程信息
     *
     * @param usernum
     * @param password
     * @return
     */
    public String getSyllabus(String usernum, String password) {
        String html = Syllabus(usernum, password);
        Document document=Jsoup.parse(html);
        Elements element = document.getElementsByTag("td");
        String string = element.get(18).text();
        string = string.replaceAll(" ",",");
        string = string.replaceAll(" ,","");
        string = string.replaceAll("星期一,星期二,星期三,星期四,星期五,星期六,星期日,上午,","");
        string = string.replaceAll("午,休,下午,","");
        string = string.replaceAll(",晚饭,晚上,第9节\\(1900-1950\\),第10节\\(2000-2050\\),第11节\\(2100-2150\\),","");
        return string;
    }

    /**
     * 获取学生信息
     *
     * @param usernum
     * @param password
     * @return
     */
    public StudentInfo getStudentInfo(String usernum, String password) {
        sendGet("http://jwxt.imu.edu.cn/loginAction.do", "zjh=" + usernum + "&mm=" + password);
        String string = sendPost("http://jwxt.imu.edu.cn/xjInfoAction.do", "oper=xjxx");
        Map<String,String> map=new HashMap<>();
        Document document = Jsoup.parse(string);
        Elements element = document.getElementsByTag("td");
        String content = element.get(15).text();
        content = content.replaceAll(" ",",");
        content = content.replaceAll(" ","");
        String str[] = content.split(",");
        for(int i=0;i<str.length-1;i++){
            if(str[i].contains(":")&&!str[i+1].contains(":")){
                map.put(str[i],str[i+1]);
                i++;
            }
        }
        /*
        doc网页分析
         */
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setNumber(usernum);
        studentInfo.setPassword(password);
        studentInfo.setTruename(map.get("姓名:"));
        studentInfo.setCardnum(map.get("身份证号:"));
        studentInfo.setClazz(map.get("班级:"));
        studentInfo.setFaculty(map.get("系所:"));
        studentInfo.setNation(map.get("民族:"));
        studentInfo.setPoliticalstatus(map.get("政治面貌:"));
        studentInfo.setSex(map.get("性别:"));
        return studentInfo;
    }

    public class StudentInfo {
        private String number;
        private String password;
        private String truename;
        private String sex;
        private String cardnum;
        /*
        民族
         */
        private String nation;
        /*
        政治面貌
         */
        private String politicalstatus;
        /*
        院系
         */
        private String faculty;
        private String clazz;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTruename() {
            return truename;
        }

        public void setTruename(String truename) {
            this.truename = truename;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getCardnum() {
            return cardnum;
        }

        public void setCardnum(String cardnum) {
            this.cardnum = cardnum;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getPoliticalstatus() {
            return politicalstatus;
        }

        public void setPoliticalstatus(String politicalstatus) {
            this.politicalstatus = politicalstatus;
        }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }
    }

}
