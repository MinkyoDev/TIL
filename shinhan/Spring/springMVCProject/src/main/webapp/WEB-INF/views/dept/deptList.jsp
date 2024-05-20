<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../common/header.jsp"%>
<body>
	<p><a href="${path}/dept/deptInsert.do">신규부서등록</a></p>
	<p>result: ${result}</p>
	<h1>부서목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>이름</th>
				<th>메니저id</th>
				<th>location_id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deptlist}" var="dept">
				<tr>
					<td><a href="${path}/dept/deptDetail.do?deptid=${dept.department_id}">${dept.department_id}</a></td>
					<td>${dept.department_name}</td>
					<td>${dept.manager_id}</td>
					<td>${dept.location_id}</td>
					<td><button
							onclick="location.href='${path}/dept/deptDelete.do?deptid=${dept.department_id}'">삭제</button>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<script>
	/* var message = "${result}"; 
	console.log(message);
	console.log("dfdfdf");
	if (message !=""){
		alter(message);
	} */
	setTimeout(()=>{
		var message = "${result}";
		if (message!=""){
			alert(message);
		}
	})
</script>
</html>
</body>
</html>