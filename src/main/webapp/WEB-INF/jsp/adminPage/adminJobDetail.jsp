<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/14
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
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
                <button class="btn" style="margin-left: 0"
                       data-toggle="modal" data-target="#updateModal"
                onclick="update('${job.name}','${job.kind}','${job.company}','${job.area}',
                ${job.min_salary},${job.max_salary},'${job.description}','${job.limit_condition}')">
                    修改职位
                </button>
                <button class="btn" style="margin-left: 20px"
                        data-toggle="modal" data-target="#deleteModal">
                    删除职位
                </button>
                <a href="/admin/jobdetail/employee/${job.id}" style="margin-left: 20px;text-decoration: none">
                    <input type="button" class="btn" value="查看应聘者"/>
                </a>
                <a href="<c:url value="/admin/jobinfo"/>" style="margin-left: 20px">
                    <input type="button" class="btn" value="返回"/>
                </a>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">修改职位</h4>
            </div>
            <div class="modal-body">
                <form action="">
                    名称：
                    <input type="text" name="name" id="name" class="form-control">
                    类别：
                    <select class="form-control" name="kind" id="kind">
                        <c:forEach var="kindItem" items="${kindList}">
                            <option value="${kindItem}">${kindItem}</option>
                        </c:forEach>
                    </select>
                    公司：
                    <input type="text" name="company" id="company" class="form-control">
                    地区：
                    <select class="form-control" name="area" id="area">
                        <c:forEach var="areaItem" items="${areaList}">
                            <option value="${areaItem}">${areaItem}</option>
                        </c:forEach>
                    </select>
                    最小工资：
                    <input type="number" name="min_salary" id="min_salary" class="form-control">
                    最大工资：
                    <input type="number" name="max_salary" id="max_salary" class="form-control">
                    描述：
                    <textarea name="description" id="description" class="form-control"></textarea>
                    要求：
                    <textarea name="limit_condition" id="limit_condition" class="form-control"></textarea>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交修改</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="deleteModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">修改职位</h4>
            </div>
            <div class="modal-body">
                确定要删除职位 ${job.name} 吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <a href="" style="text-decoration: none;color: black">
                    <button type="button" class="btn btn-primary">删除</button>
                </a>
            </div>
        </div>
    </div>
</div>
<c:import url="../component/staticFooter.jsp"/>
</body>
<style>
    body{
        color: black;
    }
    .job-detail-body {
        color: black;
        font: 20px arial, sans-serif;
    }

    .job-detail-item {
        margin: 10px;
    }
    button{
        color: white;
        background: #5bc0de;
    }
    input[type=button]{
        color: white;
        background: #5bc0de;
    }
</style>
<script>
    function update(name,kind,company,area,min_salary,max_salary,description,limit_condition) {
        $("#name").val(name);
        $("#kind").val(kind);
        $("#company").val(company);
        $("#area").val(area);
        $("#min_salary").val(min_salary);
        $("#max_salary").val(max_salary);
        $("#description").val(description);
        $("#limit_condition").val(limit_condition);
    }
</script>
</html>
