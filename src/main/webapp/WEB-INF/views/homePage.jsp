<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나에게 맞는 스터디 찾기!</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<table id="list" width="90%" class="table table-hover table-borderless">
		<thead class="thead-light">
			<tr>
				<th>Id</th>
				<th>userid</th>
				<th>password</th>
				<th>phone_num</th>
				<th>email</th>
				<th>authority</th>
				<th>page_id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.user_id}</td>
					<td>${u.user_pw}</td>
					<td>${u.phone_number}</td>
					<td>${u.email}</td>
					<td>${u.authority}</td>
					<td>${u.page_id}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html> 
