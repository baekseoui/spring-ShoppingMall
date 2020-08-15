<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   		String check = request.getParameter("pagenum");
   		if(check==null){
   			check = "1";
   		}
   		
   %>
    
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/View.css"/>
    <title>Document</title>

    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="jquery-ui.js"></script>


</head>
<body>
    <div id="header_1">
        <div id="header_content_1">
            <div id="content1_d1">
            	<a href="Employees_Select.do?page=1">
                	<b>ADMINSTRATOR</b>
                </a>
            </div>
            <div id="content1_d2">
              
                <a href="logout.so">로그아웃</a>
                <div class="clear"style="border: 0px;"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div id="header_2">
        <div id="header_content_2">
	        <a href="Employees_Select.do?page=1"><div class="content_2_div">사원정보</div></a>
            <a href="Customer_Select.do?page=1"><div class="content_2_div">고객정보</div></a>
            <a href="productSelect.do?page=1"><div class="content_2_div">물건정보</div></a>
            <a href="qna_select.do?page=1"><div class="content_2_div">문의내역</div></a>
            <a href="Order_select.do?page=1"><div class="content_2_div">주문정보</div></a>
            <a href="ClientCheck_Select.do?page=1"><div class="content_2_div">거래처정보</div></a>
            <div class="clear"></div>
        </div>
    </div>
    

 
</body>
</html>