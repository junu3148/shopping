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
.right-align {
	float: right;
}

#table {
	border: 1px black;
}
/* 입력란의 스타일 조정 */
#productId {
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
		<h1>**상품 리스트**</h1>
		<hr>
		<a href="./main" class="right-align">메인페이지<a>
				<table id="table">
					<form action="./search">
						<tr>
							<td><select name="searchOption">
									<option>--선택--</option>
									<option value="productName">제품명</option>
									<option value="productId">제품코드</option>
							</select></td>
							<td>: <input type="text" name="keyword" />
							</td>
							<td><button type="submit" value="검색" />검색&nbsp;</td>

						</tr>
				</table>
				</form> <br>
				<form action="/Shoppingmall/searchPrice" method="GET">
					<table style="margin: 0 auto; width: 90%;">
						<tr align="center">
							<!--
                    <td>가격대 검색 : <input type ="number">원 ~ <input type="number">원</td>
                    <td><button type = "submit">조회</button></td>
                    -->
							<td><input type="range" min="10000" max="100000" value="0"
								step="1000" onchange="updateMinRange(this.value)"
								style="width: 20%"> <input type="number" min="10000"
								value="0" max="100000" step="1" id="minRangeInput" step="1000"
								name="minPrice" onchange="updateMinRange(this.value)"> 원
								~ <input type="range" min="10000" max="3000000" step="1000"
								value="0" onchange="updateMaxRange(this.value)"
								style="width: 20%"> <input type="number" min="10000"
								max="3000000" step="1" id="maxRangeInput" name="maxPrice"
								style="width: 10%" onchange="updateMaxRange(this.value)">원
								<button type="submit">검색</button></td>
						</tr>
					</table>
				</form> <bR>
				<div>
					<table style="width: 100%; border: 1px solid black;">
						<tr style="border: 1px solid black; background-color: lightgray;">
							<td style="width: 20%; text-align: center;">제품코드</td>
							<td style="width: 30%; text-align: center;">제품명</td>
							<td style="width: 10%; text-align: center;">개수</td>
							<td style="width: 25%; text-align: center;">가격</td>
							<td style="width: 15%; text-align: center;">장바구니담기</td>
						</tr>
						<c:forEach items="${productList}" var="product">
							<form action="./addCart">
								<tr stype="border: 1px solid black;">
									<input type="hidden" name="customerId"
										value="${user.customerId}">
									<td style="width: 20%; text-align: center;"><input
										id="productId" type="text" name="productId"
										value="${product.productId}" readonly /></td>
									<td style="width: 30%; text-align: center;">${product.productName}</td>
									<td style="width: 10%; text-align: center;"><input
										type="number" name="sellEa" min="1" max="${product.productEA}" /></td>
									<td style="width: 25%; text-align: center;"><fmt:formatNumber
											value="${product.price}" pattern="#,##0원" /></td>
									<td style="width: 15%; text-align: center;"><input
										name="c" type="submit" value="장바구니담기"></td>
								</tr>
							</form>
						</c:forEach>
					</table>
				</div>
	</div>
	<script>
		function updateMinRange(value) {
			document.getElementById("minRangeInput").value = value;
			// 추가로 처리할 로직을 여기에 작성하세요.
		}
		function updateMaxRange(value) {
			document.getElementById("maxRangeInput").value = value;
			// 추가로 처리할 로직을 여기에 작성하세요.
		}
	</script>

</body>
</html>