<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function page_back() {

		history.go(-1)();

	}
</script>

</head>
<body>
	<div id="wrap">
		<div id="header">

			<jsp:include page="../section/headerMain.jsp" />
		</div>
		<div id="container_newjoin">
			<div id="content_newjoin">
				<div class="wrap_account_newjoin"
					id="join_terms_agreement_complete_newjoin">
					<h2 class="blind_newjoin">로그아웃</h2>
					<div class="login_notice login_tv_newjoin">

						<p class="tit_notice_newjoin">
							<span class="txt_emph_newjoin" id="name"></span>로그아웃 하시겠습니까?
						</p>

						<form action="/member/customLogout" method="post" role="form">
							<fieldset>

								<button type="button"
									class="u_btn btn_type1_newjoin btn_success"
									onclick="page_back();" id="main">확인</button>
							</fieldset>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

						</form>
						<button type="button" class="u_btn btn_type2_newjoin" id="login"
							onclick="page_back();">취소</button>

					</div>
				</div>
			</div>
		</div>
		<div id="footer">

			<jsp:include page="../section/footerMain.jsp" />


		</div>
	</div>

	<script>
		$(".btn_success").on("click", function(e) {

			e.preventDefault();
			$("form").submit();
		});
	</script>
	<c:if test="${param.logout != null }">
		<script>
			$(document).ready(function() {
				alert("로그아웃하였습니다.");
			});
		</script>
	</c:if>
</body>
</html>