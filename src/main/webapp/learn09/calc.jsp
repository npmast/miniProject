<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="calc" class="myprj.learn9.BeanCalc" />
<!-- form으로 부터 전달된 값을 bean 객체의 프로퍼티에 저장한다. 
		form 태그의 name 속성값과 자바빈의 프로퍼티명이 동일해야 한다. -->
<jsp:setProperty name="calc" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h2>계산 결과-JSP</h2>
	<hr>
	결과: <%=calc.calc() %>
</body>
</html>