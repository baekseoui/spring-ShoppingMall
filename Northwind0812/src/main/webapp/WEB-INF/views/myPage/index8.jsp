<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Northwind</title>
<link rel="stylesheet" href="/resources/css/mainIndex.css">
<link rel="stylesheet" href="/resources/css/common.cjmall.pc.min.css">
<link rel="stylesheet" href="/resources/css/common.cjos.pc.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" href="/resources/css/mainOriginIndex.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/page.cjmall.pc.account.min.css" />

</head>
<body>
	<div id="wrap">
		<div id="header">
			<jsp:include page='../section/headerMain.jsp' />

		</div>
		<div id="container">
			<div id="aside">
				<h2 class="tit_cs">
					<a href="/myPage/index">MY PAGE</a>
				</h2>
				<div class="cs_snb">
					<ul class="list_snb">
						<li><strong class="tit_sub">나의 쇼핑정보</strong>
							<ul class="list_snb_sub">
								<li><a href="/myPage/(N)index2?userID=${userID }" class="link_snb_sub"
									spcid="MYCJ____left__orderlist__">주문배송 조회</a></li>
								<li><a href="/myPage/indexBd?userID=${userID }"
									class="link_snb_sub" spcid="MYCJ____left__returnlist__">취소/교환/반품
										내역</a></li>
								<li><a href="/myPage/index8" class="link_snb_sub">상품 리뷰</a></li>
								<!-- <li>
                                    <a href="#" class="link_snb_sub" spcid="MYCJ____left__rent__">증빙서류 발급</a>
                                </li> -->
							</ul></li>
						<li><strong class="tit_sub">나의 계정설정</strong>
							<ul class="list_snb_sub">
								<li><a href="/myPage/personalInfoSelect"
									class="link_snb_sub _btn_modify">회원정보수정</a></li>
								<!-- <li>
                                    <a href="#" class="link_snb_sub" spcid="MYCJ____left__pinfuse__">회원등급</a>
                                </li> -->
							</ul></li>
						<li><strong class="tit_sub">고객센터</strong>
							<ul class="list_snb_sub">
								<li><a href="/myPage/indexqna1by1" class="link_snb_sub"
									spcid="MYCJ____left__zzimall__">1:1 문의내역</a></li>
								<li><a href="/myPage/indexSearch" class="link_snb_sub"
									spcid="MYCJ____left__rwlist__">상품 Q&A 내역</a></li>
								<!-- <li>
                                    <a href="#" class="link_snb_sub" spcid="MYCJ____left__tvpush__">공지사항</a>
                                </li> -->
								<li><a href="/member/customer_service" class="link_snb_sub"
									spcid="MYCJ____left__foodstp__">FAQ</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			<div id="content">
				<div class="myzone_review">
					<h2 class="sub_title is_box">상품평 쓰기/조회</h2>
					<div class="u_tabmenu_wrap">
						<ul class="u_tabmenu type_btnst">
							<li class="on _product"><a href="/myPage/index8">상품평 쓰기</a></li>
							<li class="_comment"><a href="/myPage/index9">내가 쓴 상품평</a></li>
						</ul>
					</div>
					<div class="_commentAboutProductListContainer">
						<jsp:include page="product_evaluation.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<jsp:include page='../section/footerMain.jsp' />


		</div>
	</div>
</body>
</html>