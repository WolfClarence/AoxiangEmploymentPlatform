<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/10
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="index-banner-top">
    <c:out value="${username}"/>
</div>
</body>
<style>
    .index-banner-top {
        width: 100%;
        background: url("../../../static/image/banner.png") center/cover;
        height: 50px;
    }
</style>
</html>
