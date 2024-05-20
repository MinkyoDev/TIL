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

	//@Autowired�� Ÿ���� ������ �ڵ����� injection
	@Autowired
	EmpService eService;
	
	@RequestMapping("/empAll.do")
	public String empAll(Model model) {
		List<EmpDTO> emplist = eService.selectAll();
		model.addAttribute("emplist", emplist);
		
		// view�̸��� return
		// ViewResolver�� ���λ� + view�̸� + ���̻�
		// view�� forward�ȴ�.
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
