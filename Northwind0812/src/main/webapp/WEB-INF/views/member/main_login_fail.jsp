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

<script type="text/javascript">
	function a() {
		alert("아이디 혹은 비밀번호가 틀렸습니다. 다시 확인해 주시기 바랍니다.");
	}
</script>


</head>
<body onload="a()">
	<div id="wrap">
		<div id="header">

			<jsp:include page="../section/headerMain.jsp" />
		</div>
		<div id="container_newjoin">
			<div id="content_newjoin">
				<div class="wrap_account_newjoin" id="join_terms_agreement_complete_newjoin">
					<h2 class="blind_newjoin">비밀번호 찾기 성공</h2>
					<div class="login_notice login_tv_newjoin">
					
						<p class="tit_notice_newjoin"><span class="txt_emph_newjoin"
							id="name"></span>회원님의<br> 정보가 일치 하지 않습니다. 다시 이용해 주시기 바랍니다.</p>
							
						<p class="txt_notice_newjoin">
							northwind에서는 항상 좋은 상품과 서비스를 제공할 수 있도록 노력하겠습니다.<br>즐겁고 편리한 쇼핑을
							즐기세요!
						</p>
						<button type="button" class="u_btn btn_type1_newjoin" id="main" onclick = "location.href = '/main/main' ">
							메인으로가기</button>
						<button type="button" class="u_btn btn_type2_newjoin" id="login" onclick = "location.href = '/member/mainLoginPage' ">
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