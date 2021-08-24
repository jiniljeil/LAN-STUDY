<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
  <head>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <style>
       @import: url(https://fonts.googleapis.com/css?family=Roboto+Condensed);
    </style>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/index.css">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
  </head>
  <body>
    <div class="explan">
      <h1><span class="point">LAN STUDY</span> 에서 함께 공부해요 <i class="fas fa-pencil-alt"></i></h1>
      <br>
      <p style="margin: 10 0 ;  font-size: 16px; font-style: italic;">"학생들이 수업에 관한 질문을 편하게 할 수 있었으면 좋겠어요"</p>
      <p style="margin: 10 0 ;  font-size: 16px; font-style: italic;">"다른 학교 학생들과도 함께 스터디하고 싶어요"</p>
      <p style="margin: 10 0 ;  font-size: 16px; font-style: italic;">"막막한 취업준비, 같이할 친구들을 구하고 있어요"</p>
      <p style="margin: 10 0 ;  font-size: 16px; font-style: italic;">"소통이 활발한 강의 분위기를 형성하고파요"</p>
      <h3 style="margin: 40 0 30 0">LAN STUDY에선 <span class="point">전부</span> 가능합니다 !</h3>
      <div id="interactive" style="margin-top: 40px;">
        <!--<h2 id="i1" style="margin: 0 0 20 0; text-decoration: underline; color: #555" class="point"   >지금 바로, 시작해보세요</h2>-->
        <button id="i2">회원가입</button>
      </div>
    </div>
    <div class="side">
      <div class="logo">
      </div>
      <div class="login_space">
        <form>
          <input class="login_input" type="text" placeholder="ID"/>
          <input class="login_input" type="password" placeholder="PW"/>
          <br>
          <input class="login_input" id="login_submit" type="submit" value="LOGIN"/>
        </form>
      </div>
    </div>
  </body>
</html>

<script>
$( document ).ready(function() {
  /*
  $("#interactive").mouseenter(function() {
    $("#i1").css("display", "none");
    $("#i2").css("display", "inline-block");
  });
  $("#interactive").mouseleave(function() {
    $("#i1").css("display", "inline-block");
    $("#i2").css("display", "none");
  });*/
  $('.share-btn').click(function(){
    $(this).addClass("clicked");
  });

  $('.close').click(function (e) {
    $('.clicked').removeClass('clicked');
    e.stopPropagation();
  });
});

</script>
