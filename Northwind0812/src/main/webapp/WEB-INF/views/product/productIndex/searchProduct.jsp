<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" href="/resources/css/mainIndex.css">
<link rel="stylesheet" href="/resources/css/mainOriginIndex.css">
<link rel="stylesheet" href="/resources/css/categoriesPage.css" />
<link rel="icon" type="image/x-icon"
	href="../container/assets/favicon.ico" />
</head>
<body style="">
	<div id="wrap">
		<div id="header">
			<jsp:include page="../../section/headerMain.jsp" />
			<div id="contents">
				<div id="total_list">
					<c:choose>
						<c:when test="${empty search }">
							<div id=slide_list>
								<img src='/resources/img/Category/noResult.jpg' width="1034px">
							</div>
						</c:when>
						<c:otherwise>
							<div id=slide_list>
								<img src='/resources/img/Category/searchimg.png' width="1034px">
							</div>
						</c:otherwise>
					</c:choose>
					<div id=main_list>

						<!--<h4 class="blind">상품 목록</h4>-->
						<ul class="mass_list">
							<c:forEach items="${search}" var="dto">
								<div id="main"
									style='float: left; margin: 32px; text-align: center; background: #ffffff; margin-bottom: 20px;'>
									<div id="picture" style='width: 210px; height: 210px;'>
										<a href="/product/productDetails/productDetails?productId=${dto.productId }">
											<img src="/resources/img/Product/${dto.picture}"></a>
									</div>
								<div id="name"
									style='margin-top: 20px; font-size: 20px; color: #6A6B6D; width: 210px; height: 55px;'>
									<b>${dto.productName }</b>
								</div>
								<div id='price' style='font-size: 17px; color: black;'>
									<b>$${dto.unitPrice }</b>
								</div>
					</div>
					</c:forEach>
					</ul>
				</div>

			</div>
		</div>

		<div id="footer">
			<jsp:include page="../../section/footerMain.jsp" />
		</div>
	</div>
	</div>

</body>
</html>