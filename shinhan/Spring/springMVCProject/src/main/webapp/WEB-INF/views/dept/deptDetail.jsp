<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<body>
	<p>deptid: ${session.getAttribute("deptid")}</p>
	<p>name: ${session.name}</p>
	<h1>부서 상세보기</h1>
	<p>${deptInfo.department_id}</p>
	<p>${deptInfo}</p>
</body>
</html>