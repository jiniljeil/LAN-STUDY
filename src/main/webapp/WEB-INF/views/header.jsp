<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/header.css">
		<style>
			.logo{
				width: 320px;
				height: 80px;
			    background-size: cover;
			    //padding-top: 5px;
			    display: inline-block;
			}
			.nav{
				display: inline-block;
				width: 100px;
				height: 100%;
				float: right;
				color: white;
				text-align: center;
			}
			.nav:hover{
				background: #90b37e;
			}
			.innav{
				display: inline-block;
				margin-top: 30px;
			}
		</style>
	</head>
	<body>
		<header>
			<div class="logo">
			<br>
			</div>
			<div class="nav">
				<span class="innav">로그아웃</span>
			</div>
			<div class="nav">
				<span class="innav">마이페이지</span>
			</div>
		</header>
	</body>
</html>