<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reAddCart</title>
<script>
window.onload = function() {
	   if (window.confirm('쇼핑을 계속 하시겠습니까?')) {
		   location.href = './productList';
	   } else {
		   location.href = './getCartlist';
	   }
	};
</script>
</head>
<body>

</body>
</html>