<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/views/header.jsp" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>LenStudy</title>
    
    <style>
    	.contents {
    		width: 60%; 
    		left: 0; 
            right: 0;
            margin-left: auto ; 
            margin-right: auto ; 
    	}
    </style>
</head>
<body>
    <div class="contents" style="padding-top:10%">
    	<div class="card">
			<div class="card-header">
			    Featured
			 </div>
			 <div class="card-body">
			 	<form action="./upload", method="POST">
					<h4>제목</h4>
		    		<input type="text" name="title" placeholder="제목을 입력하세요."/>
		    		
			   		<!-- 방법 찾기 -->
			   		
			   		<h4>내용</h4>
			   		<textarea rows="10%" cols="70%" name="content" placeholder="내용을 입력하세요.">
			   		</textarea>
			   		<button>작성완료</button>
		   		</form>
		  	</div>
		</div>
   	</div>
</body>
</html>