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
    <title>LAN Study</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/board.css">
</head>
<body style="background: #f6f6f6;">
	<div style="height: 120px"></div>
	
    <div class="bottom">
	    <div class="btn-group btn-group-toggle" data-toggle="buttons">
    		<label class="btn btn-success active" id="option0">
		    	<input type="radio" name="options0" id="option0" autocomplete="off"> 전체
			</label>
			<label class="btn btn-success" id="option1">
		    	<input type="radio" name="options1" id="option1" autocomplete="off"> 공지
			</label>
			<label class="btn btn-success" id="option2">
		    	<input type="radio" name="options2" id="option2" autocomplete="off"> 정리
			</label>
			<label class="btn btn-success" id="option3">
		    	<input type="radio" name="options3" id="option3" autocomplete="off"> 질문
			</label>
			<label class="btn btn-success" id="option4">
		    	<input type="radio" name="options4" id="option4" autocomplete="off"> 과제
			</label>
		</div>
	    
	    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">글쓰기</button>

		<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content" style="margin-top: 15%;">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel"> 
		        <form action="./${link}/uploadOk", method="POST">
		        <div class="select-category" style="display: inline-block;">
			          	<select name="Category"> 
					      <option selected value="notice">공지</option> 
					      <option value="notes">정리</option>
						  <option value="question">질문</option>
						  <option value="assignment">과제</option>
						</select>
			          </div> 작성</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      
			      <div class="modal-body">
			         
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
			        <input type="submit" class="btn btn-primary" id="board_submit" value="작성 완료"/>
			      </div>
			   </form>
		    </div>
		  </div>
		</div>
	 	<br>
	 	<div id="boardList">
	 	<c:set var="cnt" value="${boardCnt}" />
			  <c:if test="${boardCnt == 0}">
              	<div id="noBoard">
              	<h1 style="margin-bottom: 0px;">
				  <span>현재 </span>
				  <span>작성된 </span>
				  <span>질문이 </span>
				  <span>없어요</span>
				  <span>:(</span>
				</h1>
				
              	<!--  어서 첫 글의 작성자가 되어봅시다!-->
              	</div>
              </c:if>
	 	<c:forEach items="${boardList}" var="u">
	 		<div class="card c${u.type}" >
			  <h5 class="card-header">${u.title} <i class="fas fa-circle type${u.type}"></i></h5>
			  <div class="card-body">
			    <p class="card-text">${u.content}</p>
			    <div class="card-info">
			    작성자 : ${u.userName}<br>
			    작성시간 : ${u.time}
			    </div>
			    
			    <!--  <a href="#" class="btn btn-primary">좋아요</a>-->
			    <!-- 댓글 -->
			    <!-- Button trigger modal -->
				<button type="button" id="commentID" class="commentClass btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
				  댓글
				</button>

				<input type="hidden" class="id" value="${u.id}"/>
				<!-- Modal -->
				<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				  <div class="modal-dialog modal-dialog-centered" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLongTitle">댓글 리스트</h5>
				      </div>
				      <div class="modal-body">
					    <div class="form-group">
					      <h5 id="modal_title"></h5>
					      <label id="modal_content"></label>
					      <textarea class="form-control inputComment"></textarea>
					    </div>
				      
				      	<div id="commentList"></div>
					    <input type="hidden" class="modal_id" value=""/>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				        <input type="button" class="inputCommentButton btn btn-primary" value="댓글 작성 완성"/>
				      </div>
				    </div>
				  </div>
				</div>
			  </div>
			</div>
	 	</c:forEach>
	 	</div>
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
    	$(document).ready(function() {
			$('#write').click(function() {
				var whole_addr = $(location).attr('href');
		        var addr_slice = whole_addr.split('/');
		        $("#url").attr("value",addr_slice[addr_slice.length -1]);
			});
        });

		$(document).ready(function() {
			$('.inputCommentButton').click(function(){ 
				var whole_addr = $(location).attr('href');
		        var addr_slice = whole_addr.split('/');
				var textarea = $('.inputComment').val(); 
				var comments =[]; 
				var b_id = $('.modal_id').val(); 
				alert("/board/"+addr_slice[addr_slice.length -1] + "/commentWrite") ; 
				
				$.ajax({
					type: "post", 
					url: addr_slice[addr_slice.length -1] + "/commentWrite", 
					data: { 
						"comment": textarea,
						"id" : b_id,  
					},
					dataType: "json", 
					success: function(data) {
						if ( data == null) { 
							alert("댓글이 업로드 되지 않았습니다."); 
						}else{
							alert("댓글이 업로드 되었습니다.");
							
							comments.push({
								content: data.content, 
								userName: data.userName, 
							});	
							$("#commentList").append("<div class='comment'><div class='c_content'><i style=\"font-size: 25px;\"class=\"far fa-comment\"></i> "+comments[0].content+"</div><div class='row2 c_writer'><i class=\"fas fa-use */ */r-edit\"></i>"+comments[0].userName+"</div></div>");
							
						}
					}, error : function(request, status, error) {
						alert("댓글 업로드에 실패하였습니다."); 
					}
				});
			});
		});
    	
    	$(document).ready(function() {
        	$(".commentClass").click(function() {
        		var board_id = $(this).siblings(".id").val();
        		var whole_addr = $(location).attr('href');
		        var addr_slice = whole_addr.split('/');
		        var comments = [];
		        $("#commentList").html("");
		        $(".modal_id").val(board_id); 
				$.ajax({
					type: "post", 
					url: addr_slice[addr_slice.length -1] + "/comment", 
					data: { 
						"id" : board_id,
					}, 
					dataType: "json", 
					success : function(data) {
						if (data == null) {
							alert("댓글을 로드하지 못하였습니다.");
						}
							
						for (var i = 0; i <data.length; i++) {
							comments.push({
								title: data[i].title, 
								content: data[i].content,
								time: data[i].time, 
								userName: data[i].userName,
							});
							$("#commentList").append("<div class='comment'><div class='c_content'><i style=\"font-size: 25px;\"class=\"far fa-comment\"></i> "+comments[i].content+"</div><div class='row2 c_writer'><i class=\"fas fa-user-edit\"></i>"+comments[i].userName+"</div><div class='row2 c_time'>"+comments[i].time+"</div></div>");
							$("#modal_title").val(comments[i].title); 
							$("#modal_content").val(comments[i].content); 
							//alert("~~~"+comments[0].content);
						}
					}, error:function(request, status, error){
		    		    alert("댓글을 로드하지 못하였습니다");
			        }
				});
				//alert(comment[0].comment);
			/* 	 $().each(function(index, item) {
					for(prop in item)  {
						  var hey = item[prop];
						  alert(prop + " -> " +hey);
						}
				}); */
             });
        	$("#board_submit").click(function() {
        		$(this).parents(".modal-body").finds(input).html("");
        		$(this).parents(".modal-body").finds(input).val("");
        		$(this).parents(".modal-body").finds(textarea).html("");
        		$(this).parents(".modal-body").finds(textarea).val("");
        	});
        	
        	$("#option1").click(function() {
        		$(".c1").show();
        		$(".c2").hide();
        		$(".c3").hide();
        		$(".c4").hide();
        	});
        	
        	$("#option2").click(function() {
        		$(".c2").show();
        		$(".c1").hide();
        		$(".c3").hide();
        		$(".c4").hide();
        	});
        	
        	$("#option3").click(function() {
        		$(".c3").show();
        		$(".c2").hide();
        		$(".c1").hide();
        		$(".c4").hide();
        	});
        	
        	$("#option4").click(function() {
        		$(".c4").show();
        		$(".c2").hide();
        		$(".c3").hide();
        		$(".c1").hide();
        	});
        	
        	$("#option0").click(function() {
        		$(".c4").show();
        		$(".c2").show()
        		$(".c3").show()
        		$(".c1").show()
        	});
        	
        	
        });
    </script>
</body>
</html>