<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师答疑页面</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/AnswerSystem_war_exploded/css/tearcher_answerquiz.css">
</head>
<body>
<div class="main">
    <div class="display">
        <table>
            <c:forEach items="${questionList}" var="item">
                <tr>
                    <td>
                        <div class="list">
                            <div class="title"><a href="http://localhost:8080/AnswerSystem_war_exploded/showquestion.action?question_id=${item.question_id}&teacher_id=${teacher.teacher_id}">${item.question_title}</a></div>
                            <div class="description">
                                <div class="time">${item.question_time}---</div>
                                    ${item.question_des}
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>