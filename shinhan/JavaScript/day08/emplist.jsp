<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
EmpService eservice = new EmpService();
EmpDTO emp = eservice.selectById(100);
for(EmpDTO emp : emplist){
%>

<tr>
    <td><%=emp.getEmployee_id%></td>
    <td><%=emp.getFirst_name%></td>
    <td><%=emp.getEmail%></td>
    <td><%=emp.getSalary%></td>
</tr>
<%}%>