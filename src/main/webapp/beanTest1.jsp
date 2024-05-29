<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- 빈 객체 생성 : BeanTest beantest = new BeanTest()와 같다. -->
<jsp:useBean id = "beantest" class ="myprj.learn8.BeanTest" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean</title>
</head>
<body>
	<h2>자바빈 사용 예제</h2>
	<h3><%=beantest.getName() %></h3>
</body>
</html>