<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>

<!-- 데이트 형변환 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<link href="/resources/manager/css/manager/employees2.css"
	rel="stylesheet" type="text/css" />
<title>Employees</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#insert_btn").click(function() {
					$("#insert").stop().toggle();
					$("#update").stop().hide();
				})
				$("#update_btn").click(function() {
					$("#update").stop().toggle();
					$("#insert").stop().hide();
				})
				$(".exit").click(function() {
					$("#update").stop().hide();
					$("#insert").stop().hide();
				})

				/* 체크박스 값 넘기기 */

				$("#update_btn").on("click", function() {
					var checkArr = []; // 배열 초기화
					var token = $("meta[name='_csrf']").attr("content");
					var header = $("meta[name='_csrf_header']").attr("content");

					if ($(".asd :checked").size() > 1) {
						alert("1개만 선택하세요.");
						$("#update").stop().hide();
						return;
					} else {
						$("input[name='checkdata']:checked").each(function(i) {
							checkArr.push($(this).val()); // 체크된 것만 값을 뽑아서 배열에 push
						})

						$.ajax({
							url : '/manager2/updatelist',
							type : 'post',
							dataType : 'json',
							data : {
								valueArrTest : checkArr
							},
							beforeSend : function(xhr) {

								xhr.setRequestHeader(header, token);

							}
						});
					}
				});

				$("#delete_btn").on("click", function() {
					var checkArrdelete = []; // 배열 초기화
					var token = $("meta[name='_csrf']").attr("content");
					var header = $("meta[name='_csrf_header']").attr("content");
					
					if ($(".asd :checked").size() > 1) {
						alert("1개만 선택하세요.");
						return;
					} else {
						$("input[name='checkdata']:checked").each(function(i) {
							checkArrdelete.push($(this).val()); // 체크된 것만 값을 뽑아서 배열에 push
						})
						$.ajax({
							url : '/manager2/delete',
							type : 'post',
							dataType : 'json',
							data : {
								valueArrTestdel : checkArrdelete
							},
							beforeSend : function(xhr) {

								xhr.setRequestHeader(header, token);

							}
						});
					}
				});

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "employees"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

			})
</script>


</head>
<body>

	<header>
		<jsp:include page="View.jsp" flush="true" />
	</header>

	<div id="wrap">
		<div id="header_11">
			<div>
				<h2>사원정보</h2>
			</div>
		</div>
		<div id="header_22"></div>
		<div id="search">

			<select name="searchType">
				<option value="n"
					<c:out value="${cri.searchType == null?'selected':''}"/>>
					---</option>
				<option value="t"
					<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
					사원번호</option>
				<option value="c"
					<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
					사원명</option>
			</select> <input type="text" name='keyword' id="keywordInput"
				value='${cri.keyword }'>
			<button class="search_btn" id='searchBtn'>검색</button>

		</div>


		<div class="recode" id="recode">
			<div>사원번호</div>
			<div>이름(직무)</div>
			<div>주소</div>
			<div>입사일</div>
			<div>전화번호</div>
			<div>관리</div>
			<div class="clear"></div>
		</div>
		<!-- 자바 스크립트로 만든 check박스 값을 사용하기위한 form태그  결과를 처리할 Jsp로 보내야함(처리후 다시 불러오기)-->



		<c:forEach items="${employees}" var="dto">
			<div class="asd" id="asd">
				<div>${dto.employeeid }</div>
				<div>${dto.firstname }_${dto.lastname }<br>(${dto.title })
				</div>
				<div>${dto.address }_${dto.city }_${dto.region }_${dto.postalcode }_${dto.country }</div>

				<!-- 데이트 형변환 -->
				<div>
					<fmt:formatDate pattern="yyyy-MM-dd" value="${dto.hiredate }" />
				</div>

				<div>${dto.homephone }</div>

				<div>
					<input type="checkbox" name='checkdata' value='${dto.employeeid }'>
				</div>

			</div>
		</c:forEach>

		<div id="update">
			<form action="/manager2/update" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <input class="sql_text" type="hidden"
					name="updateDataemployeeid">
				<div class="insertall">
					<div class="insert1">LastName:</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatalastname">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">FirstName:</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatafirstname">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Title:</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatatitle">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">TitleOfCourtesy:</div>
					<div class="insert2">
						<input class="sql_text" type="text"
							name="updateDatatitleofcourtesy">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Address :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDataaddress">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">City :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatacity">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Region :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDataregion">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">PostalCode :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatapostalcode">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Country :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatacountry">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">HomePhone :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatahomephone">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Extension :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDataextension">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Photo :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDataphoto">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Notes :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatanotes">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">ReportsTo :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDatareportsto">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">PhotoPath :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="updateDataphotopath">
					</div>
				</div>
				<br> <input class="sql_btn" id="updatebtn" type="submit"
					name="update" value="수정하기">
			</form>
		</div>



		<div id="insert">
			<form action="/manager2/insert" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="insertall">
					<div class="insert1">EmployeeID:</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="employeeid">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">LastName:</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="lastname">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">FirstName:</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="firstname">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Title:</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="title">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">TitleOfCourtesy:</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="titleofcourtesy">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">BirthDate:</div>
					<div class="insert2">
						<input class="sql_text" type="datetime-local" name="birthdate">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">HireDate:</div>
					<div class="insert2">
						<input class="sql_text" type="datetime-local" name="hiredate">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Address :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="address">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">City :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="city">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Region :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="region">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">PostalCode :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="postalcode">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Country :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="country">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">HomePhone :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="homephone">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Extension :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="extension">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Photo :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="photo">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">Notes :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="notes">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">ReportsTo :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="reportsto">
					</div>
				</div>
				<br>
				<div class="insertall">
					<div class="insert1">PhotoPath :</div>
					<div class="insert2">
						<input class="sql_text" type="text" name="photopath">
					</div>
				</div>
				<br> <input class="sql_btn" type="submit" name="insert"
					value="입력"><br>
			</form>
		</div>





		<div id="submit_box">
			<form action="/manager2/employees">
				<input type="submit" id="delete_btn" name="delete" value="삭제">
			</form>


		</div>




		<div id="input_box">
			<button id="insert_btn">입력</button>
			<button id="update_btn">수정</button>
		</div>

		<div id="post_page_box">
			<div id="rel_box"></div>
			<div id="post_page"></div>
			<div id="next_box"></div>
			<div class="clear"></div>
		</div>


		<div class="box-footer">

			<div class="text-center">
				<ul class="pagination">

					<c:if test="${pageMaker.prev}">
						<li><a
							href="employees${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a href="employees${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="employees${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>

				</ul>
			</div>

		</div>

	</div>
</body>
</html>