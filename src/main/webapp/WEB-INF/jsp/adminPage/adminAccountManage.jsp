<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/4
  Time: 15:14
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
    <script src="${pageContext.request.contextPath}/static/js/modal.js"></script>
</head>
<body>
<c:import url="../component/banner.jsp"/>
<div class="wrapper">
    <div class="sidebar">
        <div class="title">管理员菜单</div>
        <ul class="nav">
            <li>
                <a href="/admin/jobinfo">
                    <i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i>
                    招聘信息
                </a>
            </li>
            <li>
                <a class="active">
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
        <p style="color: red;">${msg}</p>
        <ul class="list-unstyled">
            <c:forEach var="admin" items="${adminList}">
                <li class="show-list-item">
                    <div>
                        <span>用户名：${admin.name}</span>
                        <span style="margin-left: 50px">密码：${admin.password}</span>
                    </div>
                </li>
                <div style="margin-left: 50px">
                    <a href="/admin/account/delete/${admin.name}" style="text-decoration: none;">
                        <button class="btn">删除</button>
                    </a>
                    <button class="btn" data-toggle="modal" data-target="#updateModel"
                            onclick="update('${admin.password}','${admin.name}')">修改密码
                    </button>
                </div>
            </c:forEach>
        </ul>
        <button class="btn" data-toggle="modal" data-target="#addModel">添加管理员
        </button>
        <%--${adminSession}--%>
    </div>
</div>
<div class="modal fade" id="updateModel" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">修改密码</h4>
            </div>
            <div class="modal-body">
                <form action="<c:url value="/admin/account/update"/>">
                    <input type="hidden" id = "name" name="name">
                    新密码：
                    <input type="text" name="newPassword" class="form-control" id="password">
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <input type="submit" class="btn btn-primary" value="提交修改"/>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<div class="modal fade" id="addModel" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">添加管理员</h4>
            </div>
            <div class="modal-body">
                <form action="<c:url value="/admin/account/add"/>">
                    用户名：
                    <input name="name" type="text" class="form-control" id="username">
                    密码：
                    <input name="password" type="text" class="form-control" id="pwd">
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <input type="submit" class="btn btn-primary" style="margin-left: 30px" value="提交">
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<c:import url="../component/footer.jsp"/>
</body>
<style>
    body {
        color: #000;
    }

    .show-list-item {
        font-size: 20px;
        color: #4cae4c;
        margin: 8px;
    }

    .show-list-item div {
        background: linear-gradient(to right, royalblue, plum) center/cover;
        width: 100%;
        height: 50px;
        color: #5bc0de;
        padding: 10px;
        font-size: 25px;
    }
    button{
        background: #5bc0de;
        color: white;
    }
</style>
<script>
    function update(password,name) {
        $("#password").val(password);
        $("#name").val(name);
    }
</script>
</html>
