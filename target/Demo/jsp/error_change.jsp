<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>成功</title>
    <link rel="stylesheet" type="text/css" href="css/success.css">
</head>
<body style="background-color: #414141;">
<div class="div_all">
    <div class="div_a1">
        <div class="circle">
            <img src="img/a.jpg" class="img_1"/>
        </div>
        <div class="text"><a href="teacher_stumanage.action?teacher_id=${teacher_id}" class="CoolPy_text">${errordetail}</a></div>
    </div>

</div>
</body>
</html>