<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div align=center>
		<h1>로그인</h1>
		<hr>
		<form action="./login" method="post" scorpe>
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
					<td colspan="2" align="center"><input type="submit"
						value="로그인"> <input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>