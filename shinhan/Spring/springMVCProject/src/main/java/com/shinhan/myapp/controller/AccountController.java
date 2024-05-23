package com.shinhan.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.myapp.account.AccountServiceImpl;

@Controller
public class AccountController {
	
	@Autowired
	AccountServiceImpl accService;
	
	@RequestMapping("/account/trans.do")
	@ResponseBody   // 응답의 문자는 response.getWriter().append("문자") 생략되면 jsp페이지로 forward
	public String f1() {
		accService.update();
		return "Account Transaction Test";
	}
}
