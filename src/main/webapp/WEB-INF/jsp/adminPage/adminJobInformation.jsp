<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/4
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>招聘信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navigation.css">
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/modal.js"></script>
</head>
<body>
<c:import url="../component/adminBanner.jsp"/>
<div class="wrapper">
    <div class="sidebar">
        <div class="title">管理员菜单</div>
        <ul class="nav">
            <li>
                <a class="active">
                    <i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i>
                    招聘信息
                </a>
            </li>
            <li>
                <a href="/admin/account">
                    <i class="glyphicon glyphicon-tasks" aria-hidden="true"></i>
                    账号管理
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
        <form method="get" action="<c:url value="/admin/query"/>">
            <div class="row" style="margin-top: 10px">
                <div class="col-md-3">
                    <div class="col-md-5" style="font-size: 20px;padding-top: 5px">类型:</div>
                    <div class="col-md-1">
                        <select name="kind"
                                class="form-control"
                                style="width: 100px;height: 35px">
                            <c:forEach var="kindItem" items="${kindList}">
                                <option value="${kindItem}">${kindItem}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="col-md-5" style="font-size: 20px;padding-top: 5px">地点:</div>
                    <div class="col-md-1">
                        <select name="area"
                                class="form-control"
                                style="width: 100px;height: 35px">
                            <c:forEach var="areaItem" items="${areaList}">
                                <option value="${areaItem}">${areaItem}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="col-md-5" style="font-size: 20px;padding-top: 5px">职位关键字:</div>
                    <div class="col-md-1">
                        <input name="keyword" class="form-control" style="width: 200px">
                    </div>
                </div>
                <div class="col-md-2">
                    <input type="submit" class="btn" style="color: white;background: #5bc0de;margin-left: 20px"
                           value="查询">
                </div>
            </div>
        </form>
        <div class="row" style="margin-top: 10px;margin-left: 0">
            <div class="col-md-3">
                <button class="btn" data-toggle="modal" data-target="#addModal"
                        style="color: white;background: #5bc0de">添加职位
                </button>
                <p style="color: red">${msg}</p>
            </div>
        </div>
        <ul class="list-unstyled">
            <c:forEach items="${jobList}" var="job">
                <li class="show-list-item">
                    <a  href="/admin/jobdetail/${job.id}">
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
<div class="modal fade" id="addModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">添加职位</h4>
            </div>
            <div class="modal-body">
                <form action="<c:url value="/admin/job/add"/>">
                    名称：
                    <input type="text" name="name" class="form-control">
                    类别：
                    <select class="form-control" name="kind">
                        <c:forEach var="kindItem" items="${kindList}">
                            <option value="${kindItem}">${kindItem}</option>
                        </c:forEach>
                    </select>
                    公司：
                    <input type="text" name="company" class="form-control">
                    地区：
                    <select class="form-control" name="area">
                        <c:forEach var="areaItem" items="${areaList}">
                            <option value="${areaItem}">${areaItem}</option>
                        </c:forEach>
                    </select>
                    最小工资：
                    <input type="number" name="min_salary" class="form-control">
                    最大工资：
                    <input type="number" name="max_salary" class="form-control">
                    描述：
                    <textarea name="description" id="description" class="form-control"></textarea>
                    要求：
                    <textarea name="limit_condition" id="limit_condition" class="form-control"></textarea>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <input type="submit" class="btn btn-primary" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<c:import url="../component/staticFooter.jsp"/>
</body>
<style>
    body {
        color: black;
    }

    .show-list-item {
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
    .show-list-item a label {
        background: linear-gradient(to right, royalblue, plum) center/cover;
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
