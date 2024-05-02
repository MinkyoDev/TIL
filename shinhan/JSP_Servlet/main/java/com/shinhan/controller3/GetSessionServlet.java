package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/getSession")
public class GetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String userid = (String) session.getAttribute("userid");
		String userpw = (String) session.getAttribute("userpw");
		System.out.println("세선 read - id: " + userid);
		System.out.println("세선 read - pw: " + userpw);

	}

}
