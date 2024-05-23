package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shinhan.myapp.emp.EmpDTO;
import com.shinhan.myapp.emp.EmpService;

@Controller
public class LoginController {

	@Autowired
	EmpService empService;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/auth/login.do")
	public void loginDisplay() {
		logger.debug("login.do��û(debug)");
		logger.info("login.do��û(info)");
		logger.warn("login.do��û(warn)");
		logger.error("login.do��û(error)");
	}

	@PostMapping("/auth/login.do")
	public String loginCheck(String email, String pswd, HttpSession session, HttpServletRequest request) {
		System.out.println("email: " + email);
		System.out.println("pswd: " + pswd);
		EmpDTO emp = empService.loginCheck(email, pswd);
		if (emp.getEmployee_id() == -1) {
			session.setAttribute("loginResult", "�������� ����");
			return "redirect:login.do";
		} else if (emp.getEmployee_id() == -2) {
			session.setAttribute("loginResult", "�������� ����");
			return "redirect:login.do";
		} else {
			session.setAttribute("loginResult", "�α��� ����");
			session.setAttribute("emp", emp);

			String lastRequest = (String) session.getAttribute("lastRequest");
			System.out.println("lastRequest: " + lastRequest.substring(6));
//			if (lastRequest!=null) {
//				return "redirect:../dept/deptList.do";				
//			}
			return "redirect:.." + lastRequest.substring(6);
		}
	}

	@GetMapping("/auth/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}
}
