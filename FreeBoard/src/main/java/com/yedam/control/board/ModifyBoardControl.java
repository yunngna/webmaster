package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET : 수정 화면 (화면 받아오기) | POST : 수정처리
		
		req.setCharacterEncoding("utf-8");
		// 수정을 할 것의 parameter 받아오기 (문자열) 
		String bno = req.getParameter("bno");
		String page =req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
 		
		BoardService svc = new BoardServiceImpl();
		
		// GET 수정할 것을 화면 (modifyForm.jsp) 로 보내주기 
		if(req.getMethod().equals("GET")) {
		BoardVO board = svc.searchBoard(Integer.parseInt(bno)); // 문자열 -> 정수로 변환 해서 
		
		req.setAttribute("boardvo", board);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
		
		} else if (req.getMethod().equals("POST")) {
			// get 방식으로 modifyForm.jsp에서 수정으로 입력 된 사항 업데이트 해주기 
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			
			if(svc.modifyBoard(board)) {
				// 정상적으로 수정 되면 -> 목록 화면 출력 (페이지번호를 받아서 해당 페이지 화면으로 출력)
				resp.sendRedirect("boardList.do?page=" + page + "&searchCondition=" + sc + "&keyword=" + kw );
			}else {
				// 문제가 발생하면 -> 수정화면 출력 
				board = svc.searchBoard(Integer.parseInt(bno)); // 문자열 -> 정수로 변환 해서 
				
				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "수정할 게시글이 없습니다.");
				req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
			}
					
			
		}

	}

}
