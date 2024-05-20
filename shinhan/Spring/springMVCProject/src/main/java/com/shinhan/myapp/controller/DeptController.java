package com.shinhan.myapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.myapp.dept.DeptDTO;
import com.shinhan.myapp.dept.DeptService;
import com.shinhan.myapp.emp.EmpService;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	DeptService deptService;

	@Autowired
	EmpService empService;

	@RequestMapping("/deptList.do") 
	public void deptList(Model model, HttpServletRequest request) {

		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		System.out.println(flashMap);
		String result = "";
		if (flashMap != null) {
			System.out.println(flashMap.get("result"));
			result = (String) flashMap.get("result");
		}

		model.addAttribute("result", result);
		model.addAttribute("deptlist", deptService.selectAll());
	}
//	@RequestMapping("/deptInsert.do")
//	public void deptInsertPage(Model model) {
//	}

	@RequestMapping("/deptInsert.do")
	public ModelAndView deptInsertPage(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dept/deptInsert");
		mv.addObject("mlist", empService.selectAll());
		return mv;
	}

	@PostMapping("/deptInsert.do")
	public String deptInsert(DeptDTO dept) {
		int result = deptService.deptInsert(dept);
		if (result == 0) {
			return "dept/deptInsert";
		}

		// redirect:가 없다면 default로 foward. 즉, 요청 주소는 그대로이고 보여지는 페이지만 바뀜
		// redirect:가 있다면 재요청을 의미함. 새로운 요청이므로 주소가 바뀜. request는 전달되지 않음.
		return "redirect:deptList.do";
	}

	@GetMapping("/deptDelete.do")
	public String deptDelete(int deptid, RedirectAttributes redirectAttr) {
		System.out.println(deptid);
		int result = deptService.deptDelete(deptid);
		if (result > 0) {
			redirectAttr.addFlashAttribute("result", "success");
		} else {
			redirectAttr.addFlashAttribute("result", "fail");
		}
		return "redirect:deptList.do";
	}

	@GetMapping("/deptDetail.do")
	public String deptDetail(int deptid, Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("deptInfo", deptService.selectById(deptid));

		System.out.println(request.getRemoteAddr());
		session.setAttribute("deptid", deptid);
		session.setAttribute("name", "min");

		System.out.println(session.getAttribute("deptid"));
		return "dept/deptDetail";
	}
}
