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
    <h1>Job list</h1>
    <select name="job_id">
		<c:forEach var="job" items="${joblist}">
            <option>${job}</option>
		</c:forEach>
    </select>
</body>
</html>