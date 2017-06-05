<html>
<head>
    <link href="/css/newcss/project.css" rel="stylesheet" type="text/css">
    <title>历年学期课表查询</title>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="overflow:auto;">
<form action="" name="form" method="post">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td class="Linetop"></td>
        </tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title" id="tblHead">
        <tr>
            <td width="50%">
                <table border="0" align="left" cellpadding="0" cellspacing="0">
                    <tr>
                        <td>&nbsp;</td>
                        <td valign="middle">&nbsp;<b>历年学期课</b>&nbsp;</td>
                    </tr>
                </table>
            </td>
            <td width="50%">

                <table border="0" align="left" cellpadding="0" cellspacing="0" width="100%">
                    <tr>
                        <td>&nbsp;</td>
                        <td width="3">&nbsp;</td>
                        <td width="10" align="center">
                            <img src="/img/icon/print.gif" title="打印"
                                 onClick="printkb();" style="cursor:hand" id="btprint"></td>
                        <td width="3">&nbsp;</td>

                        <td width="5"></td>

                    </tr>
                </table>

            </td>
        </tr>
    </table>
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td class="Linetop"></td>
        </tr>
    </table>
    <table border="0" cellpadding="0" cellspacing="0" class="titleTop1">
        <tr>
            <td>
                <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td class="fieldName">学年学期:</td>
                        <td>&nbsp;</td>
                        <td>
                            <select name="zxjxjhh">

                                <option value="2015-2016-1-2">2015-2016学年秋(三学期)</option>

                                <option value="2015-2016-2-2">2015-2016学年春(三学期)</option>

                                <option value="2016-2017-1-2">2016-2017学年秋(三学期)</option>

                                <option value="2016-2017-2-2">2016-2017学年春(三学期)</option>

                                <option value="2016-2017-3-2">2016-2017学年夏(三学期)</option>

                            </select>
                        </td>
                    </tr>
                    <table align="center" border="0" cellpadding="0" cellspacing="0" id="temp">
                        <tr>
                            <td height="10"></td>
                        </tr>
                        <tr>
                            <td>
                                <img src="/img/search.gif"
                                     onclick="sylnkcCX();return false;" id="btnSearch" style="cursor:hand;" title="">
                            </td>

                        </tr>

                    </table>

                </table>
            </td>
        </tr>
    </table>

    <!-- 分割线 -->
    <table width="99%" border="0" align="center" cellpadding="0"
           cellspacing="0">
        <tr>
            <td class="Line"></td>
        </tr>
    </table>

    <span id="dayin">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" class="titleTop2">
					 <tr>
					  <td class="pageAlign">
					   <table cellpadding="0" width="100%" class="displayTag" cellspacing="0" border="1" id="user">
					    <thead>
							<tr>
				    <td width="4%" class="sortable">&nbsp;</td>
	    			<td width="12%" class="sortable">&nbsp;</td>

		    <td width="12%" class="sortable"><div align="center">

			星期一

			</div></td>

		    <td width="12%" class="sortable"><div align="center">

			星期二

			</div></td>

		    <td width="12%" class="sortable"><div align="center">

			星期三

			</div></td>

		    <td width="12%" class="sortable"><div align="center">

			星期四

			</div></td>

		    <td width="12%" class="sortable"><div align="center">

			星期五

			</div></td>

		    <td width="12%" class="sortable"><div align="center">

			星期六

			</div></td>

		    <td width="12%" class="sortable"><div align="center">

			星期日

			</div></td>

		<tr>


		<tr bgcolor="#FFFFFF">

		<td width="3%" rowspan="4">&nbsp;<p class="style4">上午</p></td>


	 	<td width="11%">第1节(0800-0850)</td>


		      <td>&nbsp;


		    大学英语二级_13(北校区综合楼0407)<br>


			</td>

		      <td>&nbsp;


		    高等数学A(一)_07(北校区综合楼0501)<br>


			</td>

		      <td>&nbsp;


		    线性代数_03(北校区综合楼0217)<br>


			</td>

		      <td>&nbsp;


		    高等数学A(一)_07(北校区综合楼0501)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		<tr bgcolor="#FFFFFF">


	 	<td width="11%">第2节(0900-0950)</td>


		      <td>&nbsp;


		    大学英语二级_13(北校区综合楼0407)<br>


			</td>

		      <td>&nbsp;


		    高等数学A(一)_07(北校区综合楼0501)<br>


			</td>

		      <td>&nbsp;


		    线性代数_03(北校区综合楼0217)<br>


			</td>

		      <td>&nbsp;


		    高等数学A(一)_07(北校区综合楼0501)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		<tr bgcolor="#FFFFFF">


	 	<td width="11%">第3节(1010-1100)</td>


		      <td>&nbsp;


		    高等数学A(一)_07(北校区综合楼0501)<br>


			</td>

		      <td>&nbsp;


		    线性代数_03(北校区综合楼0217)<br>


			</td>

		      <td>&nbsp;


		    工程制图基础_01(北校区综合楼阶2)<br>


			</td>

		      <td>&nbsp;


		    大学英语二级_13(北校区综合楼0407)<br>


			</td>

		      <td>&nbsp;


		    计算机应用基础（一）_21(北校区综合楼0501)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		<tr bgcolor="#FFFFFF">


	 	<td width="11%">第4节(1110-1200)</td>


		      <td>&nbsp;


		    高等数学A(一)_07(北校区综合楼0501)<br>


			</td>

		      <td>&nbsp;


		    线性代数_03(北校区综合楼0217)<br>


			</td>

		      <td>&nbsp;


		    工程制图基础_01(北校区综合楼阶2)<br>


			</td>

		      <td>&nbsp;


		    大学英语二级_13(北校区综合楼0407)<br>


			</td>

		      <td>&nbsp;


		    计算机应用基础（一）_21(北校区综合楼0501)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

			<tr bgcolor="#FFFFFF">
			    <td colspan="9">&nbsp;<p align="center" class="td2 style5"><strong>午 休</strong></p></td>
			</tr>

		<tr bgcolor="#FFFFFF">

		<td width="3%" rowspan="4">&nbsp;<p class="style4">下午</p></td>


	 	<td width="11%">第5节(1430-1520)</td>


		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;


		    自动化概论_01(北校区主楼307)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;


		    工程制图基础_01(北校区综合楼阶2)<br>


			</td>

		      <td>&nbsp;


		    思想道德修养与法律基础_01(北校区综合楼0315)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		<tr bgcolor="#FFFFFF">


	 	<td width="11%">第6节(1530-1620)</td>


		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;


		    自动化概论_01(北校区主楼307)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;


		    工程制图基础_01(北校区综合楼阶2)<br>


			</td>

		      <td>&nbsp;


		    思想道德修养与法律基础_01(北校区综合楼0315)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		<tr bgcolor="#FFFFFF">


	 	<td width="11%">第7节(1640-1730)</td>


		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;


		    军事理论_09(北校区研究生楼405)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;


		    思想道德修养与法律基础_01(北校区综合楼0315)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		<tr bgcolor="#FFFFFF">


	 	<td width="11%">第8节(1740-1830)</td>


		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;


		    军事理论_09(北校区研究生楼405)<br>


			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

			<tr bgcolor="#FFFFFF">
			    <td colspan="9">&nbsp;<p align="center" class="td2 style5"><strong>晚饭</strong></p></td>
			</tr>

		<tr bgcolor="#FFFFFF">

		<td width="3%" rowspan="3">&nbsp;<p class="style4">晚上</p></td>


	 	<td width="11%">第9节(1900-1950)</td>


		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		<tr bgcolor="#FFFFFF">


	 	<td width="11%">第10节(2000-2050)</td>


		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		<tr bgcolor="#FFFFFF">


	 	<td width="11%">第11节(2100-2150)</td>


		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

		      <td>&nbsp;

			&nbsp;

			</td>

            </td>
	</tr>

