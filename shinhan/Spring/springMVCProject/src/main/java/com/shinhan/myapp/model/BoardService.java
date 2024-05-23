package com.shinhan.myapp.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("bService2")  // @Component + Service
public class BoardService {

//	BoardDAO boardDAO = new BoardDAO();
	
	@Autowired
	@Qualifier("bDAO")
	BoardDAO boardDAO;

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
