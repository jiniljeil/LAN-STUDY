<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script language = "javascript">

	alert("잘못된 로그인 정보입니다. 5회 연속 로그인 실패로 30초간 로그인을 시도할 수 없습니다.");
	document.location.href = "<%=request.getContextPath()%>/";

</script>