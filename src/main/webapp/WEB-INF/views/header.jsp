<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<script src="https://code.jquery.com/jquery-latest.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/header.css">
		<style>
		</style>
	</head>
		<header>
			<div class="header_logo">
			<br>
			</div>
			<a href="./">
			<div class="header_nav">
				<span class="header_innav">로그아웃</span>
			</div>
			</a>
			<a href="./mypage">
			<div class="header_nav">
				<span class="header_innav">마이페이지</span>
			</div>
			</a>
		</header>
</html>

<script>

	$(".header_logo").click(function(){
		document.location.href = "<%=request.getContextPath()%>/menu";
	});
</script>