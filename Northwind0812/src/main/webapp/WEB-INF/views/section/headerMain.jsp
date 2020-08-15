<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!-- <script type="text/javascript">
function logout() {
return confirm("로그아웃하시겠습니까?")

}
</script> -->
<div class="header_inner_wrap">
	<div class="global_width">
		<div class="header_inner">
			<h1>
				<!-- Home 클릭 이미지 -->
				<a href="/main/main"> <img src="/resources/img/northwind8.png">
				</a>
			</h1>
			<div class=srh_wrapper>
				<div class="srh_area">

					<form id="submitFrm" name="submitFrm"
						action="/product/productIndex/searchProduct">
						<fieldset>
							<legend> 통합검색어 입력 </legend>
							<div class="ui_input">
								<input type="text" id="srh_keyword" class="input_txt"
									name="search" autocomplete="off" maxlength="30"
									placeholder="Search">

								<button type="submit" class="fas fa-search"
									style="margin-top: -11px;"></button>
								<button class="_search"></button>

							</div>
						</fieldset>
					</form>
				</div>
			</div>

		</div>

		<!-- <div class="category_wrap">
                         카테고리 마우스 오버 
                    </div> -->
		<div class="tab_home line">
			<!-- 카테고리 탭 -->
			<div class="lst_home_wrap">
				<ul class="lst_home">
					<li><a href="/product/productIndex/productList?categoryId=1"
						class=" "> <!-- 클릭시 'on' 클래스 추가 --> <span class="m_name">Beverages</span>
					</a></li>
					<li><a href="/product/productIndex/productList?categoryId=2"
						class=" "> <span class="m_name">Condiments</span>
					</a></li>
					<li><a href="/product/productIndex/productList?categoryId=3"
						class=" "> <span class="m_name">Confections</span>
					</a></li>
					<li><a href="/product/productIndex/productList?categoryId=4"
						class=" "> <span class="m_name">Dairy Products</span>
					</a></li>
					<li><a href="/product/productIndex/productList?categoryId=5"
						class=" "> <span class="m_name">Grains/Cereals</span>
					</a></li>
					<li><a href="/product/productIndex/productList?categoryId=6"
						class=" "> <span class="m_name">Meat/Poultry</span>
					</a></li>
					<li><a href="/product/productIndex/productList?categoryId=7"
						class=" "> <span class="m_name">Produce</span>
					</a></li>
					<li><a href="/product/productIndex/productList?categoryId=8"
						class=" "> <span class="m_name">Seafood</span>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="util_menu">
			<!-- 로그인 마이페이지 장바구니 -->
			<ul>
				<li class="log_in">
					<!-- 스프링 시큐리티 표현식 사용 --> <sec:authorize access="isAnonymous()">
						<a href="/member/mainLoginPage" class="_loginBtn"><span
							class="ico">&nbsp;</span> LOGIN </a>
					</sec:authorize> <sec:authorize access="isAuthenticated()">
						<a href="/member/customLogout" class="_loginBtn"><span
							class="ico">&nbsp;</span> LOGOUT </a>
					</sec:authorize>
				</li>
				<li class="myzone">
				<sec:authorize access="isAnonymous()">
				<form>
					<a href="/member/mainLoginPage" id="go_myzone">
						<span class="ico">&nbsp;</span> MY PAGE
					</a>
					<input type="hidden" name="loginRedirect" value="/myPage/index">
				</form>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<a href="/myPage/index" id="go_myzone">
						<span class="ico">&nbsp;</span> MY PAGE
					</a>
				</sec:authorize>
				</li>
				<sec:authorize access="isAnonymous()">
				<li class="cart "><a href="/member/mainLoginPage"> <span
						class="ico">&nbsp;</span> CART
				</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
				<li class="cart "><a href="/product/cart/cart"> <span
						class="ico">&nbsp;</span> CART
				</a></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
	<!-- <div class="quick_menu_float"></div> -->
</div>
