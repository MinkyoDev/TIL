<%@page import="emp.EmpDTO"%>
<%@page import="emp.EmpService"%>
<%@page import="util.DateUtil"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int empid = Integer.parseInt(request.getParameter("employee_id"));
	String fname = request.getParameter("first_name");
	String lname = request.getParameter("last_name");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone_number");
	System.out.println(request.getParameter("hire_date"));
	Date hdate = DateUtil.getSQLDate(request.getParameter("hire_date"));
	String job = request.getParameter("job_id");
	int sal = Integer.parseInt(request.getParameter("salary"));
	double commission = Double.parseDouble(request.getParameter("commission_pct"));
	int mid = Integer.parseInt(request.getParameter("manager_id"));
	int deptid = Integer.parseInt(request.getParameter("department_id"));
	
	EmpService eService = new EmpService();
	EmpDTO emp = new EmpDTO();
	
	emp.setEmployee_id(empid);
	emp.setFirst_name(fname);
	emp.setLast_name(lname);
	emp.setEmail(email);
	emp.setPhone_number(phone);
	emp.setHire_date(hdate);
	emp.setJob_id(job);
	emp.setSalary(sal);
	emp.setCommission_pct(commission);
	emp.setManager_id(mid);
	emp.setDepartment_id(deptid);
	System.out.println(emp);
	eService.empInsert(emp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>