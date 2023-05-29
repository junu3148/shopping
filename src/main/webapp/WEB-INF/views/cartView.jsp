<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.button-link {
	display: inline-block;
	padding: 4px 8px;
	background-color: lightgray;
	color: black;
	text-decoration: none;
	border-radius: 4px;
	border: solid 1px black;
	cursor: pointer;
	font-size: 13px;
}

.button-link:hover {
	background-color: gray;
}

#table {
	border: 1px black;
}
/* 입력란의 스타일 조정 */
.h {
	border: none; /* 테두리 제거 */
	background-color: transparent; /* 배경색 제거 */
	outline: none; /* 포커스 표시 제거 */
	font-size: 15px;
	text-align: center;
}
</style>
</head>
<body>

	<div align="center" style="margin: 0 auto; width: 90%;">
		<h1>**장바구니**</h1>
		<hr>
		<bR>
		<div>
			<table style="width: 100%; border: 1px solid black;">
				<tr style="border: 1px solid black; background-color: lightgray;">
					<td style="width: 20%; text-align: center;">제품코드</td>
					<td style="width: 30%; text-align: center;">제품명</td>
					<td style="width: 10%; text-align: center;">개수</td>
					<td style="width: 25%; text-align: center;">가격</td>
					<td style="width: 15%; text-align: center;"></td>
				</tr>
				<c:forEach items="${cartList}" var="cart">
					<tr style="border: 1px solid black;">
						<form action="deleteCart">
							<input type="hidden" name="customerId" value="${user.customerId}">
							<td style="width: 20%; text-align: center;"><input class="h"
								type="text" name="productId" value="${cart.productId}" readonly /></td>
							<td style="width: 30%; text-align: center;">${cart.productName}</td>
							<td style="width: 10%; text-align: center;"><input class="h"
								type="text" name="sellEa" value="${cart.sellEa}" readonly /></td>
							<td style="width: 25%; text-align: center;"><fmt:formatNumber
									value="${cart.price}" pattern="#,##0원" /></td>
							<td style="width: 15%; text-align: center;"><a
								href="deleteCart?customerId=${user.customerId}&productId=${cart.productId}&sellEa=${cart.sellEa}"
								class="button-link">삭제</a> <!-- 	<inputtype="submit" value="삭제"> -->
							</td>
						</form>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">&nbsp;</td>
				</tr>
			</table>
			<table align="right">
				<tr>
					<td colspan="5"> 총 금액 : <fmt:formatNumber
							value="${total}" pattern="#,##0원" /></td>
				</tr>
				<tr>
					<form action="deleteCartAll">
						<td align="right"><input type="hidden" name="customerId"
							value="${user.customerId}"><input type="submit"
							value="장바구니비우기"></td>
					</form>
					<form action="./productList">
						<td align="center"><input type="submit" value="상품리스트"></td>
					</form>

					<td align="center"><a
						href="./productPayment?productName=${cart.productName}
					&sellEa=${cart.sellEa}&total=${total}"
						class="button-link">상품결제</a></td>

				</tr>
			</table>
		</div>
	</div>

</body>
</html>