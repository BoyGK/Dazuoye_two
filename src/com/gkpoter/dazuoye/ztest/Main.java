package com.gkpoter.dazuoye.ztest;


import com.gkpoter.dazuoye.bean.VideoBean;
import com.gkpoter.dazuoye.dao.VideoDAO;
import com.gkpoter.dazuoye.util.JwxtUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by 12153 on 2017/5/31.
 */
public class Main {

    public static void main(String[] args) {
        String html = "<html>\n" +
                "<head>\n" +
                "    <link href=\"/css/newcss/project.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "    <title>历年学期课表查询</title>\n" +
                "</head>\n" +
                "<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" style=\"overflow:auto;\">\n" +
                "<form action=\"\" name=\"form\" method=\"post\">\n" +
                "    <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "        <tr>\n" +
                "            <td class=\"Linetop\"></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"title\" id=\"tblHead\">\n" +
                "        <tr>\n" +
                "            <td width=\"50%\">\n" +
                "                <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                    <tr>\n" +
                "                        <td>&nbsp;</td>\n" +
                "                        <td valign=\"middle\">&nbsp;<b>历年学期课</b>&nbsp;</td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "            <td width=\"50%\">\n" +
                "\n" +
                "                <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                    <tr>\n" +
                "                        <td>&nbsp;</td>\n" +
                "                        <td width=\"3\">&nbsp;</td>\n" +
                "                        <td width=\"10\" align=\"center\">\n" +
                "                            <img src=\"/img/icon/print.gif\" title=\"打印\"\n" +
                "                                 onClick=\"printkb();\" style=\"cursor:hand\" id=\"btprint\"></td>\n" +
                "                        <td width=\"3\">&nbsp;</td>\n" +
                "\n" +
                "                        <td width=\"5\"></td>\n" +
                "\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "        <tr>\n" +
                "            <td class=\"Linetop\"></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"titleTop1\">\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                    <tr>\n" +
                "                        <td class=\"fieldName\">学年学期:</td>\n" +
                "                        <td>&nbsp;</td>\n" +
                "                        <td>\n" +
                "                            <select name=\"zxjxjhh\">\n" +
                "\n" +
                "                                <option value=\"2015-2016-1-2\">2015-2016学年秋(三学期)</option>\n" +
                "\n" +
                "                                <option value=\"2015-2016-2-2\">2015-2016学年春(三学期)</option>\n" +
                "\n" +
                "                                <option value=\"2016-2017-1-2\">2016-2017学年秋(三学期)</option>\n" +
                "\n" +
                "                                <option value=\"2016-2017-2-2\">2016-2017学年春(三学期)</option>\n" +
                "\n" +
                "                                <option value=\"2016-2017-3-2\">2016-2017学年夏(三学期)</option>\n" +
                "\n" +
                "                            </select>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"temp\">\n" +
                "                        <tr>\n" +
                "                            <td height=\"10\"></td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                            <td>\n" +
                "                                <img src=\"/img/search.gif\"\n" +
                "                                     onclick=\"sylnkcCX();return false;\" id=\"btnSearch\" style=\"cursor:hand;\" title=\"\">\n" +
                "                            </td>\n" +
                "\n" +
                "                        </tr>\n" +
                "\n" +
                "                    </table>\n" +
                "\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "    <!-- 分割线 -->\n" +
                "    <table width=\"99%\" border=\"0\" align=\"center\" cellpadding=\"0\"\n" +
                "           cellspacing=\"0\">\n" +
                "        <tr>\n" +
                "            <td class=\"Line\"></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "    <span id=\"dayin\">\n" +
                "\t<table width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=\"titleTop2\">\n" +
                "\t\t\t\t\t <tr>\n" +
                "\t\t\t\t\t  <td class=\"pageAlign\">\n" +
                "\t\t\t\t\t   <table cellpadding=\"0\" width=\"100%\" class=\"displayTag\" cellspacing=\"0\" border=\"1\" id=\"user\">\n" +
                "\t\t\t\t\t    <thead>\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t    <td width=\"4%\" class=\"sortable\">&nbsp;</td>\n" +
                "\t    \t\t\t<td width=\"12%\" class=\"sortable\">&nbsp;</td>\t\t\t\t\n" +
                "\t\t    \n" +
                "\t\t    <td width=\"12%\" class=\"sortable\"><div align=\"center\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t星期一\n" +
                "\t\t\t\n" +
                "\t\t\t</div></td>\n" +
                "\t\t    \n" +
                "\t\t    <td width=\"12%\" class=\"sortable\"><div align=\"center\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t星期二\n" +
                "\t\t\t\n" +
                "\t\t\t</div></td>\n" +
                "\t\t    \n" +
                "\t\t    <td width=\"12%\" class=\"sortable\"><div align=\"center\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t星期三\n" +
                "\t\t\t\n" +
                "\t\t\t</div></td>\n" +
                "\t\t    \n" +
                "\t\t    <td width=\"12%\" class=\"sortable\"><div align=\"center\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t星期四\n" +
                "\t\t\t\n" +
                "\t\t\t</div></td>\n" +
                "\t\t    \n" +
                "\t\t    <td width=\"12%\" class=\"sortable\"><div align=\"center\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t星期五\n" +
                "\t\t\t\n" +
                "\t\t\t</div></td>\n" +
                "\t\t    \n" +
                "\t\t    <td width=\"12%\" class=\"sortable\"><div align=\"center\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t星期六\n" +
                "\t\t\t\n" +
                "\t\t\t</div></td>\n" +
                "\t\t    \n" +
                "\t\t    <td width=\"12%\" class=\"sortable\"><div align=\"center\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t星期日\n" +
                "\t\t\t\n" +
                "\t\t\t</div></td>\n" +
                "\t\t    \n" +
                "\t\t<tr>\n" +
                "\n" +
                "\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t<td width=\"3%\" rowspan=\"4\">&nbsp;<p class=\"style4\">上午</p></td>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第1节(0800-0850)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    大学英语二级_13(北校区综合楼0407)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    高等数学A(一)_07(北校区综合楼0501)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    线性代数_03(北校区综合楼0217)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    高等数学A(一)_07(北校区综合楼0501)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第2节(0900-0950)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    大学英语二级_13(北校区综合楼0407)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    高等数学A(一)_07(北校区综合楼0501)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    线性代数_03(北校区综合楼0217)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    高等数学A(一)_07(北校区综合楼0501)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第3节(1010-1100)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    高等数学A(一)_07(北校区综合楼0501)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    线性代数_03(北校区综合楼0217)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    工程制图基础_01(北校区综合楼阶2)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    大学英语二级_13(北校区综合楼0407)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    计算机应用基础（一）_21(北校区综合楼0501)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第4节(1110-1200)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    高等数学A(一)_07(北校区综合楼0501)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    线性代数_03(北校区综合楼0217)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    工程制图基础_01(北校区综合楼阶2)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    大学英语二级_13(北校区综合楼0407)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    计算机应用基础（一）_21(北校区综合楼0501)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\t    <td colspan=\"9\">&nbsp;<p align=\"center\" class=\"td2 style5\"><strong>午 休</strong></p></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t<td width=\"3%\" rowspan=\"4\">&nbsp;<p class=\"style4\">下午</p></td>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第5节(1430-1520)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    自动化概论_01(北校区主楼307)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    工程制图基础_01(北校区综合楼阶2)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    思想道德修养与法律基础_01(北校区综合楼0315)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第6节(1530-1620)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    自动化概论_01(北校区主楼307)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    工程制图基础_01(北校区综合楼阶2)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    思想道德修养与法律基础_01(北校区综合楼0315)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第7节(1640-1730)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    军事理论_09(北校区研究生楼405)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    思想道德修养与法律基础_01(北校区综合楼0315)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第8节(1740-1830)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t    军事理论_09(北校区研究生楼405)<br>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\t    <td colspan=\"9\">&nbsp;<p align=\"center\" class=\"td2 style5\"><strong>晚饭</strong></p></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t<td width=\"3%\" rowspan=\"3\">&nbsp;<p class=\"style4\">晚上</p></td>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第9节(1900-1950)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第10节(2000-2050)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t<tr bgcolor=\"#FFFFFF\">\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t \t<td width=\"11%\">第11节(2100-2150)</td>\n" +
                "\t \t\n" +
                "\t \t  \n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t\n" +
                "\t\t      <td>&nbsp;\n" +
                "\t\t\n" +
                "\t\t\t&nbsp;\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\n" +
                "            </td>\n" +
                "\t</tr>\n" +
                "\t\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</span>\n" +
                "</form>\n" +
                "<!-- 课程列表 -->\n" +
                "\n" +
                "\n" +
                "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"titleTop2\" id=\"kclb\">\n" +
                "    <tr>\n" +
                "        <td class=\"pageAlign\">\n" +
                "            <table cellpadding=\"0\" width=\"100%\" class=\"displayTag\" cellspacing=\"1\" border=\"0\" id=\"user\">\n" +
                "                <thead>\n" +
                "                <tr>\n" +
                "                    <th width=\"11%\" class=\"sortable\"> 培养方案</th>\n" +
                "                    <th width=\"6%\" class=\"sortable\">课程号</th>\n" +
                "                    <th width=\"11%\" class=\"sortable\"> 课程名</th>\n" +
                "                    <th width=\"4%\" class=\"sortable\"> 课序</th>\n" +
                "                    <th width=\"4%\" class=\"sortable\"> 学分</th>\n" +
                "                    <th width=\"6%\" class=\"sortable\">课程属性</th>\n" +
                "                    <th width=\"6%\" class=\"sortable\">考试类型</th>\n" +
                "                    <th width=\"8%\" class=\"sortable\">教师</th>\n" +
                "\n" +
                "                    <th width=\"5%\" class=\"sortable\"> 修读方式</th>\n" +
                "                    <th width=\"5%\" class=\"sortable\">选课状态</th>\n" +
                "                    <th width=\"4%\" class=\"sortable\"> 周次</th>\n" +
                "                    <th width=\"4%\" class=\"sortable\"> 星期</th>\n" +
                "                    <th width=\"4%\" class=\"sortable\"> 节次</th>\n" +
                "                    <th width=\"4%\" class=\"sortable\">持续节次</th>\n" +
                "                    <th width=\"6%\" class=\"sortable\">校区</th>\n" +
                "                    <th width=\"6%\" class=\"sortable\">教学楼</th>\n" +
                "                    <th width=\"6%\" class=\"sortable\">教室</th>\n" +
                "                </tr>\n" +
                "                </thead>\n" +
                "                <tbody>\n" +
                "\n" +
                "\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n";
        Document document=Jsoup.parse(html);
        Elements element = document.getElementsByTag("td");
        String string = element.get(18).text();
        string = string.replaceAll(" ",",");
        string = string.replaceAll(" ,","");
        string = string.replaceAll("星期一,星期二,星期三,星期四,星期五,星期六,星期日,上午,","");
        string = string.replaceAll("午,休,下午,","");
        string = string.replaceAll(",晚饭,晚上,第9节\\(1900-1950\\),第10节\\(2000-2050\\),第11节\\(2100-2150\\),","");
        System.out.print(string);
    }

}
