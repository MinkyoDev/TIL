package com.shinhan.controller3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;


@WebServlet("/auth/loginSuccess")
public class LoginSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmpDTO emp = (EmpDTO) session.getAttribute("loginEmp");

		if (emp == null) {
			// 로그인되어있지 않으면 로그인 창으로 보냄
			response.sendRedirect("../auth/login.do");
			return;
		}
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

}
