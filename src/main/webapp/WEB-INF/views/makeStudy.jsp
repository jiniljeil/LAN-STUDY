<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LAN STUDY : 스터디 그룹 생성 </title>
<style>
	 .point{
	   color: #a1c48f;
	 }
	#makeGroupBox{
		width: 70vw;
		margin: auto;
		padding: 50px;
		box-sizing: border-box;
	}
	#makeGroupBox input, textarea, button{
		border: 0;
		border-radius: 10px;
		width: 250px;
		height: 40px;
		margin: 10px;
		Padding: 5px;
		font-size: 15px;
	}
	#makeGroupBox textarea{
		width: 500px;
		height: 100px;
		padding-top: 20px;
	}
	#makeGroupBox button{
		background: #a1c48f;
	}	
	#makeGroupBox button:hover{
		background: #90b37e;
	}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" />
	<div style="height: 80px"></div>
	<div id="makeGroupBox">
	<h2><span class="point">스터디</span>를 만들어보세요 :)</h2>
	<form action="makeGroupOk" method="post">
		<input type="text" name="name" placeholder="스터디의 이름을 적어주세요" required><br>
		<textarea name="detail" placeholder ="스터디 설명을 적어주세요" required></textarea><br>
		<button> 작성완료</button>
		
	</form>
	</div>
</body>
</html>