package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class removeBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET  삭제 화면으로 전송  | Post : 삭제 처리 
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		
		// GET 삭제 할 것 화면 (removeForm.jsp) 로 보내주기 
		if (req.getMethod().equals("GET")) {
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.getRequestDispatcher("WEB-INF/jsp/removeForm.jsp").forward(req, resp);
			
		}else if (req.getMethod().equals("POST")) {
			// get 방식으로 removeForm 에서 삭제 할 것 입력 받은 사항 삭제 해주기 
			if(svc.removeBoard(Integer.parseInt(bno))){
				// 정상적으로 수정 되면 -> 목록 화면 출력 
				resp.sendRedirect("boardList.do");
			}else {
				req.setAttribute("msg", "수정할 게시글이 없습니다.");
				req.getRequestDispatcher("WEB-INF/jsp/removeForm.jsp").forward(req, resp);
			}
			
			
		}

	}

}
