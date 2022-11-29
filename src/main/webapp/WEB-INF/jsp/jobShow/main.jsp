<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/11/28
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>招聘信息展示页</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet"  href="static/css/myCssForMain.css">
    <link rel="stylesheet"  href="static/css/common.css">
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="myContainer">
    <div class="nav">
        <a href="#">哈哈哈</a>
        <a href="#">哈哈哈</a>
        <a href="#">哈哈哈</a>
    </div>
    <div class="form">
        <form style="width: 100%" class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
    <div class="person">
        <img style="height: 50px; width: 50px;margin-left: 20px" src="static/image/bgMain.jpeg" alt="haha">
        <a class="navbar-brand" href="#">个人中心</a>
    </div>
</div>

<div class="mySmallContainer">
    <div class="rotation">
        <img src="static/image/ali.jpg" alt="这应该是一张图片">
        <div class="dots">
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
            <div class="dot"></div>
        </div>
    </div>
    <c:forEach items="${jobs}" var="job" varStatus="jobStatus">
        <div class="jobBlock">
            <h1>${job.getName()}</h1>
            <h3>薪资：${job.getMin_salary()}-${job.getMax_salary()}</h3>
            <h3>要求：${job.getLimit_condition()}</h3>
            <h3>公司：${job.getCompany()}</h3>
        </div>
    </c:forEach>

<div class="myContainer">
    <p style="width: 50% ;text-align: center;margin:10px  auto ;">Copyright © 2015-2019 KUFANYUN.COM. All Rights Reserved. 酷番云 云南酷番云计算有限公司 版权所有
        《中华人民共和国增值电信业务经营许可证》滇B1-20203971    昆公网安备： 53011102000880  滇ICP备18002090号-9  网站地图   </p>
</div>
</body>
</html>
