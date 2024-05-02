<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>get.jsp</h1>
	<h1>request: ${myinfo}</h1>
	<h1>session: ${myinfo2}</h1>
	<h1>ServletContext: ${myinfo3}</h1>
	<h1>initParameter: ${initParam['menu_member']}</h1>
	<h1>initParameter: ${initParam['menu_order']}</h1>
</body>
</html>