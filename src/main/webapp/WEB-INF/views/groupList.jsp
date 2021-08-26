<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
  <head>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <style>
     #i2{
	   /*display:none;*/
	   border:none;
	   border-radius: 10px;
	   margin-bottom: 10px;
	   font-size: 17px;
	   width: 150px;
	   height: 40px;
	   padding: 10px;
	   background: #a1c48f;
	   font-weight: bold;
	   color: white;
	   margin-top: 20px;
	   margin-right: 20px;
	 }
	 .btn_manage{
	 	float: right;
	 	margin-right: 15px;
	 	border:none;
	 	margin-top: 20px;
	 	height: 30px;
	 	border-radius: 10px;
	 	background: #ddd;
	 }
	 .btn_manage:hover{
	 	background: #ccc;
	 }
	 #i2 {
	   animation: pulse 1s infinite;
	   transition: .3s;
	   /*box-shadow: 2px 2px grey;*/
	 }
	 #i2:hover{
	   background: #90b37e;
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
	 }
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
    		overflow: hidden;
    		height: 40px;
    		width: 70%;
    		
    		display: inline-block;
    	}
    	.fa-door-open:hover{
    		color: #a1c48f;
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
     	
     	<c:forEach items="${groupList}" var="u"  >
	     	<div class="group">
	     		<div class="header">
	     			<c:set var="user_id" value="${user_id}" />
	     			<c:set var="manager_id" value="${u.managerId}" />
	     			
	     			<div class="row title">
	     				${u.name} <i class="fas fa-door-open" onclick="location.href='<%=request.getContextPath()%>./board/${u.link}'";></i>
	     			</div>
	     			<div class="row manager">
	     				<i class="fas fa-crown"></i>${u.managerName}<br>
	     				<c:if test="${user_id == manager_id}">
			              <button class="btn_manage" onclick="location.href='<%=request.getContextPath()%>./board/${u.link}/manage/user'">스터디원 관리</button>
			 			</c:if>
	     				
	     			</div>
	     		</div>
	     		<div class="detail">
	     			${u.detail}
	     		</div>
	     	</div>

	     </c:forEach>
	     <c:set var="cnt" value="${groupCnt}" />
			  <c:if test="${groupCnt == 0}">
              <h4 style="color: #444;">현재 가입된 스터디 그룹이 없어요ㅠㅠ<br><br>그룹에 가입하거나 그룹을 만들어보세요:)</h4>
              <button id="i2" onclick="window.location.href='/homePage'">그룹 찾기</button>
              <button id="i2" onclick="window.location.href='/make_study'">그룹 만들기</button>
              </c:if>
     </div>
  </body>
</html>

<script>

</script>
