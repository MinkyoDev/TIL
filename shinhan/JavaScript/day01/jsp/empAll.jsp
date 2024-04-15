<%@page import="emp.EmpService"%>
<%@page import="emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 직원 정보</h1>
	<a href="empInsert.jsp">신규직원 등록</a>
	<table border="1">
		<caption>직원목록</caption>
		<thead>
			<tr>
				<th>직원번호</th>
				<th>이름</th>
				<th>성</th>
				<th>email</th>
				<th>부서id</th>
				<th>직업id</th>
				<th>급여</th>
				<th>입사날짜</th>
		</thead>
		<tbody>
			<%
			EmpService empService =  new EmpService();
			List<EmpDTO> emplist = empService.selectAll();
			for (EmpDTO emp : emplist) {
			%>
			<tr>
				<td><a href="./empDetail.jsp?empid=<%=emp.getEmployee_id()%>"><%=emp.getEmployee_id()%></a></td>
				<td><%=emp.getFirst_name()%></td>
				<td><%=emp.getLast_name()%></td>
				<td><%=emp.getEmail()%></td>
				<td><%=emp.getDepartment_id()%></td>
				<td><%=emp.getJob_id()%></td>
				<td><%=emp.getSalary()%></td>
				<td><%=emp.getHire_date()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>