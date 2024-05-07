package com.shinhan.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.board.dto.BoardDTO;
import com.shinhan.board.model.BoardService;
import com.shinhan.emp.EmpDTO;

@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("boardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pic = request.getParameter("pic");
		HttpSession session = request.getSession();
		EmpDTO emp = (EmpDTO) session.getAttribute("loginEmp");
		String writer = emp.getFirst_name() + emp.getLast_name();

		BoardDTO board = new BoardDTO(0, title, content, writer, pic, null);
		int result = new BoardService().insertBoard(board);
		System.out.println(result + "건 입력");
		response.sendRedirect("selectAll.do");
	}

}
