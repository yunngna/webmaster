package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// title, content, writer 3개 파라미터를 db에 넣기 (등록) -> 등록 성공시 목록으로 출력( 목록 보여주기)
		req.setCharacterEncoding("utf-8"); // jsp 에서 받은 정보에 한글이 포함 되어 있으면 캐릭터 변환 넣어 줘야 함
		
		// boardForm.jsp 에서 받은 정보 해당 객체에 저장 
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardService svc = new BoardServiceImpl();
		try {
			// 정상 등록이 되면 -> 글목록으로 이동 
			svc.registerBoard(board);
			resp.sendRedirect("boardList.do");
		}catch(Exception e){
			// 예외 처리 (비정상) 가 되면 -> 글작성.jsp (=글등록 화면 )으로 이동 
			req.setAttribute("msg","등록하는중 오류가 발생했습니다.");
//			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp")//
				.forward(req, resp);
		}
		
		
	}

}
