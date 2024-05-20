package com.shinhan.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shinhan.myapp.model.BoardDTO;
import com.shinhan.myapp.model.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService bService;

	@RequestMapping("/selectAll.do")
	public String test1(Model model) {
		System.out.println("/board/selectAll.do 요청");
		List<BoardDTO> blist = bService.selectAll();
		model.addAttribute("blist", blist);
		return "board/boradlist";
	}

	@RequestMapping("/boardinsert.do")
	public void boardInsert() {

	}
	
	@RequestMapping(value = "/boardInsert.do", method = RequestMethod.POST)
//	public String boardInsert2(String title, String content, String pic) {
	public String boardInsert2(BoardDTO board) {
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		System.out.println(board.getPic());
		
		bService.insertBoard(board);
		
		// forward 요청 위임
		// redirect 재요청
		return "redirect:selectAll.do";
	}
	
	@RequestMapping("/boardDetail.do")
	public String detail(int bno, Model model) {
		model.addAttribute("board", bService.selectById(bno));
		
		return "board/boarddetail";
	}
	
	@PostMapping("/boardDetail.do")
	public String detailPost(BoardDTO board) {
		bService.updateBoard(board);
		
		return "redirect:selectAll.do";
	}
	
//	@RequestMapping(value = "/boardDelete.do", method = RequestMethod.DELETE)
//	@DeleteMapping("/boardDelete.do")
	@RequestMapping(value = "/boardDelete.do", method = RequestMethod.GET)
	public String delete(int bno) {
		System.out.println("delete");
		bService.deleteBoard(bno);
		return "redirect:selectAll.do";
	}
}
