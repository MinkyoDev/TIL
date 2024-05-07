<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function () {
		$("#btnJSON").on("click", jsonCall);
		$("#btnJSON2").on("click", jsonCall2);
	});
	
	function jsonCall2() {
		var output = "<ul>"
		$.ajax({
			url: "../json",
			type: "get",
			success: function(response) {
				console.log(response);
				var obj = JSON.parse(response);
				var boardlist = obj.boardlist;
				$.each(boardlist, function(index, item){
					console.log(item);
					output += "<li>" + item.title + "</li>"
				});
				output += "</ul>";
				$("#here").html(output);
			},
			error: function(error) {
				alert(error);
			}
		});
	}
	
	function jsonCall() {
		var board = {bno: 100, title: "커피", content:"맛있음", writer:"몰라"};
		var str = JSON.stringify(board);
		console.log(board);
		console.log(str);
		$.ajax({
			url: "../json",
			type: "post",
			data: {"jsonInfo": str},
			success: function(response) {
				console.log(response);
			},
			error: function(error) {
				alert(error);
			}
		});
	}
</script>
</head>
<body>
	<c:set var="path" value="${pageContext.request.servletContext.contextPath}/board"/>
	<a href="${path}/boardInsert.do">게시판 등록</a>
	<button id="btnJSON">JSON요청</button>
	<button id="btnJSON2">JSON답변</button>
	<div id="here">여기</div>
	<h1>Board 목록</h1>
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>pic</th>
			<th>작성일</th>
			<th></th>
		</tr>
		<c:forEach var="board" items="${blist}">
		<tr>
			<td><a href="${path}/boardDetail.do?bno=${board.bno}">${board.bno}</a></td>
			<td>${board.title}</td>
			<td>${board.content}</td>
			<td>${board.writer}</td>
			<td>${board.pic}</td>
			<td>${board.create_date}</td>
			<td><button onclick="location.herf='${path}/boardDelete.do?bno=${board.bno}'">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
	${blist}
</body>
</html>