<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.servletContext.contextPath}/board/boardDetail.do" method="post">
		bno: ${board.bno}
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