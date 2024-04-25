package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;


@WebServlet("/emp/empDetail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("============get============");

		EmpService empService = new EmpService();
		String empid = request.getParameter("empid");
		if (empid == null)
			return;

		int i_empid = Integer.parseInt(empid);
		EmpDTO emp = empService.selectByID(i_empid);
		System.out.println(emp);
		
		// 요청문서에 data 저장
		request.setAttribute("empInfo", emp);
		
		// send to jsp
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

}
