package com.shinhan.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

@WebServlet("/emp/empListBydept")
public class EmpListBydept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptService deptService = new DeptService();
		request.setAttribute("deptlist", deptService.selectAll());
		request.getRequestDispatcher("empListBydept.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		
		EmpService empService = new EmpService();
		List<EmpDTO> emplist = empService.selectByDepartmentID(deptid);
		System.out.println(emplist);
		request.setAttribute("emplist", emplist);
		request.getRequestDispatcher("empByDept2.jsp").forward(request, response);
	}
}
