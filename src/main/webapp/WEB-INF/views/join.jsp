<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<style>
		#join_container{
			width: 50vw;
			margin: auto;
			text-align: left;
		}
		#join_container input, select, button{
			border: none;
			border-radius: 10px;
			width: 200px;
			height: 40px;
			font-size: 15px;
			margin: 0 10 10 10;
		}
		#b1{
			background: #ddd;
		}
		#b1:hover{
			background: #ccc;
		}
		#b2{
			background: #a1c48f;
			float: middle;
		}
		#b2:hover{
			background: #90b37e;
		}
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header2.jsp" />
	<div style="height: 80px"><br></div>
	<div id="join_container">
		<form action="joinOK" method="POST" onSubmit="return checkForm()">
			<div style="height: 30px"></div>
			<h4>아이디</h4>
			<input type="text" id="userid" name="userID" placeholder="아이디를 입력해주세요." autofocus required/>
			<button type="button" id="b1">중복확인</button>
			<span id="id_result" style="margin-left: 10px;"></span>
			<br> 
			
			<h4>비밀번호</h4>
			<input type="password" onchange="checker()" id="password" name="userPW" placeholder="비밀번호를 입력해주세요." required/><br> 
			<h4>비밀번호 확인 </h4>
			<input type="password" onchange="checker()" id="cpassword" placeholder="비밀번호를 다시 입력해주세요." required/><br> 
			
			<!--  010-XXXX-XXXX 수정 의논 -->
			<h4>전화번호</h4>
			<select name="FirstPhoneNumber"> 
				<option selected value="010">010</option> 
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="019">019</option>
			</select> - 
			<input type="text" name="MediumPhoneNumber"/> - <input type="text" name="LastPhoneNumber"/>
			
			<h4>이메일</h4>
			<input type="email" name="email"/><br> 
			
			<h4>이름</h4>
			<input type="text" name="nickname" placeholder="이름을 입력해주세요." required/><br>
			
			<!-- <h4>직업:</h4>
			<select name="job">
				<option selected value="----직업----">---직업---</option>
				<option value="학생">학생</option>
				<option value="교수">교수</option>
				<option value="TA">TA</option>
			</select>-->
			<br><br> 
			<button id="b2" value="가입하기">가입하기</button>
			<div style="height: 100px"></div>
		</form>
	</div>
	<script> 
		var dup_check = false;
		$( document ).ready(function() {
		    $("#b1").click(function(){
		    	var whole_addr = $(location).attr('href');
		        var addr_slice = whole_addr.split('/');
		        var addr = addr_slice[0]+"/"+addr_slice[1]+"/"+addr_slice[2]+"/"+addr_slice[3];
		        $("#id_result").html("<span style='color:grey;' class='overlap_msg' >아이디 중복체크 중입니다 잠시 기다려주세요!</span>");
		        
		      if($("#userid").val()==""){
		        $("#userid").focus();
		        alert("아이디를 입력해주세요.");
		      }
		      else{
		        $.ajax({
		          type: "post",
		          url: "idDupChk",
		          data : {
		            "id" : $("#userid").val()
		          },
		          dataType: 'text',
		          success : function(data){
		            if(data=="success"){
		              $("#id_result").html("<span style='color:green;' class='overlap_msg' >사용가능</span>");
		              //$("#url").val(addr+"/form/"+$("#link").val());
		        	  //$("#url").html(addr+"/form/"+$("#link").val());
		              $("#userid").css("background-color","#e4eee4");
		              //alert("사용가능한 아이디");
		              dup_check=true;
		            }
		            else{
		              $("#userid").val("");
		              $("#id_result").html("<span style='color:red;' class='overlap_msg'>사용불가</span>");
		              $("#userid").css("background-color","#eee6e4");
		              //alert("사용불가능한 아이디");
		              dup_check=false;
		            }
		          }, error:function(request, status, error){
		    		    alert("아이디 중복 체크 오류발생");
		          }
		        });
		      }
		    });
		});  
    
		function checkForm(){
	        var p = document.getElementById('password').value;
	        var cp = document.getElementById('cpassword').value;
			if(!documnet.getElementById('userid').value){
				alert("아이디를 입력하세요.");
				return false;
			}
			if(!document.getElementByID('password').value){
				alert("비밀번호를 입력하세요.");
				return false; 
			}
	        if(p != cp){
	            alert("비밀번호가 서로 다릅니다. 다시 입력해주시기 바랍니다.");
	            return false;
	        }
	        alert("실패");
	        return false;
		}
		function checker() {
	        var pwd = document.getElementById('password').value;
	        var cpwd = document.getElementById('cpassword').value;
	        
	        if(pwd.length < 11 || pwd.length > 20 ){
	            window.alert('비밀번호는 11자리 이상, 20자리 이하만 사용 가능합니다.');
	            document.getElementById('password').value = document.getElementById('cpassword').value = '';
	            document.getElementById('same').innerHTML = '';
	        }
			
	        if(document.getElementById('password').value != '' && document.getElementById('cpassword').value != ''  ){
	            if(document.getElementById('password').value == document.getElementById('cpassword').value){
	                document.getElementById('same').innerHTML = "비밀번호가 일치합니다.";
	                document.getElementById('same').style.color = 'white';
	            }else{
	                document.getElementById('same').innerHTML="비밀번호가 일치하지 않습니다.";
	                document.getElementById('same').style.color = 'red';
	            }
	        }
			
	        if(cpwd != '' && pwd != cpwd){
	            alert("비밀번호가 서로 다릅니다. 다시 입력해주시기 바랍니다.");
	            return false;
	        }
	    }
		
		$("#userid").on("change keyup paste", function(){
			dup_check = false;
			$("#id_result").html("");
			$("#userid").css("background-color","white");
		});
	</script>
</body>
</html>