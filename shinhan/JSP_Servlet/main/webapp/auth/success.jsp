<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${loginEmp.first_name}님 환영합니다.</h1>
	<h1>$현재 접속한 사용자: {loginUser.user_id}</h1>
	<h2>현재 접속자 수: ${loginUser.total_user}</h2>
	<a href="logout.do">로그아웃</a>
</body>
</html>