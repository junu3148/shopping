<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원정보수정/탈퇴</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#update").click(function(){	
		alert("업데이트");
		$("form").attr("action", "./update");
		$("form").submit();
		
	});
	$("#delete").click(function(){
		if (window.confirm('정말 삭제하시겠습니까?')){
		$("form").attr("action","./delete");
		$("form").submit();	 
		}
	});
});
</script>
</head>
<body>
	<h2 align="center">회원 정보 보기&amp;수정</h2>
	<HR>
	<form method="post" action="modify" name="form1">
		<table width="500" border="1" align="center" cellspacing="0" cellpadding="5">
 
    <tr> 
    <td colspan="2" align="center">회원 정보</td>
    </tr>
  <tr> 
      <td>아이디</td>
      <td><input type="text" name="customerId" size=10 value="${user.customerId}" ></td>
  </tr>
  <tr> 
      <td>비밀번호</td>
      <td><input type="password" name="customerPassword" size=10 value="${user.customerPassword}"></td>
  </tr>
   <tr> 
      <td>이름</td>
      <td><input type="text" name="customerName" size=10 value="${user.customerName}"></td>
  </tr>
  <tr> 
      <td>주민번호/사업자등록번호</td>
      <td><input type="text" name="customerNumbers" size=30 value="${user.customerNumbers}"></td>
  </tr>
   <tr> 
   <tr> 
    <td colspan="2" align="center">
    	<button id="update">회원정보수정</button>&nbsp;&nbsp;
    	<button id="delete">회원탈퇴</button></td>
  </tr>
</table>
	</form>
</body>
</html>