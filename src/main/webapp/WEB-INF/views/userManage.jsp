<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
  <head>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <style>
	    #groupUserList{
	    		width: 80vw;
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
		 	width: 7vw;
		 }
		 .name{
		 	width: 8vw;
		 }
		 .email{
		 	width: 16vw;
		 }
		 .date{
		 	width: 16vw;
		 }
		 .auth{
		 	width: 9vw;
		 }
		 .manage{
		 	width: 20vw;
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
		 select{
		 	width: 100px;
		 	border: none;
		 	height: 30px;
		 	background: #eee;
		 	border-radius: 10px;
		 }
		 button:hover{
		 	background: #ddd;
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
	     		<div class="row auth">
	     		<c:if test="${u.auth == 0}">
			            스터디장
			 	</c:if>
			 	<c:if test="${u.auth == 1}">
			           	매니저
			 	</c:if>
			 	<c:if test="${u.auth == 2}">
			            스터디원
			 	</c:if>
			 	<c:if test="${u.auth == -1}">
			            허락 대기중
			 	</c:if>
			 	<c:if test="${u.auth == -2}">
			            <span style="color:red;">거절</span>
			 	</c:if>
	     		
	     		</div>
	     		<div class="row manage">
	     		<c:if test="${u.auth == 0}">
	     		<i class="fas fa-crown" style="color:#e8e11e;"></i>
	     		</c:if>
	     		<c:if test="${u.auth == 1}">
	     			<select>
	     				<option value="0">스터디장</option>
	     				<option value="1" selected>스터디매니저</option>
	     				<option value="2">스터디원</option>
	     				<option value="-3">퇴출</option>
	     			</select>
	     			<button class="changeU">변경</button>
	     		</c:if>
	     		<c:if test="${u.auth == 2}">
	     			<select>
	     				<option value="0">스터디장</option>
	     				<option value="1">스터디매니저</option>
	     				<option value="2" selected>스터디원</option>
	     				<option value="-3">퇴출</option>
	     			</select>
	     			<button class="changeU">변경</button>
	     		</c:if>
	     		<c:if test="${u.auth == -1}">
			    	<button class="reject">거절</button><button class="ok">수락</button>
			 	</c:if>
			 	<c:if test="${u.auth == -2}">
			    	<button class="cancle">취소</button>
			 	</c:if>
	     		</div>
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
	$("button").click(function(){
		alert("아직 지원되지 않는 기능입니다 :( 조금만 기다려주세요");	
	});
</script>
