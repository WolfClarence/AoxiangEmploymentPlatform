<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/11/29
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>管理员管理页面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet"  href="<c:url value="/static/css/common.css"/>">
    <link rel="stylesheet"  href="<c:url value="/static/css/myCssForAdminLogin.css"/>">
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div style="width: 100%;height: 700px;">
    <div class="left_nav">
        <div class="bigLabel">
            翱翔招聘
        </div>

        <ul>
            <li><a href="#">用户管理</a></li>
            <li><a href="#">岗位管理</a></li>
            <li><a href="#">岗位种类管理</a></li>
            <li><a href="#">目前在线用户</a></li>
        </ul>
    </div>
    <div class="main">
        <div class="top_nav">
            <div class="person">
                <img src="static/image/bgMain.png" style="width: 50px;height: 50px; border-radius: 50px;" alt="xixix">
                个人中心
            </div>
            <ul>
                <li><a href="#">添加新项</a></li>
                <li><a href="#">添加新项</a></li>
                <li><a href="#">添加新项</a></li>
            </ul>
        </div>
        <div class="blank">
            <h1>这是管理员管理页，内容丰富，但是只有聪明人可以看到</h1>
        </div>
    </div>
</div>
<div class="footer">
    <p>我是footer</p>
</div>

</body>
</html>
