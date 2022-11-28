<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>翱翔招聘平台</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet"  href="static/css/myCss.css">
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="form">
    <form method="post" action="<c:url value="/login.do"/>">
        <h1>翱翔招聘平台</h1>
        <div class="mb-3">
            <label for="username" class="form-label">用户邮箱</label>
            <input type="email" id="username" class="form-control" name="email" placeholder="用户邮箱">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">用户密码</label>
            <input type="password" id="password" class="form-control" name="password" placeholder="用户密码">
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
    </form>
</div>

<div class="bigLabel">
    <p>翱翔招聘平台欢迎您</p>
</div>


<script>
</script>
</body>
</html>
