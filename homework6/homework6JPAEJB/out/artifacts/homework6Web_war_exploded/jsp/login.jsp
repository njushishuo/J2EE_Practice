<%@ page import="tools.AttrStrings" %><%--
  Created by IntelliJ IDEA.
  User: ss14
  Date: 2017/2/17
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <meta charset="UTF-8">
    <title>标准</title>
</head>
<body>
<%
    Integer visitorCnt= (Integer) application.getAttribute(AttrStrings.visitorCountAttr);
    Integer userCnt= (Integer) application.getAttribute(AttrStrings.userCountAttr);
    Integer sumCnt= (Integer) application.getAttribute(AttrStrings.sumCountAttr);
%>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h1>欢迎</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form method="post" role="form" action="<%=  AttrStrings.contextRoot %>/Login">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" name="username" id="username" >
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" name="password" id="password">
            </div>
            <button type="submit" class=" btn btn-default">用户登陆</button>
        </form>

        <span >没有账号？</span>
        <a href="<%=  AttrStrings.contextRoot %>/visitor">游客登陆</a>
    </div>
</div>
<div class = "row">
    <div class="col-md-12">
        <p>总人数: <%= sumCnt %></p>
        <p>已登陆人数:<%= userCnt %> </p>
        <p>游客人数: <%= visitorCnt %></p>
    </div>
</div>
</body>
</html>
