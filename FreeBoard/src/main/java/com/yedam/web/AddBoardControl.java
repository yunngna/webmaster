package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// title, content, writer 3개 파라미터를 db에 넣기 (등록) -> 등록 성공시 목록으로 출력( 목록 보여주기)
		
		req.setCharacterEncoding("utf-8"); // jsp 에서 받은 정보에 한글이 포함 되어 있으면 캐릭터 변환 넣어 줘야 함
		
		
		// 사진 저장 경로 지정 
		String savePath = req.getServletContext().getRealPath("images");
		
		// 파일 최대 크기 지정
		int maxSize = 1024 * 1025 * 5;
		
		// (사진 전달) Multipart요청에 대한 처리로 변경( 파일 업로드 ; 바이트 전달)
		MultipartRequest mr = new MultipartRequest(//
				req  // 1. 요청 정보
				,savePath // 2. 저장 경로
				,maxSize //3. 파일 업로드 최대 크기 지정
				,"utf-8" //4. 파일 이름에 대한 encoding 방식 
				,new DefaultFileRenamePolicy() //5. 동일 파일 있는 경우 바꿔 주는 것(rename정책)
				);
		
//		 boardForm.jsp 에서 받은 정보 해당 객체에 저장 
//		 key = value& key= value 형식으로 text 처리 (전달)
		// multipart로 이제 전달 되는 형식이 바뀌기 때문에  req-> mr로 변경 
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setImg(img);
		
		
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
