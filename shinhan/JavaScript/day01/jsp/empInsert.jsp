<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>신규직원 등록</h1>
	<form action="empDBInsert.jsp">
		<fieldset>
			<legend>필수항목</legend>
			<label>employee_id</label>
			<input type="number" name="employee_id"><br>
			<label>last_name</label>
			<input type="text" name="last_name"><br>
			<label>email</label>
			<input type="email" name="email"><br>
			<label>hire_date</label>
			<input type="date" name="hire_date"><br>
			<label>job_id</label>
			<input type="text" name="job_id" value="IT_PROG"><br>
		</fieldset>
		<fieldset>
			<legend>선택입력</legend>
			<label>first_name</label>
			<input type="text" name="first_name"><br>
			<label>phone_number</label>
			<input type="text" name="phone_number"><br>
			<label>salary</label>
			<input type="text" name="salary" value="0"><br>
			<label>commission_pct</label>
			<input type="text" name="commission_pct" value="0"><br>
			<label>manager_id</label>
			<input type="number" name="manager_id" value="100"><br>
			<label>department_id</label>
			<input type="number" name="department_id" value="100"><br>
		</fieldset>
		<input type="submit" value="입력">
		<input type="reset" value="초기화">
	</form>
</body>
</html>