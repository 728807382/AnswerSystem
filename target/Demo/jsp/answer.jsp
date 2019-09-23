<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>答疑页面</title>
    <meta charset="UTF-8">
    <style type="text/css">
        * {
            padding: 0px;
            margin: 0px;
            color: #fff;
        }
        body {
            width: 100%;
            height: 100%;
            background-color: #414141;
        }

        .question_title{
            height: 10%;
            display: flex;
            flex-direction: row;
            align-items: center;
            padding-left: 20px;
        }

        .question_des{
            height: 40%;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .question_po{
            font-size: 25px;
            font-weight: bold;
        }

        .question_title_content {
            font-size: 28px;
        }

        .question_des_content{
            width: 90%;
            height: 90%;
            font-size: 20px;
            color: #fff;
            text-indent: 2em;
            line-height: 30px;
        }
        .button{
			width: 145px;
		    height: 40px;
		    border: 1px solid #fff;
		    background: none;
		    font-size:20px;
		    color: #fff;
		    cursor: pointer;
		}
		.button:hover{
   			 background: rgba(255,255,255,.25);
		}
		input:focus{
		    outline: none;
		}
		.answer_box{
			width: 100%;
			height: 40%;
			
		}
		.answer_content{
		    font-size: 18px;
		    background: none;
		    border-bottom: 1px solid #fff;
		    color: #fff;
		}
		.button_box{
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			height: 200px;
			width: 200px;
		}
		form {
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
		}
		#button1{
			margin-bottom: 15px;
		}
		#button2{
			margin-top: 15px;
		}
    </style>
	<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("form").submit(function(e){
				alert("答疑内容提交成功");
			});
		});
	</script>
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
<div class="answer_box">
		<form action="question/updateById.action" method="POST">
			<div class="text">
				<textarea cols="80" rows="14" name="answer_des" class="answer_content" placeholder="输入答疑内容">
				</textarea>
			</div>
			<div class="button_box">
				<div><input type="submit" id="button1" class="button" value="提交" ></div>
				<div><input type="reset" id="button2" class="button" value="清空"></div>
				<input type="text" name="teacher_id" value="${teacher.teacher_id}" style="display: none;">
				<input type="text" name="question_id" value="${question.question_id}" style="display: none;">
			</div>
		</form>
	</div>

</body>
</html>