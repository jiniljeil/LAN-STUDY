<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
  <head>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <style>
	    #groupUserList{
	    		width: 70vw;
	    		margin: auto;
	    	}
    	#groupUserList h1{
    		margin-bottom: 50px;
    	}
    	.point{
		   color: #a1c48f;
		 }
		 .menu{
		 	background: #bad6ae;
		 	border-radius: 5px;
		 }
		 .user{
		 	background: white;
		 	border-radius: 5px;
		 	margin-bottom: 8px;
		 }
		 .row{
		 	display: inline-block;
		 	font-size: 16px;
		 	padding: 10px 1px 10px 1px;
		 	text-align: center;
		 }
		 .menu .row{
		 	font-weight: bold;
		 	font-size: 20px;
		 	padding: 10px 1px 10px 1px;
		 }
		 .no{
		 	width: 6vw;
		 }
		 .name{
		 	width: 10vw;
		 }
		 .email{
		 	width: 15vw;
		 }
		 .date{
		 	width: 15vw;
		 }
		 .auth{
		 	width: 8vw;
		 }
		 .manage{
		 	width: 12vw;
		 }
		 .manage button{
		 	border: none;
		 	border-radius: 5px;
		 	width: 50px;
		 	margin-left: 10px;
		 	height: 25px;
		 }
		 .manage .out{
		 	background: #eb9f98;
		 }
		 .manage .change{
		 	background: #bad6ae;
		 }
		 .manage .out:hover{
		 	background: #da8e87;
		 }
		 .manage .change:hover{
		 	background: #a6bf9b;
		 }
    </style>
  </head>
  <body>
     <jsp:include page="/WEB-INF/views/header.jsp"/>
     <div style="height:100px"></div>
     
      
     <div id="groupUserList">
     	<h1>
     		유저<span class="point"> 관리</span> <i class="fas fa-users"></i>
     	</h1>
     	
     	<div class="menu">
     	     <div class="row no">NO</div>
     		<div class="row name">이름</div>
     		<div class="row email">이메일</div>
     		<div class="row date">가입날짜</div>
     		<div class="row auth">유저등급</div>
     		<div class="row manage">관리</div>
     	</div>
     	<hr style="border: 2px solid #bbb; border-radius: 5px;">
     	<c:set var="idx" value="1" />
     	<c:forEach items="${userList}" var="u">

     		<div class="user">
     		    <c:set var="i" value="${i+1}"/>
	     		<div class="row no"><c:out value="${i}" /></div>
	     		<div class="row name">${u.name}</div>
	     		<div class="row email">${u.email}</div>
	     		<div class="row date">${u.date}</div>
	     		<div class="row auth">관리자${u.auth}</div>
	     		<div class="row manage"><button class="out">추방</button><button class="change">변경</button></div>
	     	</div>
	     	<c:set var="name" value="철수" />
     	</c:forEach>
     	
     	<!-- 
     	<c:forEach items="${groupList}" var="u"  >
	     	<div class="group" onclick="location.href='<%=request.getContextPath()%>./board/${u.link}';">
	     		<div class="header">
	     			<div class="row title">
	     				ㅁㄴㅇ
	     			</div>
	     			<div class="row manager">
	     				<i class="fas fa-crown"></i>${u.managerName}
	     			</div>
	     		</div>
	     		<div class="detail">
	     			${u.detail}
	     		</div>
	     	</div>
	     </c:forEach>
	     <c:set var="cnt" value="${groupCnt }" />
			  <c:if test="${groupCnt == 0}">
              <h4 style="color: #444;">현재 가입된 스터디 그룹이 없어요ㅠㅠ<br><br>그룹에 가입하거나 그룹을 만들어보세요:)</h4>
              <button id="i2" onclick="window.location.href='/homePage'">그룹 찾기</button>
              <button id="i2" onclick="window.location.href='/make_study'">그룹 만들기</button>
              </c:if>-->
     </div>
  </body>
</html>

<script>

</script>
