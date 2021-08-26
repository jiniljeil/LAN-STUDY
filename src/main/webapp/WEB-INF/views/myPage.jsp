<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>

	#myController{
		width: 70vw;
		margin: auto;
	}
	 .point{
	   color: #a1c48f;
	 }
	 #myInfoContainer{
	 	border:none;
	 	border-radius: 10px;
	 	background: white;
	 	padding: 10px;
	 	padding-left: 30px;
	 	width: 30vw;
	 	min-width: 400px;
	 	margin-bottom: 30px;
	 }
	 button{
	 	border: none;
	 	border-radius: 10px;
	 	width: 100px;
	 	height: 30px;
	 }
	 .delete{
	 	background: #e8b2a9;
	 	//margin-bottom: 10px;
	 	display: inline-block;
	 }
	 .delete:hover{
	 	background: #db9a8f;
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
    	<div id="myInfoContainer">
		<h4>이름 : ${user.name}</h4>
		
		<h4>ID : ${user.user_id}</h4>
		
		<h4>이메일 : ${user.email}</h4>
		
		<h4>전화번호 : ${user.phone}</h4>
		
		</div>
		
		<button type="button" class="delete" id="delete">탈퇴하기</button>
		
		
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

<script>
	$("#delete").click(function(){
		var confirmflag = confirm("해당 계정으로 활동한 모든 정보가 사라지며 복구할 수 없습니다.\n그래도 삭제하시겠습니까?");

        if(confirmflag){
        	$(location).attr('href', './deleteUser');
           //확인 버튼 클릭 true 

        }else{

        }//취소 버튼 클릭 
	
	});
</script>