<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function deleteOk() {
	alert("삭제 되었습니다.");
}
</script>
<style type="text/css">
body table{
	margin-left: 50px;
}
.set img{
	width: 100px;
	height: 100px;
	margin-left: 10px;
}


.tableSet {
	border-collapse: collapse;
	border-color: #ccc;
	border-spacing: 0;
}

.tableSet td {
	background-color: #fff;
	border-color: #ccc;
	border-style: solid;
	border-width: 1px;
	color: #333;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 8px 20px;
	word-break: normal;
}

.tableSet th {
	background-color: #f0f0f0;
	border-color: #ccc;
	border-style: solid;
	border-width: 1px;
	color: #333;
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	overflow: hidden;
	padding: 8px 20px;
	word-break: normal;
}

.tableSet .set {
	background-color: #ffffff;
	border-color: #efefef;
	font-size: 14px;
	text-align: left;
	vertical-align: top;
	
}


.tableSet .boardSet {
	background-color: #ffffff;
	border-color: #efefef;
	font-weight: bold;
	text-align: center;
	text-decoration: underline;
	vertical-align: top;
}

.tableSet .set01 {
	background-color: #ffffff;
	border-color: #efefef;
	font-size: 14px;
	text-align: left;
	vertical-align: top;
	color: #9b9b9b;
	
}

.tableSet .productName {
	background-color: #ffffff;
	border-color: #efefef;
	font-family:Arial, Helvetica, sans-serif !important;;
	font-size: 14px;
	text-align: left;
	vertical-align: top;
}
.bar{
	color:#efefef;
}
#pictures img{
	width: 100px; !important; 
	height: 100px; !important;
	text-align: center;
	margin-top: 20px;
}
.deleteSubmit{
	background-color : #FFFFFF;
	border : none;
	
}
</style>
</head>
<body>
<c:choose>
<c:when test="${empty rDtos }">
	<h2 style="text-align: center;">작성한 상품평이 없습니다.</h2>
</c:when>
<c:otherwise>
<table class="tableSet" style="table-layout: fixed; width: 504px">
	<colgroup>
		<col style="width: 20px">
		<col style="width: 20px">
		<col style="width: 20px">
		<col style="width: 20px">
		<col style="width: 25px">
		<col style="width: 35px">
		<col style="width: 35px">
		<col style="width: 35px">
		<col style="width: 35px">
		<col style="width: 50px">
		<col style="width: 50px">
		<col style="width: 50px">
		<col style="width: 50px">
		<col style="width: 90px">
		<col style="width: 90px">
	</colgroup>
	<thead>
	<c:forEach items="${rDtos}" var="rDto"> 
		<input type="hidden" name="boardNum" value="${rDto.boardNum }"/>
		<tr>
			<th class="boardSet" colspan="6" rowspan="4"> 
			<a href="/product/productDetails/productDetails?productId=${rDto.productID }">
                   <div id="pictures"><img src = "/resources/img/Product/${rDto.picture }"></div> 
             </a></th>
			<th class="productName" colspan="9"><strong>${rDto.productName }</strong></th>
		</tr>
		<tr>
		<c:forEach items="${dto1}" var="dto1"> 
		<c:choose>
			<c:when test="${dto1.boardNum == rDto.boardNum }">
			<td class="set" colspan="4" rowspan="2" ><img src="<c:url value='/picture/${dto1.fileNewName}'/>"/></td>
			</c:when>
		</c:choose>
		</c:forEach>	
		</tr>
		
		<tr>
			<td class="set" colspan="9" height="70px">${rDto.boardContent }</td>
		</tr>
		
		<tr>
			<td class="set01" colspan="6">${rDto.customerID } <span class="bar"> &nbsp; | &nbsp; </span>${rDto.boardDate }</td>
			<td class="set" colspan="2" id="control"><a href="/myPage/index9Update?customerID=${rDto.customerID }&boardNum=${rDto.boardNum }&orderID=${rDto.orderID}">수정</a></td>
			<td class="set" colspan="2" id="control">
			<form action = "/myPage/index9Delete" method = post>
				<input type="hidden" name="${_csrf.parameterName}" value = "${_csrf.token}"/>
				<input type="hidden" name="boardNum" value="${rDto.boardNum }"/>
				<input type = "submit" value = "삭제" onclick="deleteOk();" class = deleteSubmit>
			</form>
			 <td>
		</tr>
				
	</c:forEach>
	</thead>
</table>
</c:otherwise>
</c:choose>	
</body>