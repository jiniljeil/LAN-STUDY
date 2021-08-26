<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
	<head>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
		<style>
			i{
				margin-top: 5px;
				font-size: 35px;
			}
			.menu_container{
				height: 100%;
				//padding-top: 10%;
				padding: calc( 10vh + 40px) 0% 10vh 0%;
				box-sizing: border-box;
			}
			.menu_row{
				max-width: 1200px;
				width: 70vw;
				margin: auto;
				height: 100%;
			}
			.menu{
				width: 29%;
				max-height: 300px;
				min-width: 250px;
				height: 100%;
				border-radius: 30px;
				display: inline-block;
				background: #90b37e;
				margin-left: 25px;
				margin-top: 15vh;
				text-align: center;
				vertical-align: middle;
				font-size: 30px;
				color: white;
				box-sizing: border-box;
				padding: 12vh 0;
				//box-shadow: 2px 2px 8px 1px grey;
			}
			#m1{
				background: #f0cb9c;
			}
			#m2{
				background: #f2cbd3;
			}
			#m3{
				background: #9cccf0;
			}
			.menu:hover{
			   animation: pulse 1s infinite;
			   transition: .3s;
			   /*box-shadow: 2px 2px grey;*/
			 }
			 @keyframes pulse {
			   0% {
			     transform: scale(1);
			   }
			   70% {
			     transform: scale(.9);
			   }
			     100% {
			     transform: scale(1);
			   }
		</style>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/header.jsp" />
		<div class="menu_container">
			<div class="menu_row">
				<a href="./groupList">
				<div class="menu" id="m1">
					내 스터디<br>
					<i class="fas fa-chalkboard-teacher"></i>
				</div>
				</a>
				<a href="./join_study">
				<div class="menu" id="m2">
					스터디 참여<br>
					<i class="fas fa-book"></i>
					
				</div>
				</a>
				<a href="./make_study">
				<div class="menu" id="m3">
					스터디 개설<br>
					<i class="fas fa-pencil-alt"></i>
				</div>
				</a>
			</div>
		</div>
	</body>
</html>