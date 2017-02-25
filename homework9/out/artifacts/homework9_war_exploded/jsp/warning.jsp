<%--
  Created by IntelliJ IDEA.
  User: ss14
  Date: 2016/12/31
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Exam" %>
<%@ page import="java.util.List" %>
<%@ page import="tools.AttrStrings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ss14" uri="/WEB-INF/tlds/CustomeHandler.tld" %>




<ss14:checklogin></ss14:checklogin>


<%
    List<Exam> unAttendedExams = (List<Exam>) session.getAttribute("unAttendedExams");
    Integer visitorCnt= (Integer) application.getAttribute(AttrStrings.visitorCountAttr);
    Integer userCnt= (Integer) application.getAttribute(AttrStrings.userCountAttr);
    Integer sumCnt= (Integer) application.getAttribute(AttrStrings.sumCountAttr);
%>

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
    <title>警告</title>
</head>
<body>


<div class="row">
    <div class="col-md-12">
        <div class="panel panel-danger">
            <!-- Default panel contents -->
            <div class="panel-heading"><span style="font-size: 20px; ">未参与的测验</span></div>
            <div class="panel-body">
                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>测验Id</th>
                        <th>科目</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                    </tr>
                    </thead>
                    <tbody>
                        <ss14:examList></ss14:examList>
                    </tbody>
                </table>
            </div>
        </div>
        <a  href="/LoginInputAction.action" style="font-size: 40px">注销</a>
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
