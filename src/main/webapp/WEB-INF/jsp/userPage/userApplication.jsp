<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/4
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>招聘信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navigation.css">
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<c:import url="../component/userBanner.jsp"/>
<div class="wrapper">
    <div class="sidebar">
        <div class="title">用户菜单</div>
        <ul class="nav">
            <li>
                <a href="/job">
                    <i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i>
                    招聘信息
                </a>
            </li>
            <li>
                <a class="active">
                    <i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                    我的申请
                </a>
            </li>
            <li>
                <a href="/resume">
                    <i class="glyphicon glyphicon-tasks" aria-hidden="true"></i>
                    我的简历
                </a>
            </li>
            <li>
                <a href="/login">
                    <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                    退出
                </a>
            </li>
        </ul>
    </div>
    <div class="content content-is-open">
        <ul class="list-unstyled">
            <c:forEach items="${applicationList}" var="application">
                <li class="show-list-item">
                    <div>
                        <span>${application.job.name} ${application.job.company} ${application.job.area} </span>
                        <span style="position:fixed;right: 50px">${application.status}</span>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<c:import url="../component/staticFooter.jsp"/>
</body>
<style>
    .show-list-item{
        font-size: 20px;
        color: #4cae4c;
        margin: 8px;
    }
    .show-list-item div{
        background: linear-gradient(to right, #d5d20c, #c9dda0) center/cover;
        width: 100%;
        height: 50px;
        color: #5bc0de;
        padding: 10px;
        font-size: 25px;
    }
</style>
</html>
