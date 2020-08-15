<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beverages</title>
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
					<div id=slide_list>
						<c:choose>
							<c:when test="${categoryId ==1 }">
								<img src='/resources/img/Category/beverages.jpg' width="1034px">
							</c:when>
							<c:when test="${categoryId ==2 }">
								<img src='/resources/img/Category/condiments.jpg' width="1034px">
							</c:when>
							<c:when test="${categoryId ==3 }">
								<img src='/resources/img/Category/confections.jpg'
									width="1034px">
							</c:when>
							<c:when test="${categoryId ==4 }">
								<img src='/resources/img/Category/dairy_products.jpg'
									width="1034px">
							</c:when>
							<c:when test="${categoryId ==5 }">
								<img src='/resources/img/Category/grains_cereals.jpg'
									width="1034px">
							</c:when>
							<c:when test="${categoryId ==6}">
								<img src='/resources/img/Category/meat_poultry.jpg'
									width="1034px">
							</c:when>
							<c:when test="${categoryId ==7}">
								<img src='/resources/img/Category/produce.jpg' width="1034px">
							</c:when>
							<c:when test="${categoryId ==8}">
								<img src='/resources/img/Category/seafood.jpg' width="1034px">
							</c:when>
						</c:choose>
					</div>
					<div id=main_list>
						<!-- <ul class="mass_list"> -->
							<c:forEach items="${dtos}" var="dto">
								<div 
									style='float: left; margin: 32px; text-align: center; background: #ffffff; margin-bottom: 20px;'>
									<div id="picture" style='width: 210px; height: 210px'>
										<a href="/product/productDetails/productDetails?productId=${dto.productId }">
										<img  src="/resources/img/Product/${dto.picture}">	
										</a>
									</div>
									<div 
										style='margin-top: 10px; font-size: 13px; color: #6A6B6D; width: 210px;'>
										<b>${dto.productName }</b>
									</div>
									<div  style='font-size: 10px; color: black;'>
										<b>$${dto.unitPrice }</b>
									</div>
								</div>
							</c:forEach>
						<!-- </ul> -->
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