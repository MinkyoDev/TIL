package com.shinhan.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.myapp.emp.EmpDTO;
import com.shinhan.myapp.emp.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {

	//@Autowired는 타입이 같으면 자동으로 injection
	@Autowired
	EmpService eService;
	
	@RequestMapping("/empAll.do")
	public String empAll(Model model) {
		List<EmpDTO> emplist = eService.selectAll();
		model.addAttribute("emplist", emplist);
		
		// view이름이 return
		// ViewResolver가 접두사 + view이름 + 접미사
		// view로 forward된다.
		return "emp/emplist";
	}
	
	@RequestMapping("/empDetail.do")
	public void empDetail(int empid, Model model) {
		System.out.println(empid);
		model.addAttribute("empInfo", eService.selectByID(empid));
	}
	
	@RequestMapping("/empInsert.do")
	public void empInsert() {
		
	}
}
