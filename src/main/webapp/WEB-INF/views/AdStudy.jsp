<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Lan Study</title>
        
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
	</div>
    
    <!-- 
    <div class="container recommend_area">
        <div class="row mt-5">
            <div class="col text-center">
                <button onclick="location.href ='#'"  type="button" class="btn rounded-pill btn-lg btn-outline-danger">
                    OS study
                </button>
            </div>
            <div class="col text-center"">
                <button onclick="location.href ='#'" type="button" class="btn rounded-pill btn-lg btn-outline-danger">
                    OS study
                </button>
            </div>
            <div class="col text-center"">
                <button onclick="location.href ='#'" type="button" class="btn rounded-pill btn-lg btn-outline-danger">
                    OS study
                </button>
            </div>
            <div class="col text-center"">
                <button onclick="location.href ='#'" type="button" class="btn rounded-pill btn-lg btn-outline-danger">
                    OS study
                </button>
            </div>
        </div>
       
        <div class="row m-5">
            <div class="col text-center"">
                <button onclick="location.href ='#'" type="button" class="btn rounded-pill btn-lg btn-outline-danger">
                    DB study
                </button>
            </div>
            <div class="col text-center"">
                <button onclick="location.href ='#'" type="button" class="btn rounded-pill btn-lg btn-outline-danger">
                   소개딩 
                </button>
            </div>
            <div class="col text-center"">
                <button onclick="location.href ='#'" type="button" class="btn rounded-pill btn-lg btn-outline-danger">
                    OS study
                </button>
            </div>
        </div>
    </div class ="border border-danger">-->
    
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