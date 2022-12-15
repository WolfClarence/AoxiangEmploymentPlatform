<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/4
  Time: 16:15
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
                <a href="<c:url value="/job"/>">
                    <i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i>
                    招聘信息
                </a>
            </li>
            <li>
                <a href="<c:url value="/application"/>">
                    <i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                    我的申请
                </a>
            </li>
            <li>
                <a class="active">
                    <i class="glyphicon glyphicon-tasks" aria-hidden="true"></i>
                    我的简历
                </a>
            </li>
            <li>
                <a href="<c:url value="/login"/>">
                    <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                    退出
                </a>
            </li>
        </ul>
    </div>
    <div class="content content-is-open">
        <p style="color: red">${msg eq null ?"":msg}</p>
        <form action="<c:url value="/resume/fix.do"/>" method="post">
            <input name="owner_email" type="hidden" value="${userSession.email}">
            <div class="resume-body">
                <div class="resume-item">
                    姓名：
                    <input class="form-control" name="name" value="${resume.name}">
                </div>
                <div class="resume-item">
                    年龄：
                    <input name="age" type="number" class="form-control" value="${resume.age}">
                </div>
                <div class="resume-item">
                    性别：
                    <select  name="sex" class="form-control">
                        <option value="${resume.sex}">${resume.sex eq 0?'女':'男'}</option>
                        <option value="${resume.sex eq 0? 1:0}">${resume.sex eq 0?'男':'女'}</option>
                    </select>
                </div>
                <div class="resume-item">
                    民族：
                    <input name="nation" type="text" class="form-control" value="${resume.nation}">
                </div>
                <div class="resume-item">
                    专业：
                    <input name="profession" type="text" class="form-control" value="${resume.profession}">
                </div>
                <div class="resume-item">
                    求职意向：
                    <input name="intention" type="text" class="form-control" value="${resume.intention}">
                </div>
                <div class="resume-item">
                    毕业院校：
                    <input name="school" type="text" class="form-control" value="${resume.school}">
                </div>
                <div class="resume-item">
                    手机号：
                    <input name="phone" type="text" class="form-control" value="${resume.phone}">
                </div>
                <div class="resume-item">
                    邮箱：
                    <input name="email" type="text" class="form-control" value="${resume.email}">
                </div>
                <div class="resume-item">
                    技能：
                    <input name="skill" type="text" class="form-control" value="${resume.skill}">
                </div>
                <div class="resume-item">
                    奖项：
                    <input name="award" type="text" class="form-control" value="${resume.award}">
                </div>
                <div class="resume-item">
                    社会实践：
                    <input name="practice" type="text" class="form-control" value="${resume.practice}">
                </div>
                <div class="resume-item">
                    自我描述：
                    <input name="description" type="text" class="form-control" value="${resume.description}">
                </div>
            </div>
            <div style="margin: 10px">
                <input value="提交修改" type="submit" class="btn" style="color: white;background: #5bc0de"/>
                <a href="<c:url value="/resume"/>" style="margin-left: 20px">
                    <input type="button" class="btn" style="color: white;background: #5bc0de;" value="返回"/>
                </a>
            </div>
        </form>

    </div>
</div>
<c:import url="../component/staticFooter.jsp"/>
</body>
<style>
    .resume-body {
        color: black;
        font: 15px arial, sans-serif;
    }

    .resume-item {
        margin: 10px;
    }
</style>
</html>
