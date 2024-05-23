package com.shinhan.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.myapp.dept.DeptDTO;
import com.shinhan.myapp.dept.DeptService;

@RestController // @Controller + ResponseBody
@RequestMapping("/dept/api/*")
public class DeptRestController {

	@Autowired
	DeptService dService;

	Logger logger = LoggerFactory.getLogger(DeptRestController.class);

	@GetMapping("/test1")
	public String test1() {
		return "ABC";
	}

	// 가져오기: consumes
	// 내보내기: produces 설정
	@GetMapping(value = "/test2", produces = "text/plain;charset=utf-8")
	public String test2() {
		return "Restful 방식 연습";
	}

	@GetMapping(value = "/detail/{deptid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DeptDTO selectById(@PathVariable("deptid") int deptid) {
		logger.info("들어온 deptid: " + deptid);
		System.out.println(deptid);
		DeptDTO dept = dService.selectById(deptid);
		System.out.println(dept);
		return dept;
	}

	@GetMapping(value = "/deptAll", produces = "application/json")
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = dService.selectAll();
		return deptlist;
	}

	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insert(@RequestBody DeptDTO dept) {
		logger.info("들어온 dept: " + dept);
		int result = dService.deptInsert(dept);
		return "insert: " + result;
	}

	@PutMapping(value = "/update", produces = "text/plain;charset=utf-8", consumes = "application/json")
	public String update(@RequestBody DeptDTO dept) {
		int result = dService.deptUpdate(dept);
		return "수정건수: " + result;
	}

	@DeleteMapping(value = "/delete/{deptid}")
	public String delete(@PathVariable("deptid") int deptid) {
		int result = dService.deptDelete(deptid);
		return "삭제건수: " + result;
	}
}
