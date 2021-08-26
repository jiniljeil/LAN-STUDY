<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<script src="https://code.jquery.com/jquery-latest.min.js"></script>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/header.css">
		<style>
		</style>
	</head>
		<header>
			<div class="header_logo">
			<br>
			</div>
			<a href="<%=request.getContextPath()%>/logout">
			<div class="header_nav">
				<span class="header_innav">로그아웃</span>
			</div>
			</a>
			<a href="<%=request.getContextPath()%>/myPage">
			<div class="header_nav">
				<span class="header_innav">마이페이지</span>
			</div>
			</a>
			<a href="<%=request.getContextPath()%>/menu">
			<div class="header_nav">
				<span class="header_innav">메인 메뉴</span>
			</div>
			</a>
		</header>
</html>

<script>

	$(".header_logo").click(function(){
		document.location.href = "<%=request.getContextPath()%>/menu";
	});
</script>