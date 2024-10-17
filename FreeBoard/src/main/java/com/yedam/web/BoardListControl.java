package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page; // 3항연산자 | 만약 page가 null이면 page = 1 , 아니면 입력받은 page = page 
		
		// 글목록 보여주기. 조회 후 jsp 전달 
		BoardService svc = new BoardServiceImpl();
//		List<BoardVO>list= svc.boardList();
		List<BoardVO>list= svc.boardList(Integer.parseInt(page));
		
		req.setAttribute("boardList", list);
		req.setAttribute("page",new PageDTO(Integer.parseInt(page))); // page는 문자열이니까 정수(int)로 변환 
		
		// 보여줄 jsp 페이지 
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
		

	}

}
