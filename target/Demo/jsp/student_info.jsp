<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>个人信息</title>
	<meta charset="utf-8">
	<style type="text/css">
		*{
			padding: 0px;
			margin:0px;
			color: #fff;
		}
		body{
			height: 100%;
			width: 100%;

		}
		.head{
			height: 25%;
			width: 100%;
			background-color: #4f5067 ;
		}
		.head div{
			font-weight: bold;
			font-size:30px;
			margin-left: 300px;
			padding-top: 50px;
		}
		.foot{
			height: 75%;
			width: 100%;
			background-color: #424242;
		}
		.float{
			height: 50%;
			width: 80%;
			background-color: #b9b9b9;
			position: fixed;
			top: 120px;
			left: 100px;
			border-radius: 25px;
			display: flex;
			justify-content: center;
			align-items: center;
		}
		.detail{
			height: 90%;
			width: 90%;
			display: flex;
			flex-direction: row;
			align-items: center;
		}
		img{
			height: 230px;
			width: 230px;
		}
		.content{
			height: 100%;
			width: 80%;
			display: flex;
			justify-content: center;
			align-items: center;
		}
		.content_box{
			width: 70%;
		}
		.text{
			color: black;
			font-size:25px;
			margin: 30px;
		}
	</style>
</head>
<body>
<div class="head"><div>Online Q & A——个人信息</div></div>
<div class="foot"></div>
<div class="float">
	<div class="detail">
		<div class="photo"><img src="img/b.png"></div>
		<div class="content">
			<div class="content_box">
				<div class="text">账号：${student.student_id}</div>
				<div class="text">姓名：${student.student_name}</div>
				<div class="text">性别：${student.student_sex}</div>
				<div class="text">联系方式：${student.student_phone}</div>
			</div>
		</div>

	</div>
</div>
</body>
</html>