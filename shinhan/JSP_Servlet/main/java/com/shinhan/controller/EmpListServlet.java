package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

@WebServlet("/emp/empList")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpService empService = new EmpService();
		HttpSession session = request.getSession();
		EmpDTO emp = (EmpDTO) session.getAttribute("loginEmp");

		if (emp == null) {
			// 로그인되어있지 않으면 로그인 창으로 보냄
			response.sendRedirect("../auth/login.do");
			return;
		}

		List<EmpDTO> empList = empService.selectAll();
		request.setAttribute("emplist", empList); // 요청문서에 추가로 저장

		// Dispatcher : 위임. servlet이 jsp로
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);

	}

}
