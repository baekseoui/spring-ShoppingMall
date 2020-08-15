<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>


<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>���̵� �ߺ� üũ</title>
	
	<style type="text/css">
		#wrap {
			width: 490px;
			text-align :center;
			margin: 0 auto 0 auto;
		}
		
		#chk{
			text-align :center;
		}
		
		#cancelBtn{
			visibility:visible;
		}
		
		#useBtn{
			 visibility:hidden;
		}

	</style>
	
	<script type="text/javascript">
	
		// ȸ������â�� ���̵� �Է¶��� ���� �����´�.
		// ����ϱ� Ŭ�� �� �θ�â���� �� ���� 
		
		function sendCheckValue(){
			// �ߺ�üũ ����� idCheck ���� �����Ѵ�.
			opener.document.registerform.id_Check.value ="idCheck";
			// ȸ������ ȭ���� ID�Է¶��� ���� ����
			opener.document.registerform.id.value = document.getElementById("userid").value;
			
			self.close();
				
		}	
		function signUp_Check() { 
		var form = document.checkform
			if((form.userid.value < "0" || form.userid.value > "9") && (form.userid.value < "A" || form.userid.value > "Z") && (form.userid.value < "a" || form.userid.value > "z")){ 
				alert("�ѱ� �� Ư�����ڴ� ���̵�� ����Ͻ� �� �����ϴ�.");
				form.userid.value = "";
				return false;
			}
		}
		
	</script>
	
</head>
<body>
	
	
	<div id="wrap">
		<br> <b><font size="4" color="gray">���̵� �ߺ�üũ</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">

			<form id="checkForm" name="checkform" action="idCheck.so" method="get" name="frm" onsubmit="return signUp_Check()">
				<input type="text" name="userid" id="userid" value= "${userid }" maxlength="5" >
				<input type="submit" value="�ߺ�Ȯ��">
			</form>



			<div id="msg"></div>

			<br> <input id="cancelBtn" type="button" value="���" onclick="window.close()">
			<br> <input id="useBtn" type="button" value="����ϱ�" onclick="sendCheckValue()">
		</div>
	</div>

	<c:if test="${result ==1}">
		<script type="text/javascript">
			document.getElementById("cancelBtn").style.visibility='visible';
			document.getElementById("useBtn").style.visibility='hidden';
			document.getElementById("msg").innerHTML = "�ߺ��� ���̵��Դϴ�.";
			
		</script>
	</c:if>
	<c:if test="${result ==-1}">
		<script type="text/javascript">
			document.getElementById("cancelBtn").style.visibility='hidden';
			document.getElementById("useBtn").style.visibility='visible';
			document.getElementById("msg").innerHTML = "��� ������ ���̵��Դϴ�.";
		</script>
	</c:if>






</body>
</html>