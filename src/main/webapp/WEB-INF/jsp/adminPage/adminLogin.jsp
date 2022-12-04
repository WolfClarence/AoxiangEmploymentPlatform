<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/11/29
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>管理员登录页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/myCssForAdminLogin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="div-out-login">
        <!--form-stars-here-->
        <div class="form-out">
            <h2>翱翔招聘平台</h2>
            <form action="/admin/login.do" method="post">
                <div class="form-sub">
                    <div class="div-icon">
                        <i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                    </div>
                    <input type="email" name="username" placeholder="请输入用户名 " required=""
                           autocomplete="off"/>
                </div>
                <div class="form-sub">
                    <div class="div-icon">
                        <i class="glyphicon glyphicon-lock" aria-hidden="true"></i>
                    </div>
                    <input type="password" name="username" placeholder="请输入密码 " required=""
                           autocomplete="off"/>
                </div>
                <p class="p-bottom">
                    没有翱翔招聘平台账号?
                    <a style="color: #5cb85c" href="#">
                        点击注册
                    </a>
                </p>
                <input type="submit" value="Login">
            </form>
        </div>
    </div>
</div>

<div class="bigLabel">
    <p>翱翔招聘平台</p>
</div>
</body>
</html>

