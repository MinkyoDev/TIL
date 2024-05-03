<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니 결과</h1>
	<c:forEach items="${cart}" var="menu">
		<p>${menu}</p>
	</c:forEach>
	<form action="orderRemove.go">
		<input type="submit" value="장바구니 비우기">
	</form>
</body>
</html>