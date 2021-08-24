<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
</head>
<body>
Hello World!

<form action="/login" method="POST"> 
	<input type="text" name="userID" /> 
	<input type="text" name="userPW" /> 
	<button>Login</button>
</form>
<button onclick="window.location.href='/join'" value="회원가입">회원가입</button>
</body>
</html>