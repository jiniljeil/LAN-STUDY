<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>스터디 참여</title>
        
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        
        <!-- Font Awesome -->
		<link
		  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
		  rel="stylesheet"
		/>
		<!-- Google Fonts -->
		<link
		  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
		  rel="stylesheet"
		/>
		<!-- MDB -->
		<link
		  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.css"
		  rel="stylesheet"
		/>
		
		
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/adstudy.css">
        <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    	<style>
    		.modal-dialog{
    			margin-top: 200px !important;
    		}
    	</style>
    </head>
    <jsp:include page="/WEB-INF/views/header.jsp" />
    <div style="height:100px"><br></div>
    <div class="row my-5 ">
	    <div class="input-group justify-content-md-center" style="padding: 0px 100px;">
			<div class="form-outline">
		  		<input style="background: white;" type="search" id="form1" class=" auto form-control" />
			    <label class="form-label" for="form1" style="color: #a1c48f;"> 검색</label>
			</div>
		  	<button style="background: #a1c48f;" type="button" class="btn btn-primary">
		    	<i class="fas fa-search"></i>
			</button>
			
		</div>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" style="background: #a1c48f; width: 50px; margin-top: 30px; position: absolute; top: 100; right: 50; font-size: 20px;" data-whatever="@mdo">+ </button>
        </button>
	</div>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Recipient:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Message:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>


    
    <c:forEach items="${AdList}" var="u"  >
    <div id="adContainer">
    	<div class="img">
    	
    	</div>
    	<div class="title">
    		${u.title}
    	</div>
    	<div class="content">
    		${u.content}
    	</div>
    	<button class="btn">
    		자세히 보기
    	</button>
    </div>
    </c:forEach>
    
    <!--
    <div class="container-fluid vh-100">
        <div class="row">
        	<c:forEach items="${AdList}" var="u"  >
	        <div class="col-md-6 col-lg-3 border border-danger content_box">
	            <div class="bg-primary mt-4">
	                <div class="card text-center" >
	                    <img class="card-img-top center img-max"src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png" alt="Card image cap">
	                    <div class="card-body">
	                        <h5 class="card-title">${u.title}</h5>
	                        <p class="card-text">${u.content}</p>
	                        <a href="#" class="btn btn-primary">Join</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	        </c:forEach>
        </div>
    </div>
    -->
    
    </body>

</html>

<script>
$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
</script>