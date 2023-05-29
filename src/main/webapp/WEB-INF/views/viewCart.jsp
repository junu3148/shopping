<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:if test="${sessionScope.cart eq null }">
    <c:redirect url = "./snackList"/>
    </c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CartList</title>
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
<body>
<div id="confirmed">
<table>
<tr>
<th>상품ID</th>
<th>상품명</th>
<th>수량</th>
<th>구매가격</th>
</tr>
<c:forEach items="${cart}" var="product">
<tr>
<td width="100">${product.productId}</td>
<td width="250">${product.productName}</td>
<td width="100">${product.productEA}</td>
<td width="150">${product.price*product.productEA}원</td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>