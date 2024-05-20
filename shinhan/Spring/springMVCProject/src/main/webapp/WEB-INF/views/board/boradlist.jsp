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
	<a href="${path}/board/boardinsert.do">게시글 등록</a>
	<h1>Board 목록</h1>
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>pic</th>
			<th>작성일</th>
			<th></th>
		</tr>
		<c:forEach var="board" items="${blist}">
			<tr>
				<td><a href="${path}/board/boardDetail.do?bno=${board.bno}">${board.bno}</a></td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td>${board.pic}</td>
				<td>${board.create_date}</td>
				<td><button onclick="location.href='${path}/board/boardDelete.do?bno=${board.bno}'">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>