package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page; // 3항연산자 | 만약 page가 null이면 page = 1 , 아니면 입력받은 page = page 
		
		// 조건을 넣고 검색해서 해당 값이 포함되는 게시글 출력 위해 boardList.jsp 에서 값 받아오기
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		// 검색 조건 
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		search.setPage(Integer.parseInt(page));
		
		
		// 글목록 보여주기. 조회 후 jsp 전달 
		BoardService svc = new BoardServiceImpl();
//		List<BoardVO>list= svc.boardList();
		List<BoardVO>list= svc.listWithPage(search);
		
		// 데이터의 총 갯수 가져오기 
//		int totalCnt = svc.getTotalCount();
		int totalCnt = svc.getTotalCount(search);
		
		req.setAttribute("boardList", list);
		req.setAttribute("page",new PageDTO(Integer.parseInt(page),totalCnt)); // page는 문자열이니까 정수(int)로 변환 
		
		//리스트에 검색해서 나온 결과가 페이지가 변환되도 연속해서 출력 되게 하기 
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		// 보여줄 jsp 페이지 
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
		

	}

}
