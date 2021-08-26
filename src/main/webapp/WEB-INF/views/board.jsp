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
    	.select-category {
    		text-align: left; 
    	}
    </style>
</head>
<body>
    <div class="bottom">
	    <div class="btn-group btn-group-toggle" data-toggle="buttons">
    		<label class="btn btn-success active">
		    	<input type="radio" name="options0" id="option0" autocomplete="off"> 공지
			</label>
			<label class="btn btn-success">
		    	<input type="radio" name="options1" id="option1" autocomplete="off"> 공지
			</label>
			<label class="btn btn-success">
		    	<input type="radio" name="options2" id="option2" autocomplete="off"> 정리
			</label>
			<label class="btn btn-success">
		    	<input type="radio" name="options3" id="option3" autocomplete="off"> 질문
			</label>
			<label class="btn btn-success">
		    	<input type="radio" name="options4" id="option4" autocomplete="off"> 과제
			</label>
		</div>
	    
	    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">글쓰기</button>

		<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content" style="margin-top: 15%;">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">새 글 작성</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <form action="/uploadOk", method="POST">
			      <div class="modal-body">
			          <div class="select-category">
			          	<select name="Category"> 
					      <option selected value="notice">공지</option> 
					      <option value="notes">정리</option>
						  <option value="question">질문</option>
						  <option value="assignment">과제</option>
						</select>
			          </div>
			          <div class="form-group">
			            <label for="recipient-name" class="col-form-label">제목</label>
			            <input type="text" class="form-control" id="recipient-name" name="title">
			          </div>
			          <div class="form-group">
			            <label for="message-text" class="col-form-label">내용</label>
			            <textarea class="form-control" id="message-text" name="content"></textarea>
			          </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			        <input type="submit" class="btn btn-primary" value="작성 완료"/>
			      </div>
			   </form>
		    </div>
		  </div>
		</div>
	 	<br>
	 	<c:forEach items="${boardList}" var="u">
	 		${u.title}
	 	</c:forEach>
    </div>
    <script>
    	$('#exampleModal').on('show.bs.modal', function (event) {
    	  var button = $(event.relatedTarget) // Button that triggered the modal
    	  var recipient = button.data('whatever') // Extract info from data-* attributes
    	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    	  var modal = $(this)
    	  modal.find('.modal-title').text('New message to ' + recipient)
    	  modal.find('.modal-body input').val(recipient)
    	})
    </script>
</body>
</html>