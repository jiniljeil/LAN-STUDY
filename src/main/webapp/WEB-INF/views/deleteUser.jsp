<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <html>
    <input type="hidden" id="name" value="${name}"></input>
    </html>
	<script language = "javascript">
	$( document ).ready(function() {
		var name = $("#name").val();
		alert(name+"님 그동안 감사했어요 안녕:D");
	document.location.href = "<%=request.getContextPath()%>/";
	});

</script>