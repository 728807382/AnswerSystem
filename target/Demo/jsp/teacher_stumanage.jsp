<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/teacher_stumanage.css">
</head>
<body>
<div class="add_student">
    <div class="title">Online Q & A——添加学生模块</div>
    <div class="add">
        <form action="AddContact.action" method="POST">
            <input type="text" class="input" name="student_id" placeholder="输入账号">
            <input type="text" class="input" name="student_name" placeholder="输入姓名">
            <input type="text" name="teacher_id" value="${teacher_id}" style="display: none;float: left;">
            <input type="submit" value="添加" class="button">
        </form>
    </div>
</div>
<div class="show_student">
    <div class="title">Online Q & A——展示学生模块</div>
    <div class="show_table">
        <table>
            <tr>
                <td>ID</td>
                <td>姓名</td>
                <td>性别</td>
                <td>电话号码</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${studentList}" var="item">
                <form action="DeleteContact.action" method="POST">
                    <tr>
                        <td>${item.student_id}</td>
                        <td>${item.student_name}</td>
                        <td>${item.student_sex}</td>
                        <td>${item.student_phone}</td>
                        <td><input type="submit" name="delete" value="删除" class="button">
                            <input type="text" name="student_id" value="${item.student_id}" style="display: none;">
                            <input type="text" name="teacher_id" value="${teacher_id}" style="display: none;">
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>