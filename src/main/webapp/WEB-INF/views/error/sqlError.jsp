<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script language = "javascript">

	alert("SQL 쿼리문 에러");
	document.location.href = "<%=request.getHeader("referer")%>";

</script>