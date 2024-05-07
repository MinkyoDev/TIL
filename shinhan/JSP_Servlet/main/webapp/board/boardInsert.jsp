<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="${pageContext.request.servletContext.contextPath}/board/boardInsert.do" method="post">
		title: <input type="text" name="title" value="${board.title}"><br>
		content: <input type="text" name="content" value="${board.content}"><br>
		pic: <input type="text" name="pic" value="${board.pic}"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>