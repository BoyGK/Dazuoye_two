<%--
  Created by IntelliJ IDEA.
  User: 12153
  Date: 2017/5/26
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/upload" method="post">
    <input type="text" name="userid" />
    <input type="file" name="videoFile" />
    <input type="text" name="title" />
    <input type="text" name="subject" />
    <input type="submit">
  </form>
  </body>
</html>
