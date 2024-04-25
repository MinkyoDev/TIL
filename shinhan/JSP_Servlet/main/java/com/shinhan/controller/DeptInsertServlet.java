package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;


@WebServlet("/dept/deptInsert")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("deptInsert.jsp");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("department_id"));
		
		int deptid = Integer.parseInt(request.getParameter("department_id"));
		String deptname = request.getParameter("deparment_name");
		int mid = Integer.parseInt(request.getParameter("manager_id"));
		int loc = Integer.parseInt(request.getParameter("location_id"));
		
		DeptDTO dept = new DeptDTO(deptid, deptname, mid, loc);
		System.out.println(dept);
		DeptService deptService = new DeptService();
		int result = deptService.deptInsert(dept);
		System.out.println(result + "건 입력됨");
		
//		response.getWriter().append("<h1>"+result+"건 입력됨</h1>");
		request.setAttribute("message", result + "건 입력됨");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
