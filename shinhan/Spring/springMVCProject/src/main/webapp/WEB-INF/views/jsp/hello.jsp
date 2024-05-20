<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello!!
	<h1>이름은 ${myname}</h1>
	<h1>점수는 ${myscore}</h1>
	
	<h2>get방식 요청</h2>
	<p>요정주소에 parm이용 : 값 동일, field존제, 값 불일치</p>
	<form action="${pageContext.servletContext.contextPath}/sample/helloGet.do">
		email : <input type="text" name="email" value="qweqwe"><br>
		password : <input type="password" name="password" value="1234"><br>
		phone : <input type="text" name="phone" value="010-1234-1234"><br>
		<input type="submit" value="서버전송(get)"><br>
	</form>
	<hr>
	<h2>post방식 요청</h2>
	<form action="${pageContext.servletContext.contextPath}/sample/helloPost.do" method="post">
		email : <input type="text" name="email" value="qweqwe"><br>
		password : <input type="password" name="password" value="1234"><br>
		phone : <input type="text" name="phone" value="010-1234-1234"><br>
		<input type="submit" value="서버전송(get)"><br>
	</form>
</body>
</html>