<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script language = "javascript">

	alert("아이디와 비밀번호는 동일할 수 없으며, 비밀번호는 숫자, 문자, 특수문자가 모두 포함되어야 합니다.");
	document.location.href = "<%=request.getContextPath()%>/join";

</script>