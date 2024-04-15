<%@page import="emp.EmpService"%>
<%@page import="emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmpService eService = new EmpService();
	String empid = request.getParameter("empid");
	EmpDTO emp = null;
	int i_empid = 0;
	if (empid != null) {
		i_empid = Integer.parseInt(empid);
		emp = eService.selectByID(i_empid);
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자정보 상세보기</h1>
	<p>직원번호: <%=emp.getEmployee_id() %></p>
	<p>이름: <%=emp.getFirst_name() %></p>
	<p>성: <%=emp.getLast_name() %></p>
	<p>email: <%=emp.getEmail() %></p>
	<p>부서id: <%=emp.getDepartment_id() %></p>
	<p>직업id: <%=emp.getJob_id() %></p>
	<p>급여: <%=emp.getSalary() %></p>
	<p>입사날짜: <%=emp.getHire_date() %></p>
</body>
</html>