<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
</head>

<body>
	<div align=center>
		<h1>회원가입</h1>
		<hr>
		<form action="./insert" method="POST">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td width="90">아이디</td>
					<td><input type="text" size="12" name="customerId" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" size="12" name="customerPassword"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" size="30" name="customerName" /></td>
				</tr>
				<tr>
					<td>주민번호</td>
					<td><input type="text" size="30" name="customerNumbers" /></td>
				</tr>
				<tr>
					<td>고객타입</td>
					<td><input type="radio" name="codeType" value="1" checked />개인고객
						<input type="radio" name="codeType" value="2" />기업고객</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="회원가입"> <input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>