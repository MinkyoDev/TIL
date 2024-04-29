<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
	$(function(){
		$("form").on("submit", call);
	});
	function call() {
		var salary = $("#salary").val();
		alert(salary);
	}
</script>

</head>
<body>

	<div class="container mt-3">
		<h2>신규직원 등록</h2>
		<form action="empInsert.do" method="post">
			<div class="mb-3 mt-3">
				<label for="empid">empid:</label> <input type="number"
					class="form-control" id="empid" placeholder="Enter empid"
					name="empid" value=10>
			</div>
			<div class="mb-3 mt-3">
				<label for="fname">fname:</label> <input type="text"
					class="form-control" id="fname" placeholder="Enter fname"
					name="fname" value="ffff">
			</div>
			<div class="mb-3 mt-3">
				<label for="lname">lname:</label> <input type="text"
					class="form-control" id="lname" placeholder="Enter lname"
					name="lname" value="llll">
			</div>
			<div class="mb-3 mt-3">
				<label for="email">email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email" value="aaaa@aaa">
			</div>
			<div class="mb-3 mt-3">
				<label for="phone_number">phone_number:</label> <input type="text"
					class="form-control" id="phone_number"
					placeholder="Enter phone_number" name="phone_number"
					value="000.0000">
			</div>
			<div class="mb-3 mt-3">
				<label for="jid">jid:</label> <input type="text"
					class="form-control" id="jid" placeholder="Enter jid" name="jid"
					value="IT_PROG">
			</div>
			<div class="mb-3 mt-3">
				<label for="hdate">hdate:</label> <input type="date"
					class="form-control" id="hdate" placeholder="Enter hdate"
					name="hdate" value="2024-04-29">
			</div>
			<div class="mb-3 mt-3">
				<label for="magid">magid:</label> <input type="number"
					class="form-control" id="magid" placeholder="Enter magid"
					name="magid" value="100">
			</div>
			<div class="mb-3 mt-3">
				<label for="deptid">deptid:</label> <input type="number"
					class="form-control" id="deptid" placeholder="Enter deptid"
					name="deptid" value="10">
			</div>
			<div class="mb-3 mt-3">
				<label for="commition">commition:</label> <input type="text"
					class="form-control" id="commition" placeholder="Enter commition"
					name="commition" value="0">
			</div>
			<div class="mb-3 mt-3">
				<label for="salary">salary:</label> <input type="number"
					class="form-control" id="salary" placeholder="Enter salary"
					name="salary" value="1000">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>
