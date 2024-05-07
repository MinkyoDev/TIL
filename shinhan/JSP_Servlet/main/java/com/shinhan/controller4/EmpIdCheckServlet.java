package com.shinhan.controller4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

@WebServlet("/empIdCheck")
public class EmpIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		System.out.println(empid);
		EmpService service = new EmpService();
		EmpDTO emp = service.selectByID(empid);
		String message = "이미 존재하는 아이디입니다.";
		if (emp==null) {
			message = "사용가능한 아이디입니다.";
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(message);
	}

}
