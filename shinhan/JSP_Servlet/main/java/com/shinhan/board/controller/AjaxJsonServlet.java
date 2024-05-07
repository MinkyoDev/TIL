package com.shinhan.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.shinhan.board.dto.BoardDTO;
import com.shinhan.board.model.BoardService;

@WebServlet("/json")
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardDTO> blist = new BoardService().selectAll();
		
		JSONObject boardlist = new JSONObject();
		JSONArray arr = new JSONArray();
		for(BoardDTO board: blist) {
			JSONObject obj = new JSONObject();
			obj.put("bno", board.getBno());
			obj.put("title", board.getTitle());
			obj.put("content", board.getContent());
			arr.add(obj);
		}
		boardlist.put("boardlist", arr);
		String json = boardlist.toJSONString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsonInfo = request.getParameter("jsonInfo");
		System.out.println(jsonInfo);

		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(jsonInfo);
			System.out.println(jsonObject.get("title"));
			System.out.println(jsonObject.get("title").getClass());
			Long bno_l = (Long)jsonObject.get("bno");
			int bno = bno_l.intValue();
			String title = (String) jsonObject.get("title");
			String content = (String) jsonObject.get("content");
			String writer = (String) jsonObject.get("writer");
			BoardDTO board = new BoardDTO(bno, title, content, writer, null, null);
			System.out.println(board);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
