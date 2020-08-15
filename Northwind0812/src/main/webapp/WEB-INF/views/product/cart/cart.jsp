
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" href="/resources/css/mainIndex.css">
<link rel="stylesheet" href="/resources/css/mainOriginIndex.css?ad">
<link rel="stylesheet" href="/resources/css/cart.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script>
$(function() {
	
	
	var csrfParameterName = "${_csrf.parameterName}";
	var csrfTokenValue="${_csrf.token}";
	
	
	//?${_csrf.parameterName}=${_csrf.token}
	var ttp =$("#sum").attr("value");
	var ttp1=ttp;
	$("input:checkbox[name^='cartId_']").prop('checked', true);
	var id=0; 
	var inputNum=0;
	
	$("input[name^='text_']").change(function(){
		var $i=$(this).parents('td');
		id=$i.find("input[name^='id_']").val();
		inputNum=parseInt($i.find("input[name^='text_']").val());
    	if (inputNum <= 0) {inputNum = 1;}
    	document.write('<form action="/product/cart/cartUpdate?'+ csrfParameterName +'='+ csrfTokenValue +'" id="smb_form" method="post"><input type="hidden" name="cartId" value="'+ id +'"><input type="hidden" name="quantity" value="'+ inputNum +'"></form>');
		document.getElementById("smb_form").submit();
	});
	
	$(".btn_increase").click(function( ) {
		
		var $i=$(this).parents('td');
		id=$i.find("input[name^='id_']").val();
		inputNum=parseInt($i.find("input[name^='text_']").val());
		inputNum -= 1;
		if (inputNum <= 0) {inputNum = 1;}
		/*location.href="/product/cart/cartUpdate?cartId="+id+"&quantity="+inputNum;*/
		
		document.write('<form action="/product/cart/cartUpdate?'+ csrfParameterName +'='+ csrfTokenValue +'" id="smb_form" method="post"><input type="hidden" name="cartId" value="'+ id +'"><input type="hidden" name="quantity" value="'+ inputNum +'"></form>');
		document.getElementById("smb_form").submit();

	});
	
	$(".btn_decrease").click(function( ) {
		var $i=$(this).parents('td');
		id=$i.find("input[name^='id_']").val();
		inputNum=parseInt($i.find("input[name^='text_']").val());
		inputNum += 1;
		document.write('<form action="/product/cart/cartUpdate?'+ csrfParameterName +'='+ csrfTokenValue +'" id="smb_form" method="post"><input type="hidden" name="cartId" value="'+ id +'"><input type="hidden" name="quantity" value="'+ inputNum +'"></form>');
		document.getElementById("smb_form").submit();
	});
	
	$("input:checkbox[name^='cartId_']").on('click', function() { 
		if ($(this).prop('checked') ) { 
			var $i=$(this).parents('td');
			var pdTotal=parseFloat($i.find("input[id^='hid_num']").val());
			ttp1+=pdTotal;
			
			$("#ppp").text(ttp1.toFixed(2));
		} else { 
			var $i=$(this).parents('td');
			var pdTotal=parseFloat($i.find("input[id^='hid_num']").val());
			ttp1-=pdTotal;
			
			$("#ppp").text(ttp1.toFixed(2));
		} 
	});
});
</script>

</head>
<body>
	<div id="wrap">
		<div id="header">
			<jsp:include page="../../section/headerMain.jsp"></jsp:include>
		</div>
		<div id="content" class="mainContent">
			<div class="cart_content">
				<h1 class="sub_title">
					<b>Your Cart</b>
				</h1>
				<form class="fullCart" name="formm" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value = "${_csrf.token}"/>
					<c:choose>
					<c:when test="${cartList.size() == 0}">
						<h3 style="color: red; text-align: center;">장바구니가 비었습니다.</h3>
					</c:when>
					<c:otherwise>
					<table id="cart_table">
						<tr class="cart_table_title">
							<th></th>
							<th colspan="2">Product</th>
							<th>Price</th>
							<th>Qty</th>
							<th>Total</th>
						</tr>
						<c:forEach items="${cartList}" var="cartVO">
						<tr>
							<td>
							<!-- 체크시 name=quantity2 0값 / 체크 해지시 수량 값 -->
							<input type="hidden" name="quantity2" id="hid_num" 
							value="${cartVO.price*(cartVO.quantity)}"  >

							<input type="checkbox" id="10" class="_itemCheckBox"
								value="${cartVO.cartId}" name="cartId_${cartVO.cartId}" >
							</td>
							<td class="img_thumb">
								<a href="/product/productDetails/productDetails?productId=${cartVO.productId }">
									<img src = "/resources/img/Product/${cartVO.picture }">
								</a>
							</td>
							<td class="pName_td">
								<div class="pd_name">
									<a href="/product/productDetails/productDetails?productId=${cartVO.productId }">
										${cartVO.productName}
									</a>
								</div>
								<div class="pd_remove">
								
								
								<input type="submit" value="Remove" onClick="javascript: form.action='/product/cart/cartDelete?cartId=${cartVO.cartId}'">
<%-- 		<a href="cartDelete.po?cartId=${cartVO.cartId}">Remove</a> --%>
								</div>
							</td>
							<td class="pd_price"> 
								${cartVO.price }
							</td>
							<td class="opt_change">
								<input type="hidden" name="id_${cartVO.cartId }" value="${cartVO.cartId }" >
								<input type="text" name="text_${cartVO.cartId }" value="${cartVO.quantity }" class="input_txt" 
								 oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
								<%-- <input type="button" value="변경" id="ch_btn" name="ch_btn_${cartVO.cartId }"> --%>
								<input type="button" value="－ " class="qty_btn btn_increase" id="in_${cartVO.cartId }"
								name="in_${cartVO.cartId }" > 
								<input type="button" value="＋ " class="qty_btn btn_decrease" id="de_${cartVO.cartId }"
								name="de_${cartVO.cartId }" >
							</td>
							<td class="pd_total">
								<fmt:formatNumber value="${cartVO.price*(cartVO.quantity)}" type="number"/>
							</td>
						</tr>
						</c:forEach>
					</table>
					<div id="total_calc">
						<div class="order_price order_price_title">Estimated Total</div>
						<div class="order_price order_price_total">
							<strong> 
							$<fmt:formatNumber value="${totalPrice}" type="number" var="ttp" pattern=".00"/>
							<input type="hidden" name="sum" id="sum" value="${ttp}">
							<span id="ppp">${totalPrice}</span>
							</strong>
						</div>
						<c:if test="${cartList.size() != 0}">
							<div class="u_tb_wrap">
								<input type="submit" class="u_btn btn_all_buy"
								id="_allItemBuyButton" 
								value="Go to Checkout" onClick="javascript: form.action='/myPage/mainOrders'">
							</div>
						</c:if>
					</div>
					</c:otherwise>
					</c:choose>
					</form>
					<div class="cmt_guide">
						<ul>
							<li>장바구니에 담은 상품은 30일 후 삭제됩니다.</li>
							<li>장바구니에는 최대 50개의 상품을 담으실 수 있습니다.</li>
							<li>무이자 할부 개월수가 서로 다른 상품을 동시 주문 시, 가장 짧은 기간 기준으로 무이자 할부가
								가능합니다.</li>
							<li>일부 상품에 대해 결제수단이 제한될 수 있습니다.</li>
						</ul>
					</div>
			</div>
		</div>
		<div id="footer">
			<jsp:include page="../../section/footerMain.jsp"></jsp:include>
		</div>
	</div>
	
</body>
</html>
