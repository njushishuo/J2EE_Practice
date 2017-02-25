<%--
  Created by IntelliJ IDEA.
  User: ss14
  Date: 2016/12/31
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Grade" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Exam" %>
<%@ page import="tools.AttrStrings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ss14" uri="/WEB-INF/tlds/CustomeHandler.tld" %>

<!--防止jsp文件自动创建session-->
<%--<%@ page session="false"%>--%>


<ss14:checklogin></ss14:checklogin>



<html>
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
    List<Grade> grades = (List<Grade>) session.getAttribute("grades");
    Integer visitorCnt= (Integer) application.getAttribute(AttrStrings.visitorCountAttr);
    Integer userCnt= (Integer) application.getAttribute(AttrStrings.userCountAttr);
    Integer sumCnt= (Integer) application.getAttribute(AttrStrings.sumCountAttr);
%>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-success">
            <!-- Default panel contents -->
            <div class="panel-heading"><span style="font-size: 20px; ">测验成绩</span></div>
            <div class="panel-body">
                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>测验Id</th>
                        <th>科目</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>分数</th>
                    </tr>
                    </thead>
                    <tbody>

                    <ss14:gradeList></ss14:gradeList>

                    </tbody>
                </table>
            </div>
        </div>
        <a href="/LoginInputAction.action" style="font-size: 40px" >注销</a>
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