</table>
</td>
</tr>
</table>
</span>
</form>
<!-- 课程列表 -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" class="titleTop2" id="kclb">
    <tr>
        <td class="pageAlign">
            <table cellpadding="0" width="100%" class="displayTag" cellspacing="1" border="0" id="user">
                <thead>
                <tr>
                    <th width="11%" class="sortable"> 培养方案</th>
                    <th width="6%" class="sortable">课程号</th>
                    <th width="11%" class="sortable"> 课程名</th>
                    <th width="4%" class="sortable"> 课序</th>
                    <th width="4%" class="sortable"> 学分</th>
                    <th width="6%" class="sortable">课程属性</th>
                    <th width="6%" class="sortable">考试类型</th>
                    <th width="8%" class="sortable">教师</th>

                    <th width="5%" class="sortable"> 修读方式</th>
                    <th width="5%" class="sortable">选课状态</th>
                    <th width="4%" class="sortable"> 周次</th>
                    <th width="4%" class="sortable"> 星期</th>
                    <th width="4%" class="sortable"> 节次</th>
                    <th width="4%" class="sortable">持续节次</th>
                    <th width="6%" class="sortable">校区</th>
                    <th width="6%" class="sortable">教学楼</th>
                    <th width="6%" class="sortable">教室</th>
                </tr>
                </thead>
                <tbody>


                </tbody>
            </table>

        </td>
    </tr>
</table>
</body>
</html>
