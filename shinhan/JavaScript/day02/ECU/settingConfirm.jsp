<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>생성완료</h1>
	<p>ID: <%=request.getParameter("id")%></p>
	<p>MODELS: <%=request.getParameter("model")%></p>
	<p>STREAM: <%=request.getParameter("stream")%></p>
	<p>CACHE: <%=request.getParameter("cache")%></p>
	<p>MEMORY: <%=request.getParameter("memory")%></p>
</body>
</html>