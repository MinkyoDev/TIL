package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;

@WebFilter("*.do")
public class LoginCheckFilter extends HttpFilter implements Filter {

	public LoginCheckFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 로그인하지 않으면 업무로직 못하도록
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		if (!req.getRequestURI().endsWith("login.do")) {
			session.setAttribute("lastRequest", req.getRequestURI());
			EmpDTO emp = (EmpDTO) session.getAttribute("loginEmp");
			if (emp == null) {
				// 로그인되어있지 않으면 로그인 창으로 보냄
				res.sendRedirect("../auth/login.do");
				return;
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
