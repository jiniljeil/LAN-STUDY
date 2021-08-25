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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>LanStudy</title>
    <style>
    	
    	.bottom {
    		position: absolute;
    		text-align: center; 
    		padding-top: 10%;
    		left: 0; 
    		right: 0; 
    		margin: 0 auto; 
    	}
    </style>
</head>
<body>
    <div class="bottom">
    	<form action="/boardWrite" method="POST">
	    	<div class="btn-group btn-group-toggle" data-toggle="buttons">
				<label class="btn btn-success active">
			    	<input type="radio" name="options" id="option1" autocomplete="off"> 공지
				</label>
				<label class="btn btn-success">
			    	<input type="radio" name="options" id="option2" autocomplete="off"> 정리
				</label>
				<label class="btn btn-success">
			    	<input type="radio" name="options" id="option3" autocomplete="off"> 질문
				</label>
				<label class="btn btn-success">
			    	<input type="radio" name="options" id="option3" autocomplete="off"> 과제
				</label>
			</div>
	    	<br> 
	    
	    	<div class="form-group" style="width: 45%;">
			    <label for="exampleFormControlTextarea1">Example textarea</label>
	    			<textarea class="form-control" id="exampleFormControlTextarea1" name="content"rows="3"></textarea>
	    			<button type="button" class="btn btn-success">작성 완료</button>
		 	</div>
	 	</form>	
	 	
    </div>
    
</body>
</html>