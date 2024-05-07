package com.shinhan.board.model;

import java.util.List;

import com.shinhan.board.dto.BoardDTO;

public class BoardService {

	BoardDAO boardDAO = new BoardDAO();

	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}
	
	public BoardDTO selectById(int bno) {
		return boardDAO.selectById(bno);
	}
	
	public int insertBoard(BoardDTO board) {
		return boardDAO.insertBoard(board);
	}
	
	public int updateBoard(BoardDTO board) {
		return boardDAO.updateBoard(board);
	}
	
	public int deleteBoard(int bno) {
		return boardDAO.deleteBoard(bno);
	}

}
