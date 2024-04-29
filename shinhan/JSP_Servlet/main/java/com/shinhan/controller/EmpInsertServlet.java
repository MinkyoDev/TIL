package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.util.DateUtil;

@WebServlet("/emp/empInsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("empInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청문서의 내용을 담아서 온다. 자동 encoding 안됨
		request.setCharacterEncoding("utf-8");
		EmpDTO emp = makeEmp(request);
		EmpService empService = new EmpService();
		String result = String.valueOf(empService.empInsert(emp)) + "건이 입력됨";
		System.out.println(result);
		request.setAttribute("message", result);

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		// 서블릿이 직접 응답을 하는 경우
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.write("<h1>서브릿이 직접 응답을 하는 경우</h1>");
	}

	private EmpDTO makeEmp(HttpServletRequest request) {
		// Enumeration : 한정된 값의 나열을 의미
		Enumeration<String> colnames = request.getParameterNames();
		while (colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}

		EmpDTO emp = new EmpDTO();
		int empid = convertInt(request.getParameter("empid"));
		int magid = convertInt(request.getParameter("magid"));
		int deptid = convertInt(request.getParameter("deptid"));
		int salary = convertInt(request.getParameter("salary"));
		double commition = convertDouble(request.getParameter("commition"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String jid = request.getParameter("jid");
		Date hdate = DateUtil.getSQLDate(request.getParameter("hdate"));

		emp.setEmployee_id(empid);
		emp.setManager_id(magid);
		emp.setDepartment_id(deptid);
		emp.setSalary(salary);
		emp.setCommission_pct(commition);
		emp.setFirst_name(fname);
		emp.setLast_name(lname);
		emp.setEmail(email);
		emp.setPhone_number(phone);
		emp.setJob_id(jid);
		emp.setHire_date(hdate);
		return emp;
	}

	private double convertDouble(String parameter) {
		if (parameter == null)
			return 0;
		return Double.parseDouble(parameter);
	}

	private int convertInt(String parameter) {
		if (parameter == null)
			return 0;
		return Integer.parseInt(parameter);
	}

}
