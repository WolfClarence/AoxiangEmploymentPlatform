<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/4
  Time: 16:00
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
                <a class="active">
                    <i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i>
                    招聘信息
                </a>
            </li>
            <li>
                <a href="/application">
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
        <form action="/query" method="get">
            <div class="row" style="margin-top: 10px">
                <div class="col-md-3">
                    <div class="col-md-5" style="font-size: 20px;padding-top: 5px">类型:</div>
                    <div class="col-md-1">
                        <select name="kind" style="width: 100px;height: 35px;" class="form-control">
                            <c:forEach var="kindItem" items="${kindList}">
                                <option value="${kindItem}">${kindItem}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="col-md-5" style="font-size: 20px;padding-top: 5px">地点:</div>
                    <div class="col-md-1" >
                        <select name="area" style="width: 100px;height: 35px;" class="form-control">
                            <c:forEach var="areaItem" items="${areaList}">
                                <option value="${areaItem}">${areaItem}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="col-md-5" style="font-size: 20px;padding-top: 5px">关键字:</div>
                    <div class="col-md-1" >
                        <input name="keyword" class="form-control" style="width: 200px">
                    </div>
                </div>
                <div class="col-md-2">
                    <input type="submit" class="btn" style="color: white;background: #5bc0de;margin-left: 20px" value="查询">
                </div>
            </div>
        </form>
        <ul class="list-unstyled">
            <c:forEach items="${jobList}" var="job">
                <li class="show-list-item">
                    <a href="/jobdetail/${job.id}" style="cursor: pointer">
                        <div class="panel panel-success shadow">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-6">
                                            ${job.name} [${job.area}]
                                    </div>
                                    <div class="col-md-6">
                                            ${job.company}
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 12px">
                                    <div class="col-md-6" style="color: #fe574a">${job.min_salary}~${job.max_salary}</div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="row" style="margin-top: 12px">
                                    <div class="col-md-6">${job.kind}</div>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<c:import url="../component/staticFooter.jsp"/>
</body>
<style>
    body{
        color: black;
    }
    .show-list-item{
        font-size: 20px;
        color: #4cae4c;
        margin: 8px;
    }
    a{
        text-decoration: none;
    }
    a:hover{
        color: #50e1bf;
    }
    div.shadow:hover{
        box-shadow: -3px 3px 5px #888888;
    }
    .show-list-item a label{
        background: linear-gradient(to right,royalblue,plum) center/cover;
        width: 100%;
        height: 50px;
        color: #5bc0de;
        padding: 10px;
        font-size: 25px;
    }
    .show-list-item a label:hover{
        background: linear-gradient(to right, #d5d20c, #c9dda0) center/cover;
    }
</style>
</html>
