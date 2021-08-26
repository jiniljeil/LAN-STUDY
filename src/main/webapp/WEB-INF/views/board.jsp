<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
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
			        <input type="submit" id="write" class="btn btn-primary" value="작성 완료"/>
			        <input type="hidden" id="url" name="link" value=""/>
			      </div>
			   </form>
		    </div>
		  </div>
		</div>
	 	<br>
	 	<c:forEach items="${boardList}" var="u">
	 		<div class="card" style="width: 50%; margin: 15px 0 0 0 ;">
			  <h5 class="card-header">${u.title}</h5>
			  <div class="card-body">
			    <p class="card-text">${u.content}</p>
			    <a href="#" class="btn btn-primary">좋아요</a>
			    <!-- 댓글 -->
			    <!-- Button trigger modal -->
				<button type="button" id="commentID" class="commentClass btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
				  댓글
				</button>
				<input type="hidden" id="id" value="1"/>
				<!-- Modal -->
				<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				  <div class="modal-dialog modal-dialog-centered" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLongTitle">댓글 리스트</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				      	<div >
				      		<h5 class="answer"></h5>
				      	</div>
				        <%-- <c:forEach items="${commentList}" var="u">
				        	
				        	<h5>TEST: ${u.content}</h5>
				        	
				        	
				        	
				        	
				        </c:forEach>  --%>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				        <button type="button" class="btn btn-primary">댓글 작성 완료</button>
				      </div>
				    </div>
				  </div>
				</div>
			  </div>
			</div>
	 	</c:forEach>
    </div>
    
    <script>
    	$('#exampleModal').on('show.bs.modal', function (event) {
    	  var button = $(event.relatedTarget) 
    	  var recipient = button.data('whatever') 
    	  var modal = $(this)
    	  modal.find('.modal-title').text('New message to ' + recipient)
    	  modal.find('.modal-body input').val(recipient)
    	})
    	
    	$(document).ready(function() {
			$('#write').click(function() {
				var whole_addr = $(location).attr('href');
		        var addr_slice = whole_addr.split('/');
		        $("#url").attr("value",addr_slice[addr_slice.length -1]);
			});
        });
    	
    	$(document).ready(function() {
        	$(".commentClass").click(function() {
        		var board_id = $(this).siblings("#id").val();
        		var whole_addr = $(location).attr('href');
		        var addr_slice = whole_addr.split('/');
		        
				$.ajax({
					type: "post", 
					url: addr_slice[addr_slice.length -1] + "/comment", 
					data: {
						"id" : board_id,
					}, 
					dataType: 'text', 
					success : function(data) {
						if (data == null) {
							alert("댓글을 로드하지 못하였습니다.");
						}
						alert(${data.content});
					}, error:function(request, status, error){
		    		    alert("댓글을 로드하지 못하였습니다");
			        }
				});
			/* 	 $().each(function(index, item) {
					for(prop in item)  {
						  var hey = item[prop];
						  alert(prop + " -> " +hey);
						}
				}); */
             });
        });
    </script>
</body>
</html>