<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Northwind</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/resources/jquery/customer_service_con.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" href="/resources/css/mainIndex.css">
<link rel="stylesheet" href="/resources/css/mainOriginIndex.css">
<link rel="stylesheet" href="/resources/css/customer_service_con.css">
<link rel="stylesheet" href="/resources/css/myqna.css">

</head>
<body>

	<div id="wrap">
		<div id="header">

			<jsp:include page="../section/headerMain.jsp" />
		</div>
		<div id="contents">
			<div id="aside">
				<h2 class="tit_cs_linkCustomerCenterMain">
					<a class="service_a" href="/member/customer_service" spcid="MYCJ____left__csct__">고객센터</a>
					<strong class="blind">메뉴</strong>
				</h2>
				<div class="cs_snb">
					<ul class="list_snb">
						<li><strong class="tit_sub">자주하는 질문</strong>
							<ul class="list_snb_sub">
								<li class="_cat05" data-cat="05"><a
									href="/member/customer1_shipping" class="service_a2"
									spcid="CUST____main__topq__">배송</a></li>
								<li class="_cat02" data-cat="02"><a
									href="/member/customer2_order" class="service_a2"
									spcid="CUST____main__topq__">주문/결제</a></li>
								<li class="_cat06" data-cat="06"><a
									href="/member/customer3_return" class="service_a2"
									spcid="CUST____main__topq__">반품/교환/환불</a></li>
								<li class="_cat01" data-cat="01"><a
									href="/member/customer4_member" class="service_a2"
									spcid="CUST____main__topq__">회원</a></li>
								<li class="_cat09" data-cat="09"><a
									href="/member/customer5_goods" class="service_a2"
									spcid="CUST____main__topq__">상품</a></li>
								<li class="_cat10" data-cat="10"><a
									href="/member/customer6_etc" class="service_a2"
									spcid="CUST____main__topq__">기타</a></li>
							</ul></li>
						<li><strong class="tit_sub">고객활동</strong>
							<ul class="list_snb_sub">
								
								<li>
								<sec:authorize access="isAnonymous()">
										<a href="/member/mainLoginPage" class="service_a2"
											spcid="CUST____main__board__" onclick="loginNeeded();">나의 문의 내역</a>
								</sec:authorize>
								<sec:authorize access="isAuthenticated()">
										<a href="/member/customer8_myqna" class="service_a2"
											spcid="CUST____main__board__" >나의 문의 내역</a>
								</sec:authorize></li>
							</ul>
						</li>
					</ul>		
				</div>
			</div>
			<div id="content">
				<h1 id="qna_head">나의 문의 내역</h1>
				<div class="board_qna">
					<div id="qnaList-wrapper">
						<table cellspacing="0" border="0" class="tb_board tb_qna">
							<colgroup>
								<col width="9%">
								<col width="13%">
								<col width="13%">
								<col width="52%">
								<col width="13%">
							</colgroup>
							<thead>
								<tr class="">
									<th scope="col">번호</th>
									<th scope="col">문의종류</th>
									<th scope="col">답변상태</th>
									<th scope="col">제목</th>
									<th scope="col">등록일</th>
								</tr>
							</thead>
							<tbody>
								<%--게시글 테이블 불러오는 코드 삽입--%>
								<c:forEach items="${bProductDtos}" var='bProductDtos'
									varStatus='status'>
									<c:set var="bGroup" value="${bProductDtos.boardGroup }" />
									<tr class="item">
										<td>${bProductDtos.rn }</td>
										<td>${bProductDtos.boardOption }</td>
										<td>${bProductDtos.boardAnswered }</td>
										<td>${bProductDtos.boardTitle }</td>
										<td><c:set var='dateValue'
												value="${bProductDtos.boardDate}" />
											${fn:substring(dateValue,0,10)}</td>
									</tr>
									<tr class="hide">
										<td colspan="3">
											<div class="item_name">
												<!-- 상품명 클릭시 해당 상품 상세페이지 이동 -->
												<a
													href="../productDetails/productDetails_view.po?productId=${bProductDtos.productID}">${bProductDtos.productName }</a>
											</div>
											<div class="item_img"><img src="/resources/img/Product/${bProductDtos.picture }"></div>
											
										</td>
										<td colspan="3">
											<div class="q-cus">
												<span class="icon-q">Q</span> ${bProductDtos.boardContent }
											</div> <c:choose>
												<c:when test="${bProductDtos.boardAnswered ne '검토중'}">

													<div class="a-sel">
														<span class="icon-a">A</span>
														<c:forEach items="${replyDtos }" var='replyDtos'
															varStatus='status1'>
															<c:set var="rBgroup" value="${replyDtos.boardGroup }" />
															<c:if test="${bGroup == rBgroup }">
															${replyDtos.boardContent }
															</c:if>
														</c:forEach>
													</div>
													<p class="reginfo">
														<span class="wh">판매자의 답변</span> <span class="date">등록일
															: <em> <c:forEach items="${replyDtos }"
																	var='replyDtos' varStatus='status1'>
																	<c:set var="rBgroup" value="${replyDtos.boardGroup }" />
																	<c:if test="${bGroup == rBgroup }">
																	${replyDtos.boardDate}
																</c:if>
																</c:forEach>
														</em>
														</span>
													</p>
												</c:when>
												<c:otherwise>

												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!--pagination-->
						<div class="pagination">
							<ul>
								<c:if test="${pageMaker.prev}">
									<li><a
										href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach var="idx" begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }">
									<c:choose>
									<c:when test="${idx eq pageMaker.cri.page}">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a style="background-color:#DA006B;font-weight:700;color:#fff;" href="customer8_myqna${pageMaker.makeQuery(idx)}">${idx}</a>
									</li>
									</c:when>
									<c:otherwise>
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="customer8_myqna${pageMaker.makeQuery(idx)}">${idx}</a>
									</li>
									</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="listPage${pageMaker.makeQuery(pageMaker.endPage +1) }">&raquo;</a></li>
								</c:if>
							</ul>
						</div>

						<form id="jobForm">
							<input type='hidden' name="page" value=${pageMaker.cri.perPageNum}>
							<input type='hidden' name="perPageNum"
								value=${pageMaker.cri.perPageNum}>
						</form>

						<script>
							$(function() {
								var article = (".tb_board .show");
								$(".tb_board .item  td").click(
										function() {
											var myArticle = $(this).parents()
													.next("tr");
											if ($(myArticle).hasClass('hide')) {
												$(article).removeClass('show')
														.addClass('hide');
												$(myArticle)
														.removeClass('hide')
														.addClass('show');
											} else {
												$(myArticle).addClass('hide')
														.removeClass('show');
											}
										});
							});

							$(".pagination.test li a").on(
									"click",
									function(event) {

										event.preventDefault();

										var targetPage = $(this).attr("href");

										var jobForm = $("#jobForm");
										jobForm.find("[name='page']").val(
												targetPage);
										jobForm.attr("action",
												"/member/customer8_myqna")
												.attr("method", "get");
										jobForm.submit();
									});
						</script>
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