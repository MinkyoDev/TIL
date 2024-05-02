package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.util.DateUtil;

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

		DeptService deptService = new DeptService();
		List<DeptDTO> deptList = deptService.selectAll();
		System.out.println(deptList.size() + "건");
		request.setAttribute("deptlist", deptList);

//		List<HashMap<String, Object>> mlist = empService.selectAllManager();

		// 요청문서에 data 저장
		request.setAttribute("empInfo", emp);

		// send to jsp
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청문서의 내용을 담아서 온다. 자동 encoding 안됨
//		request.setCharacterEncoding("utf-8");
		EmpDTO emp = makeEmp(request);
		EmpService empService = new EmpService();
		String result = String.valueOf(empService.empUpdate(emp)) + "건이 수정됨";
		System.out.println(result);
		request.setAttribute("message", result);

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);

	}

	private EmpDTO makeEmp(HttpServletRequest request) {
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
