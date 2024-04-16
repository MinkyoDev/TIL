<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>확인</h1>
	<p><%=request.getParameter("input1")%></p>
	<p><%=request.getParameter("input2")%></p>
	<p><%=request.getParameter("input3")%></p>
	<p><%=request.getParameter("input4")%></p>
	<p><%=request.getParameter("input5")%></p>
	<p><%=request.getParameter("input6")%></p>
	<p><%=request.getParameter("input7")%></p>
	<p><%=request.getParameter("gender")%></p>
	<p><%=request.getParameter("major")%></p>
	<ul>
		<%
		String[] arr = request.getParameterValues("subject");
		if (arr != null) {
			for (String sub : arr) {
				// out은 HTML문서의 Body를 의미하는 JSP가 내장하는 객체
				out.print("<li>" + sub + "</li>");
			}
		}
		%>
	</ul>
	<p><%=request.getParameter("input8")%></p>
	<p><%=request.getParameter("input9")%></p>

	<p><%=request.getParameter("input10")%></p>
	<p><%=request.getParameter("input11")%></p>
	<p><%=request.getParameter("input12")%></p>
</body>
</html>