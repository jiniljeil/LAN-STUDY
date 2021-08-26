<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<style>

	#myController{
		width: 70vw;
		margin: auto;
	}
	 .point{
	   color: #a1c48f;
	 }
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div style="height: 100px"></div>
	
	<div id="myController">
	<h1>
     		<span class="point">내</span> 정보 <i class="fas fa-user-cog point"></i>
    </h1>
    	<div style="height: 10px"></div>
		<h4>이름 : ${user.name}</h4>
		
		<h4>ID : ${user.user_id}</h4>
		
		<h4>이메일 : ${user.email}</h4>
		
		<h4>전화번호 : ${user.phone}</h4>
		
		<!--<h4>Group 목록 </h4>
		<!-- for each -->	
		<!--	<h4>Group Name : </h4>
			<h4>Group Link : </h4>
			<button> Details </button>
			
		<button> 수정 </button>
		<button> 회원탈퇴 </button>-->	
	</div>
	
	
</body>
</html>