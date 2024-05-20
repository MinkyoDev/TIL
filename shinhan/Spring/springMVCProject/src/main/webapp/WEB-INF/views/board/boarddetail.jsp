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
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
	<form action="${path}/board/boardDetail.do" method="post">
		bno: <input type="hidden" name="bno" value="${board.bno}"><br>
		writer: <input type="text" name="writer" value="${board.writer}" readonly="readonly"><br>
		title: <input type="text" name="title" value="${board.title}"><br>
		content: <input type="text" name="content" value="${board.content}"><br>
		pic: <input type="text" name="pic" value="${board.pic}"><br>
		작성일: <input type="date" name="create_date" value="${board.create_date}" readonly="readonly"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>