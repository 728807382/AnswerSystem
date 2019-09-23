<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问题展示</title>
    <meta charset="UTF-8">
    <style type="text/css">
        * {
            padding: 0px;
            margin: 0px;
        }

        body {
            width: 100%;
            height: 100%;
            background-color: #414141;
        }

        .question_title, .answer_time {
            height: 10%;
            width: 100%;
            display: flex;
            flex-direction: row;
            align-items: center;
            padding-left: 20px;
        }

        .question_des, .answer_des {
            height: 40%;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .question_po, .answer_time_content {
            font-size: 25px;
            color: #fff;
            font-weight: bold;
        }

        .question_title_content {
            font-size: 28px;
            color: #fff;
        }

        .question_des_content, .answer_des_content {
            width: 90%;
            font-size: 20px;
            color: #fff;
            text-indent: 2em;
            line-height: 30px;
        }
    </style>
</head>
<body>
<div class="question_title">
    <div class="question_po">来自${student.student_name}的提问:</div>
    <div class="question_title_content">${question.question_title}</div>
</div>
<div class="question_des">
    <div class="question_des_content">
        ${question.question_des}
    </div>
</div>
<c:if test="${question.answer_time!=null}">
<div class="answer_time">
    <div class="answer_time_content">回答时间——${question.answer_time}</div>
</div>
<div class="answer_des">
    <div class="answer_des_content">
        ${question.answer_des}
    </div>
</div>
</c:if>
</body>
</html>