<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Pentest</title>
	    <!-- 합쳐지고 최소화된 최신 CSS -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	    <!-- 부가적인 테마 -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	    <style> 
	        body{ 
	            width:100%;
	            height:100%;
	            background-color:black; 
	        }
	        .left { 
	            width: 70%; 
	            float:left; 
	            left: 0; 
	            right: 0;
	            margin-left: auto ; 
	            margin-right: auto ; 
	            text-align: center;
	            margin-top: 15%; 
	            color: white; 
	        }
	        .right{ 
	            float: right; 
	            text-align: center;
	            position: absolute;
	            margin-left:70%;
	            padding-top: 5%;
	            width: 30%; 
	            height: 100%;
	            border-color: black;
	            background-color: white;
	        }
	        .butt{
	            width:70%; 
	            height:5%;
	            font-size: 10pt; 
	            border: 2px solid #D6DADF;
	            background-color: white;
	            margin-top: 1%;
	        }
	    </style> 
	</head>
<body>
	<div class="left">
        <h1>GHOST CTF</h1>
        <h2>대회 일정</h2>
        <h2>2021.03.07 (19:00 ~ 24:00)</h2>
        <br> 
        <h4 style="color:red">주의 사항</h4> 
        <h4 style="color:red">대회 이외에 해킹을 시도하는 행위는 불법입니다.</h4>
    </div>
    <div class="right"> 
        <img src="./Image/ghost_logo.png" width="200px" height="200px" alt="ghostLogo"/>
        <h1 style="margin-bottom: 5%;">Capture The Flag</h1>
        <br>
        <form action="/login" method="POST">
            <div class="input-group" style="width: 70%; margin-left: 15%;">
                <span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-user" width="15" height="15" aria-hidden="true"></span></span>
                <input type="text" id="userid" class="form-control" placeholder="USER ID" name="userID" aria-describedby="sizing-addon2" required>
            </div>
            <div class="input-group" style="width: 70%; margin-left: 15%; margin-top:1%; margin-bottom:1%;">
                <span class="input-group-addon" id="sizing-addon2"><svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
                    <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"/>
                  </svg></span>
                <input type="text" id="userpw" class="form-control" placeholder="USER PASSWORD" name="userPW" aria-describedby="sizing-addon2" required>
            </div>
            <button style="padding: 1.5% 0" class="butt">로그인</button> <br>
        </form>
        <button onclick="window.location.href='/join'" class="butt" style="color: white; background-color: black; border: none;">회원가입</button>
    </div> 
</body>

</html>