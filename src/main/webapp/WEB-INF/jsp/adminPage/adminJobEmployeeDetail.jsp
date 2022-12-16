<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LonelyWolf
  Date: 2022/12/14
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>职位应聘者</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navigation.css">
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
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
                <a href="<c:url value="/admin/account"/>">
                    <i class="glyphicon glyphicon-tasks" aria-hidden="true"></i>
                    账号管理
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
        <div class="job-detail-body">
                <div class="resume-body">
                    <p class="resume-item">
                        姓名：${resume.name}
                    </p>
                    <p class="resume-item">
                        年龄：${resume.age}
                    </p>
                    <p class="resume-item">
                        性别：${resume.sex}
                    </p>
                    <p class="resume-item">
                        民族：${resume.nation}
                    </p>
                    <p class="resume-item">
                        专业：${resume.profession}
                    </p>
                    <p class="resume-item">
                        求职意向：${resume.intention}
                    </p>
                    <p class="resume-item">
                        毕业院校：${resume.school}
                    </p>
                    <p class="resume-item">
                        手机号：${resume.phone}
                    </p>
                    <p class="resume-item">
                        邮箱：${resume.email}
                    </p>
                    <p class="resume-item">
                        技能：${resume.skill}
                    </p>
                    <p class="resume-item">
                        奖项：${resume.award}
                    </p>
                    <p class="resume-item">
                        社会实践：${resume.practice}
                    </p>
                    <p class="resume-item">
                        自我描述：${resume.description}
                    </p>
                </div>
                <br>
                <br>
                <div>
                    <%--修改状态--%>
                    <p style="color: red">${msg}</p>
                    <form method="post" action="<c:url value="/admin/update/application/${application.id}/${jobId}/${email}"/>">
                        <h2>当前状态：${application.status}</h2>
                        <br>
                        <h2>修改状态：</h2>
                        <select name="status" style="font-size: 20px;width: 120px;height: 30px;color: black">
                            <option value="正在处理">正在处理</option>
                            <option value="约请面试">约请面试</option>
                            <option value="应聘成功">应聘成功</option>
                            <option value="抱歉,已被拒绝">抱歉,已被拒绝</option>
                        </select>
                        <input type="submit" value="点击修改" class="btn btn-sm" style="color: white;background: #5bc0de;margin-left: 30px;margin-top: -8px;">
                    </form>

                </div>
                <div style="margin: 10px">
                    <a href="/admin/jobdetail/employee/${jobId}" style="margin-left: 20px">
                        <input type="button" class="btn" style="color: white;background: #5bc0de;" value="返回"/>
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
    .resume-body{
        color: black;
        font:15px arial,sans-serif;
    }
    .resume-item{
        margin: 10px;
        text-align: left;
    }
    p{
        text-align: left;
    }
</style>
</html>
