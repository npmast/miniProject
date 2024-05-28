<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<%-- taglib 지시어를 통해서 커스텀 태그 선언 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 종합 예제</title>
</head>
<body>
	<h2>JSTL 종합 예제</h2>

	<hr>
	<h3>set, out</h3>					<%-- scope는 변수들을 사용할 수 있는 범위:현재페이지의 자바객체, application, session, request, page --%>
	<c:set var="product1" value="<h2>애플 아이폰</h2>" />		<%-- c:set 특정 scope에 값을 저장 --%>
	<c:set var="product2" value="삼성 갤럭시 노트" />		<%-- 'product1', 'product2'라는 이름으로 문자열 page scope에 저장한다. --%>
	<c:set var="intArray" value="${[1,2,3,4,5]}" />			<%-- EL을 사용하여 intArray 배열에 저장 --%>
	<p>
		product1(jstl): 
		<%-- c:out은 출력을 위한 태그로 대부분은 EL로 대체된다 --%>
		<%-- default는 출력하고자하는 객체(droduct1)가 없을때 출력된다. excpaeXml이 true인경우는 태그를 문자열로 처리한다.기본값을 false--%>
		<c:out value="${product1}" default="Not registerd" escapeXml="true" />
	</p>
	<p>product1(el):${product1}</p>
	<p>intArray[2]: ${intArray[2]}</p>
	<hr>

	<h3>forEach: 배열 출력</h3>
	<ul>
		<c:forEach var="num" varStatus="i" items="${intArray}">		<%-- i는 인덱스로 intArrsy배열의 원소를 하나씩 꺼내서 num에 저장한다. --%>
			<li>${i.index} : ${num}</li>				<%-- 0부터 반복, count를 사용하면 1번부터 시작 --%>
		</c:forEach>
	</ul>
	<hr>
	
	<h3>if</h3>		<%-- c:if태그에 사용할 수 있는 속성은 test, var, scope 이다. test는 비교식을 가진다. --%>
	<c:set var="checkout" value="true" />		<%-- checkout 변수에 true를 저장하고 --%>
	<c:if test="${checkout}">
		<p>주문 제품: ${product2}</p>
	</c:if>
	<c:if test="${!checkout}">
		<p>체크아웃 상태가 아님!!</p>
	</c:if>
	
	<c:if test="${!empty product2}">
		<p>
			<b>${product2} 이미 추가됨!!.</b>
		</p>
	</c:if>
	<hr>

	<h3>choose, when, otherwise</h3>
	<c:choose>									<%-- choose태그는 조건에 따라 분기한다. if~else, switch --%>
		<c:when test="${checkout}">		
			<p>주문 제품: ${product2}</p>
		</c:when>
		<c:otherwise>
			<p>체크아웃 상태가 아님!!</p>
		</c:otherwise>
	</c:choose>
	<hr>
		
	<h3>forTokens</h3>				<%-- 구분자로 문자열을 나눈다. --%>
	<c:forTokens var="city" items="Seoul|Tokyo|New York|Toronto" delims="|" varStatus="i">
		<c:if test="${i.first}">도시 목록 : </c:if>
     	${city} 
     	<c:if test="${!i.last}">,</c:if>
	</c:forTokens>

	<hr>	
</body>
</html>