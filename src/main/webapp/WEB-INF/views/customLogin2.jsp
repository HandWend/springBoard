<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Infinity - Bootstrap Admin Template</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
	<meta name="description" content="Admin, Dashboard, Bootstrap" />
	<link rel="shortcut icon" sizes="196x196" href="/resources/assets/images/logo.png">
	
	<link rel="stylesheet" href="/resources/libs/bower/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="/resources/libs/bower/material-design-iconic-font/dist/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" href="/resources/libs/bower/animate.css/animate.min.css">
	<link rel="stylesheet" href="/resources/assets/css/bootstrap.css">
	<link rel="stylesheet" href="/resources/assets/css/core.css">
	<link rel="stylesheet" href="/resources/assets/css/misc-pages.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900,300">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body class="simple-page">
	<div id="back-to-home">
		<a href="index.html" class="btn btn-outline btn-default"><i class="fa fa-home animated zoomIn"></i></a>
	</div>
	<div class="simple-page-wrap">
		<div class="simple-page-logo animated swing">
			<a href="index.html">
				<span><i class="fa fa-gg"></i></span>
				<span>Infinity</span>
			</a>
		</div><!-- logo -->
		<div class="simple-page-form animated flipInY" id="login-form">
	<h4 class="form-title m-b-xl text-center">로그인</h4>
	<form method="post" action="/login">
		<div class="form-group">
			<input id="uid" type="text" name="username" class="form-control" placeholder="User name">
		</div>

		<div class="form-group">
			<input id="upw" type="password" name="password" class="form-control" placeholder="Password">
		</div>

		<div class="form-group m-b-xl">
			<div class="checkbox checkbox-primary">
				<input type="checkbox" id="saveId" name="saveId" value="save"/>
				<label for="saveId">Keep Id</label>
			</div>
		</div>
		<input type="submit" class="btn btn-primary" value="SIGN IN">
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
		
	</form>
</div><!-- #login-form -->

<div class="simple-page-footer">
	<p><a href="password-forget.html">FORGOT YOUR PASSWORD ?</a></p>
	<p>
		<small>Don't have an account ?</small>
		<a href="signup.html">CREATE AN ACCOUNT</a>
	</p>
</div><!-- .simple-page-footer -->


	</div><!-- .simple-page-wrap -->
	
	<!-- 추가하고 싶은 것 -->
	<!-- 영어 대문자(CapsLock)이 눌렸을 시 경고창 -->
	<!-- 관리자 페이지에 멤버 관리(글 못 쓰게 하기 또는 회원정지) 및 게시판 관리(글 삭제) -->
	<!-- 멤버 페이지에서 자신이 몇 번 이 사이트에 로그인했는가 표시 -->
	<script>
	$(document).ready(function(){
		
		//document.cookie = "chkId="+encodeURIComponent("한글");
		//alert(document.cookie);
		console.log(document.cookie.split('=')[1]);
		$('input[name=uid]').val(document.cookie.split('=')[1]);
		
		if(document.cookie.split('=')[1] != undefined && document.cookie.split('=')[1] != ""){
			$('#saveId').prop("checked", true);
		}
		
		$("input[type=checkbox]").on("click", function(){
			if($("input[type=checkbox]").is(":checked")){
				alert("공공장소에서는 사용하지 마세요.");
				
				let saveId = $("#uid").val();
				let expires = new Date(Date.now()+((60*60*24)*1000));
				
				document.cookie = "chkId="+saveId+"; path=/; expires="+expires;
			} else {
				document.cookie = "chkId=; path=/; expires=-1";
			}
		});
	});
</script>	
</body>
</html>