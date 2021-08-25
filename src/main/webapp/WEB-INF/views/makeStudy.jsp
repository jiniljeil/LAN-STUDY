<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LenStudy</title>
    
    <style>
    	.emptyLeft {
    		margin-left: 20%; 
    	}
    	.emptyRight {
    		margin-right: 20%;
    	}
    	.contents {
    		width: 60%; 
    		margin-top: 10%; 
    	}
    </style>
</head>
<body>
    <div>
    	<div class="emptyLeft">
    	
    	</div>
    	<div class="contents">
    		<form action="upload", method="POST">
    			<h4>제목</h4>
    			<input type="text" name="title" placeholder="제목을 입력하세요."/>
    			<button>사진 첨부</button>
	    		<!-- 방법 찾기 -->
	    		<h4>내용</h4>
	    		<textarea rows="40%" cols="70%" name="content" placeholder="내용을 입력하세요.">
	    			
	    		</textarea>
    		</form>
    	</div>
    	<div class="emptyRight">
    	
    	</div>
    	
    </div>
</body>
</html>