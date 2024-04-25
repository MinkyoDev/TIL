<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 상세보기</h1>
	<%-- 
	<p>부서번호: ${deptInfo.department_id}</p>
	<p>${deptInfo.name}</p>
	--%>
	<p>${deptInfo}</p>
	<p>부서번호: ${deptInfo.DEPARTMENT_ID}</p>
	<p>부서이름: ${deptInfo.DEPARTMENT_NAME}</p>
</body>
</html>