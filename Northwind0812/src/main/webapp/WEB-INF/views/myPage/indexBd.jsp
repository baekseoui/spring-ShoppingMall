<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Northwind</title>
<link rel="icon" type="image/x-icon"
	href="../container/assets/favicon.ico" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mainIndex.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/common.cjmall.pc.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/common.cjos.pc.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mainOriginIndex.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.cjmall.pc.myzone-shopping.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/page.cjmall.pc.account.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.cjmall.pc.myzone-main_v3.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/script/mypage.js"></script>
<style>
.tr_io {
	font-weight: bold;
	font-size: 18px;
	font-family: '나눔바른고딕', 'Nanum Barun Gothic', '나눔바른고딕OTF',
		NanumBarunGothicOTF, 'Malgun Gothic', Arial, sans-serif;
}

.td_io {
	font-size: 14px;
	font-family: '나눔바른고딕', 'Nanum Barun Gothic', '나눔바른고딕OTF',
		NanumBarunGothicOTF, 'Malgun Gothic', Arial, sans-serif;
	text-align: center;
	width: 180px;
	border: 1px solid #d9d9d9;
	height: 50px;
}

#div_io_1 {
	/* display: none; */
	height: 500px;
	overflow: auto;
}

#div_io_2 {
	/* display: none; */
	
}

#div_io {
	font-size: 15px;
}

#orderID_io {
	border: 1px solid #d9d9d9;
	width: 200px;
	height: 25px
}

#button_io {
	border: 1px solid #007bc8;
	width: 40px;
	height: 25px;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<jsp:include page='../section/headerMain.jsp' />

		</div>
		<div id="container">
			<div id="container">
				<div id="aside">
					<h2 class="tit_cs">
						<a href="/myPage/index">MY PAGE</a>
					</h2>
					<div class="cs_snb">
						<ul class="list_snb">
							<li><strong class="tit_sub">나의 쇼핑정보</strong>
								<ul class="list_snb_sub">
									<li><a href="/myPage/(N)index2?userID=${userID }"
										class="link_snb_sub" spcid="MYCJ____left__orderlist__">주문배송
											조회</a></li>
									<li><a href="/myPage/indexBd?userID=${userID }"
										class="link_snb_sub" spcid="MYCJ____left__returnlist__">취소/교환/반품
											내역</a></li>
									<li><a href="/myPage/index8" class="link_snb_sub">상품
											리뷰</a></li>
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
									<li><a href="/member/customer_service"
										class="link_snb_sub" spcid="MYCJ____left__foodstp__">FAQ</a></li>
								</ul></li>
						</ul>
					</div>
				</div>

				<div id="content">
					<div class="myzone_shopping type">
						<h1 class="sub_title is_box" id="_order_list_header" style="">취소/교환/반품
							조회</h1>

						<div class="select_search_date _order_list_search">
							<form action="indexBd" method="get" name="myForm" id="myForm">
								<input type="hidden" value="${userID}" name="userID">
								<div class="search_selectbx _search_date">
									<select title="선택옵션" class="u_d_sel _search_date_select"
										name="listIndex">
										<option value="-1">선택해주세요</option>
										<option value="1">최근 1개월</option>
										<option value="3">최근 3개월</option>
										<option value="6">최근 6개월</option>
										<option value="0">전체 기간</option>
									</select>

								</div>
								<div class="search_prdname">
									<button type="button" class="sesarch_btn" onclick="Check()"
										name="id">
										<span>조회</span>
									</button>
								</div>
							</form>
						</div>

						<h2 class="blind">취소/교환/반품 조회 결과 목록</h2>
						<div class="_order_list_content order_prod_area" role="list">
							<div class="order_prod_area">
								<div class="notice_bx">
									<div id="div_io_1">
										<table>
											<tr class="tr_io">
												<td class="td_io">회원 아이디</td>
												<td class="td_io">신청날짜</td>
												<td class="td_io">완료날짜</td>
												<td class="td_io">구분</td>
												<td class="td_io">주문번호</td>
											</tr>

											<c:choose>
												<c:when test="${fn:length(dtos)!=0}">
													<c:forEach items="${dtos}" var="dto">
														<tr>
															<td class="td_io">${dto.customerID}</td>
															<td class="td_io">${dto.dateFormat}</td>
															<c:choose>
																<c:when test="${empty dto.finishDate}">
																	<td class="td_io">(처리중)</td>
																</c:when>
																<c:otherwise>
																	<td class="td_io">${dto.finishDate}</td>
																</c:otherwise>
															</c:choose>
															<td class="td_io">${dto.type}</td>
															<td class="td_io">${dto.orderID}</td>
														</tr>
													</c:forEach>
												</c:when>
											</c:choose>
										</table>
										<c:choose>
											<c:when test="${fn:length(dtos) == 0}">
												<div id="div_io_2">
													<p class="notice_empty" id="p_io">
														<span class="ico_empty"></span> ${messeng }
													</p>
												</div>
											</c:when>
										</c:choose>
									</div>

									<ul class="noti_txt">
										<li>취소/교환/반품신청을 찾고 계시나요?</li>
										<li>주문배송조회 또는 주문상세 내역에서 확인 하실 수 있습니다.</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="footer">
				<jsp:include page='../section/footerMain.jsp' />
			</div>
		</div>
	</div>
</body>
</html>