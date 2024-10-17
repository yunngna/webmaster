package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// board.do -> 상세조회 (bno) -> 조회-> 결과를 board.jsp에서 출력 
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
//		svc.searchBoard(Integer.parseInt(bno)); //  문자인 bno 을 정수로 변환 (searchBoard 는 인트 값만 받음)
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));
		
		req.setAttribute("boardvo", board);
		
		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);

	}

}
