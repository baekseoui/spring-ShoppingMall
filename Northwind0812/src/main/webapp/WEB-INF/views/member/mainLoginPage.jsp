<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Northwind</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" href="/resources/css/mainIndex.css">
<link rel="stylesheet" href="/resources/css/mainOriginIndex.css">
<link rel='stylesheet' href='/resources/css/mainLogin.css'>
</head>
<body>
	<div id="wrap">
		<div id="header">

			<jsp:include page="../section/headerMain.jsp" />
		</div>
		<div id="content">
			<div id="login_content">
				<div class="wrap_account">
					<h1 class="blind">로그인</h1>
					<div class='cont_login'>
						<div class='tit_login'>
							<img src='/resources/img/northwind8.png'>
						</div>
						
						
						<form action='/login' method='post' name='loginFrm' role="form">
						<fieldset>
							<input class='input_all' type='text' name='username' id='id_input'
								placeholder='아이디 입력' autofocus> <br> <input
								class='input_all' type='password' name='password' id='pwd_input'
								placeholder='비밀번호 입력 '> <br> <input
								id='login_btn' type='submit' value='로그인'>
						</fieldset>		
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
							<input type="hidden" name="loginRedirect" value="${loginRedirect }">
						</form>
						
						
						
						<div class='find_account'>
							<a href='/member/mainIDFindPage' class='link_find' id='findId'>아이디
								찾기</a>&nbsp;&nbsp;| <a href='/member/mainPwdFindPage' class='link_find'
								id='findId'>&nbsp;&nbsp;비밀번호 찾기 </a>&nbsp;&nbsp;| <a
								href='/member/signupPage' class='link_find' id='findId'>&nbsp;&nbsp;회원가입</a>
						</div>
					</div>
				</div>
			</div>


		</div>
		<div id="footer">

			<jsp:include page="../section/footerMain.jsp" />


		</div>
	</div>
</body>
</html>