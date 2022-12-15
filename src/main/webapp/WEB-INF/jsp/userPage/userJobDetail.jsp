<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/15
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>招聘详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/modal.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navigation.css">
</head>
<body>
<c:import url="../component/banner.jsp"/>
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
        <div class="job-detail-body">
            <div class="panel panel-info job-detail-item">
                <div class="panel-heading">
                    职位名称
                </div>
                <div class="panel-body">
                    ${job.name}
                </div>
            </div>
            <div class="panel panel-info job-detail-item">
                <div class="panel-heading">
                    类别
                </div>
                <div class="panel-body">
                    ${job.kind}
                </div>
            </div>
            <div class="panel panel-info job-detail-item">
                <div class="panel-heading">
                    公司
                </div>
                <div class="panel-body">
                    ${job.company}
                </div>
            </div>
            <div class="panel panel-info job-detail-item">
                <div class="panel-heading">
                    地区
                </div>
                <div class="panel-body">
                    ${job.area}
                </div>
            </div>
            <div class="panel panel-info job-detail-item">
                <div class="panel-heading">
                    薪水
                </div>
                <div class="panel-body">
                    ${job.min_salary}~${job.max_salary}
                </div>
            </div>
            <div class="panel panel-info job-detail-item">
                <div class="panel-heading">
                    描述
                </div>
                <div class="panel-body">
                    <p>
                        ${job.description}
                    </p>
                </div>
            </div>
            <div class="panel panel-info job-detail-item">
                <div class="panel-heading">
                    要求
                </div>
                <div class="panel-body">
                    <p>
                        ${job.limit_condition}
                    </p>
                </div>
            </div>
            <div style="margin: 10px">
                <input type="button" class="btn" value="申请" data-toggle="modal" data-target="#applicationModal"/>
                <a href="<c:url value="/job"/>" style="margin-left: 20px">
                    <input type="button" class="btn" value="返回"/>
                </a>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="applicationModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">申请职位</h4>
            </div>
            <div class="modal-body">
                确定要申请职位 ${job.name} 吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <a href="" style="text-decoration: none;color: black">
                    <button type="button" class="btn btn-primary">确定</button>
                </a>
            </div>
        </div>
    </div>
</div>
<c:import url="../component/footer.jsp"/>
</body>
<style>
    input[type=button]{
        background: #5bc0de;
        color: white;
    }
</style>
</html>
