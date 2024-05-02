package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpService;


@WebServlet("/emp/empDelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		
		// forward는 받은 요청을 다른 페이지에 위임. 주소가 바뀌지 않음.
		request.setAttribute("message", result+"건 삭제됨");
//		request.getRequestDispatcher("result.jsp").forward(request, response);;
		
		// 새로운 요청으로 보내기. 주소창이 바뀜
		// 브라우저로 갔다가 새로운 요청을 한다.
//		response.sendRedirect("empList");
		response.addHeader("Refresh", "3;empList");
		
	}

}
