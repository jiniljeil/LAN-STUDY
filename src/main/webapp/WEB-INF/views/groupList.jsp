<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
  <head>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <style>
	     .point{
		   color: #a1c48f;
		 }
    	#myGroupList{
    		width: 70vw;
    		margin: auto;
    	}
    	#myGroupList h1{
    		margin-bottom: 50px;
    	}
    	#myGroupList .fa-crown{
	    	font-size: 20px; 
	    	color: #f5e856; 
	    	margin-right: 10px;
    	}
    	.row{
    		display: inline-block;
    	}
    	.group{
    		border: #a1c48f 3px solid;
    		background: white;
    		border-radius: 20px;
    		margin-bottom: 20px;
    		height: 80px;
    		padding: 20px;
    		box-sizing: box-shadow; 
    	}
    	.manager{
    		float: right;
    	}
    	.title{
    		font-weight: bold;
    		font-size: 22px;
    	}
    	.detail{
    		font-size: 15px;
    		color: #555;
    		margin-top: 15px;
    		margin-bottom: 15px;
    		overflow: scroll;
    		height: 40px;
    	}
    </style>
  </head>
  <body>
     <jsp:include page="/WEB-INF/views/header.jsp" />
     <div style="height:100px"></div>
     <div id="myGroupList">
     	<h1>
     		나의 <span class="point">스터디 그룹 </span><i class="far fa-smile-wink"></i>
     	</h1>
     	
	     	<div class="group" onclick="location.href='<%=request.getContextPath()%>/;">
	     		<div class="header">
	     			<div class="row title">
	     				스터디 그룹 이름
	     			</div>
	     			<div class="row manager">
	     				<i class="fas fa-crown"></i>매니저이름
	     			</div>
	     		</div>
	     		<div class="detail">
	     			이 스터디는 컴공 학생이라면 모두를  참가할 수 있는 자유스터디로 블라블라 설명 이 스터디는 컴공 학생이라면 모두를  참가할 수 있는 자유스터디로 블라블라 설명 이 스터디는 컴공 학생이라면 모두를  참가할 수 있는 자유스터디로 블라블라 설명
	     		</div>
	     	</div>
     </div>
  </body>
</html>

<script>

</script>
