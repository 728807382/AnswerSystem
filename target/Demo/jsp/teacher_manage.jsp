<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/teacher_stumanage.css">
</head>
<body>
<div class="show_student">
    <div class="title">Online Q & A——问题库清理模块</div>
    <div class="show_table">
        <table>
            <tr>
                <td>问题标题</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${questionList}" var="item">
                <form action="question/qquestion.action" method="POST">
                    <tr>
                        <td><a href="http://localhost:8080/AnswerSystem_war_exploded/showquestion.action?question_id=${item.question_id}&teacher_id=${teacher_id}">${item.question_title}</a></td>
                        <td>
                            <input type="text" name="question_id" value="${item.question_id}" style=" float:left;display: none">
                            <input type="text" name="teacher_id" value="${teacher_id}" style=" float:left;display: none">
                            <input type="submit" value="删除" class="button">
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>