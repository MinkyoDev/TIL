package com.shinhan.myapp.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.myapp.dept.DeptService;
import com.shinhan.myapp.emp.EmpDTO;
import com.shinhan.myapp.emp.EmpService;
import com.shinhan.myapp.job.JobService;
import com.shinhan.myapp.util.DateUtil;

@Controller
@RequestMapping("/emp")
public class EmpController {

	// @Autowired는 타입이 같으면 자동으로 injection
	@Autowired
	EmpService eService;

	@Autowired
	DeptService dService;

	@Autowired
	JobService jService;

	@RequestMapping("/empAll2.do")
	public String empAll2(Model model, Integer deptSelect, String jobSelect, String hdate, int salary) {
		Date startDate = DateUtil.getSQLDate(hdate);
		List<EmpDTO> emplist2 = eService.selectByCondition(deptSelect, jobSelect, startDate, salary);
		
		model.addAttribute("emplist",emplist2);
		model.addAttribute("deptlist",dService.selectAll());
		model.addAttribute("joblist",jService.selectAllJob());
		
		return "emp/emplist";
	}
	
	@RequestMapping("/empAll.do")
	public String empAll(Model model, Integer deptid, String jobid) {
		List<EmpDTO> emplist = null;
		if (deptid == null && jobid == null) {
			emplist = eService.selectAll();
		} else {
			if (deptid != null && jobid == null) {
				if (deptid == 0) {
					emplist = eService.selectAll();
				} else {
					emplist = eService.selectByDepartmentID(deptid);
				}
			} else {
				if (jobid.equals("all")) {
					emplist = eService.selectAll();
				} else {
					emplist = eService.selectByJob(jobid);
				}
			}
		}
		System.out.println(emplist);
		
		model.addAttribute("emplist", emplist);
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("joblist", jService.selectAllJob());
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
