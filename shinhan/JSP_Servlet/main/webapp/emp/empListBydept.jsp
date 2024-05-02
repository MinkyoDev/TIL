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
    $(function(){
        
    })
    function call(department_id){
        $.ajax({
            url: "empListBydept",
            type: "post",
            data: {"deptid":department_id},

            success: function(response){
                console.log(response);
            }
        })
    }
</script>
<style>
    #deptlist {
        float: left;
        width: 30%;
    }
    #emplist {
        float: left;
        width: 70%;
    }
</style>
</head>
<body>
	<h1>Binding 연습</h1>
	<p>1.ServletContext: ${appData}</p>
	<p>2.HttpSession: ${sessionData}</p>
	<p>3.HttpServletRequest: ${requestData}</p>
	
    <div id="deptlist">
        <h3>부서목록</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>부서번호</th>
                    <th>부서이름</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${deptlist}" var="dept">
                    <tr>
                        <td><a href="javascript:call(${dept.department_id})">${dept.department_id}</td>
                        <td>${dept.department_name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="emplist">
        dddd
    </div>
</body>
</html>