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
<link rel="stylesheet" href="/resources/css/newjoin.css">

</head>
<body>
	<div id="wrap">
		<div id="header">

			<jsp:include page="../section/headerMain.jsp" />
		</div>
		<div id="container_newjoin">
			<div id="content_newjoin">
				<div class="wrap_account_newjoin" id="join_terms_agreement_complete_newjoin">
					<h2 class="blind_newjoin">northwind 회원가입 완료</h2>
					<div class="login_notice login_tv_newjoin">
					
						<p class="tit_notice_newjoin">northwind 회원이 되어 주셔서 감사합니다.</p>
							
						<p class="txt_notice_newjoin">
							northwind에서는 항상 좋은 상품과 서비스를 제공할 수 있도록 노력하겠습니다.<br>즐겁고 편리한 쇼핑을
							즐기세요!
						</p>
						<button type="button" class="u_btn btn_type1_newjoin" id="main" onclick = "location.href = '/main/main' ">
							메인으로가기</button>
						<button type="button" class="u_btn btn_type2_newjoin" id="login"  onclick = "location.href = '/member/mainLoginPage' ">
							로그인</button>
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