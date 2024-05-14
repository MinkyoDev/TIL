package com.shinhan.myapp.section04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository  // @Component(객체 Bean) + DAO
public class BoardDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	public List<BoardDTO> selectAll() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		conn = DBUtil.dbConnection();
		String sql = "select * from TBL_BOARD";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO board = makeBoard(rs);
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return boardList;
	}
	
	public BoardDTO selectById(int bno) {
		BoardDTO board = null;
		conn = DBUtil.dbConnection();
		String sql = "select * from TBL_BOARD where bno = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			while(rs.next()) {
				board = makeBoard(rs); 
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}		
		return board;
	}
	
	public int insertBoard(BoardDTO board) {
		conn = DBUtil.dbConnection();
		String sql = "insert into TBL_BOARD(bno, title, content, writer, pic) values(seq_board_bno.nextval, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriter());
			pst.setString(4, board.getPic());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return result;
	}
	
	public int updateBoard(BoardDTO board) {
		conn = DBUtil.dbConnection();
		String sql = "update TBL_BOARD set title=?, content=?, writer=?, pic=? where bno=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriter());
			pst.setString(4, board.getPic());
			pst.setInt(5, board.getBno());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return result;
	}
	
	public int deleteBoard(int bno) {
		conn = DBUtil.dbConnection();
		String sql = "delete from TBL_BOARD where bno=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bno);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return result;
	}

	private BoardDTO makeBoard(ResultSet rs2) throws SQLException {
		BoardDTO board = new BoardDTO();
		board.setBno(rs.getInt("bno"));
		board.setWriter(rs.getString("writer"));
		board.setTitle(rs.getString("title"));
		board.setContent(rs.getString("content"));
		board.setPic(rs.getString("pic"));
		board.setCreate_date(rs.getDate("create_date"));
		return board;
	}
}
