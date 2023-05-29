
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userlist.jsp</title>
<style>
table, tr, th, td {
	border: 1px solid black;
}

td {
	text-align: center;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body bgclolr="#ffffff">
	<div id="confirmed" align="center">
		<h2>회원 리스트</h2>
		<hr>
		<table>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>권한타입</th>
			</tr>
			<c:forEach items="${custmerList}" var="user" begin="0" step="1" end="10"
				varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td width="150">${user.customerId}</td>
					<td width="200">${user.customerName}</td>
					<td width="200">${user.codeType}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>