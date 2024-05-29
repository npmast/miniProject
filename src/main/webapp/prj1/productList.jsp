<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
<h2>상품 목록</h2>
<hr>
<table border="1">
<tr><th>번호</th><th>상품명</th><th>가격</th></tr>
<c:forEach var="p" varStatus="i" items="${products}">
	<tr>
		<td>${i.count}</td>
		<td><a href="/productctl?action=info&id=${p.id}">${p.name}</a></td>
		<td>${p.price}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>

<!--  19행 상품을 클릭하면 ProductController로 이동하면서 action 파라미터를 사용하여 분리를 한다. -->