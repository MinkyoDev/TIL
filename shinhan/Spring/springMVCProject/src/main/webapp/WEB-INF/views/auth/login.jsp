<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<body>
	<div class="container mt-3">
		<h2>${loginResult}</h2>
		<h2>Stacked form</h2>
		<form action="${path}/auth/login.do" method="post">
			<div class="mb-3 mt-3">
				<label for="email">Email:</label> <input type="text"
					class="form-control" id="email" placeholder="Enter email"
					name="email" value="SKING">
			</div>
			<div class="mb-3">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="pswd" value="515.123.4567">
			</div>
			<div class="form-check mb-3">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>