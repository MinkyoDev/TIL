package com.shinhan.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.board.dto.BoardDTO;
import com.shinhan.board.model.BoardService;

@WebServlet("/board/boardDetail.do")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		request.setAttribute("board", new BoardService().selectById(bno));
		request.getRequestDispatcher("boarddetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pic = request.getParameter("pic");
		BoardDTO board = new BoardDTO(bno, title, content, null, pic, null);
		int result = new BoardService().updateBoard(board);
		System.out.println(result+"건 수정");
		
		response.sendRedirect("selectAll.do");
	}
}
