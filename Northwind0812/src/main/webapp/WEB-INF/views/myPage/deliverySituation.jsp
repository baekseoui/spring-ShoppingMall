<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">

<div id="aside">
	<h2 class="tit_cs">
		<a href="/myPage/index">MY PAGE</a>
	</h2>
	<div class="cs_snb">
		<ul class="list_snb">
			<li><strong class="tit_sub">나의 쇼핑정보</strong>
				<ul class="list_snb_sub">
					<li><a href="/myPage/(N)index2?userID=${userID }"
						class="link_snb_sub" spcid="MYCJ____left__orderlist__">주문배송 조회</a></li>
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
	<div class="myzone_shopping type">
		<h1 class="sub_title is_box" id="_order_list_header" style="">주문/배송
			조회</h1>

		<form action="(N)index2?state=${state }" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="select_search_date _order_list_search">
				<div class="search_selectbx _search_date">
					<select id="select_id" title="선택옵션"
						class="u_d_sel _search_date_select" name="period">
						<option value="-1" selected>선택해주세요</option>
						<option value="1">최근 1개월</option>
						<option value="3">최근 3개월</option>
						<option value="6">최근 6개월</option>
						<option value="12">최근 1년</option>
						<option value="0">전체 기간</option>
					</select>
				</div>
				<div class="search_prdname">

					<button class="sesarch_btn">
						<span>조회</span>
					</button>
				</div>
			</div>
		</form>

		<h2 class="blind">주문/배송 조회 결과 목록</h2>
		<div class="_order_list_content order_prod_area" role="list"
			id="_order_listpage">



			<div role="listitem" class="order_prod">
				<a href="index6?userID=${userID }" class="link_order"
					spcid="MYCJ____oderstatus__orddetail__"> <span
					class="num_order" spcid="MYCJ____oderstatus__orddetail__">2020-07-20
						00:00:00 </span> <span class="txt_more"
					spcid="MYCJ____oderstatus__orddetail__">주문상세보기<span
						class="ic3-6"></span></span>
				</a>
				<div class="box_wrap">
					<div class="box_prod">
						<a href="#" spcid="MYCJ____oderstatus__itemimage__"
							class="link_thumb _itemImage"> <img
							src='${pageContext.request.contextPath}/resources/img/Product/Chai.jpg'>
						</a>

						<div class="prod_details">
							<span class="txt_state"> <c:set var="val1"
									value="${orderStat}" /> 배송준비중
							</span> <strong class="tit_prod"> <a href="#"
								spcid="MYCJ____oderstatus__item__" class="link_cont">${productStat[status.index].productName }</a>
							</strong> <span class="info_option"> <span class="txt_count">${detailStat[status.index].quantity }
									<span class="num">1개</span>
							</span><span class="txt_bar">|</span> <span class="txt_option">${productStat[status.index].quantityPerUnit }</span><br>

							</span> <em class="num_amount">180.00원</em>

						</div>

						<div class="btn_area">
							<c:choose>
								<c:when test="${val1.shippedDate == null}">
									<form action="DelivCancel" method="post">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
										<div class="inner">
											<button class="u_btn _cancel_btn _buttonLinkUrl"
												onClick="alert('해당 상품 주문이 취소되었습니다.')">주문취소</button>
										</div>
									</form>
								</c:when>
							</c:choose>
						</div>

					</div>
				</div>
			</div>

			<!-- pagination -->
			<!-- <div class="u_pagination">
				<div class="pagination_inner">
					[D] 이전,다음 버튼 비활성화시 off 클래스 추가
					[취교반] 페이징 없을 때는 표시 안함
					<strong class="lk_pn on">1</strong>
					[취교반] 페이징 없을 때는 표시 안함
				</div>
			</div> -->
			<!-- //pagination -->
		</div>
	</div>

</div>