<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

{"emplist":[
<% 
EmpService eservice = new EmpService();
EmpDTO emp = eservice.selectById(100);
for(EmpDTO emp : emplist){
%>
    {
        "no": <%=emp.getEmployee_id%>,
        "name": <%=emp.getFirst_name%>,
        "capital": <%=emp.getEmail%>,
        "region": <%=emp.getSalary%>
    },
<%}%>

]}