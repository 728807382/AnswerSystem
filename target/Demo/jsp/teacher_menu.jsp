<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>教师操作页面</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/AnswerSystem_war_exploded/css/student_menu.css">
</head>
<body>
<div class="main">
    <!-- 菜单框 -->
    <div class="menu">
        <div class="img"><img class="img_src" src="http://localhost:8080/AnswerSystem_war_exploded/img/a.jpg"/></div>
        <div class="title">你好，${teacher.teacher_name}老师</div>
        <div>
            <a href="/AnswerSystem_war_exploded/teacherquestionByPoId.action?teacher_id=${teacher.teacher_id}" target="myiframe">
                <input class="button" type="button" value="问题答疑">
            </a>
        </div>

        <div>
            <a href="manage.action?teacher_id=${teacher.teacher_id}" target="myiframe">
                <input class="button" type="button" name="quiz" id="quiz" value="问题管理">
            </a>
        </div>
        <div>
            <a href="teacher_stumanage.action?teacher_id=${teacher.teacher_id}" target="myiframe">
                <input class="button" type="button" name="my_question" id="my_question" value="学生管理">
            </a>
        </div>
        <div>
            <a href="teacherinfo.action?teacher_id=${teacher.teacher_id}" target="myiframe">
                <input class="button" type="button" name="my" id="my" value="个人信息">
            </a>
        </div>
        <div>
            <a href="jsp/login.html">
                <input class="button" type="button" name="my" id="my1" value="注销">
            </a>
        </div>
    </div>

    <!-- 操作框 -->
    <div class="operate">
        <iframe class="frame" name="myiframe"/>
    </div>
</div>
</body>
</html>
