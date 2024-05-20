package com.shinhan.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// ��û�ּ� ����
@Controller
// �������� path�� class level���� ����, ������ method level�� �ۼ��Ѵ�.
@RequestMapping("/sample")
public class SampleComtroller {

	@RequestMapping("hello.do")
	public String test1() {
		return "jsp/hello";
	}

	@RequestMapping("/sample/hello1.do")
	public String test2() {
		return "jsp/hello";
	}

	@RequestMapping(value = { "/hello2.do", "/hello3.do" }, method = RequestMethod.GET)
	public String test3() {
		return "jsp/hello";
	}

	@GetMapping("/hello4.do")
	public String test4(Model data) {
		data.addAttribute("myname", "mm");
		data.addAttribute("myscore", 100);
		return "jsp/hello";
	}

	@GetMapping("/hello5.do")
	public ModelAndView test5() {
//		ModelAndView data = new ModelAndView("jsp/hello");
		ModelAndView data = new ModelAndView();
		data.setViewName("jsp/hello");
		data.addObject("myname", "mm5");
		data.addObject("myscore", 500);
		return data;
	}

	@RequestMapping(value = "/helloGet.do", method = RequestMethod.GET, params = { "email", "password=1234",
			"!address" })
	public String test6(Model model, String email2, @RequestParam("password") String pwd, String phone) {
		System.out.println("=====helloGet=====");
		System.out.println("email2: " + email2);
		System.out.println("pwd: " + pwd);
		System.out.println("phone: " + phone);

		// request�� ���� ������ addAttribute ���ʿ� ����
		model.addAttribute("lunch", "����");
		return "jsp/hello6";
	}

	@RequestMapping(value = "/helloPost.do", method = RequestMethod.POST)
	public void test7(
			@RequestParam("email") String email, 
			@RequestParam(value = "password", required=true) String password, 
			String phone
			) {
		// default => void�� �� ���� �̸��� jsp�� ��
		System.out.println("=====helloPost=====");
		System.out.println("email2: " + email);
		System.out.println("password: " + password);
		System.out.println("phone: " + phone);
	}
}
