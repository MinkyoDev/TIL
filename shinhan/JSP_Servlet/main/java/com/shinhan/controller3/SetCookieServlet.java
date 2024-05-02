package com.shinhan.controller3;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jsp/cookieSet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 여러 페이지로 이동할 때 특정 정보를 유지하기 위해서
	// 쿠키를 만들어서 응답문에 실어서 보냄
	// 브라우저에 저장
	// 재요청시 request에 담아서 감
	// 쿠키를 확인할 수 있음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		Cookie cookie1 = new Cookie("myid", id);
		Cookie cookie2 = new Cookie("mypw", pw);
		Cookie cookie3 = new Cookie("myinfo", URLEncoder.encode("신한금융", "utf-8"));
		cookie1.setMaxAge(24*60*60);  // 하루동안 유효
		cookie2.setMaxAge(3*60);  // 3분동안 유효
		// 유효기간을 설정하지 않으면 브라우저 종료시 사라짐
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		request.getRequestDispatcher("cookie.jsp").forward(request, response);
	}

}
