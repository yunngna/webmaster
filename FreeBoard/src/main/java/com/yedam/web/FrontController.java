package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

@WebServlet("*.do") 
// * 전체  ,  .do : .do로 끝나는 것  = .do 로 끝나는 url 경우 모두 호출 됨 -> 서브렛이 너무 많으면 관리가 복잡하기 때문에 사용 
public class FrontController extends HttpServlet {
	// 필드 선언 
	Map <String,Control> map;
	
	
	// 객체 생성 
//	public FrontController () {
//		System.out.println("객체 생성");
//	}
	public FrontController() {
		
		map = new HashMap<>();
	}
	
	// init ()
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init호출");
		
		// url 이 http://localhost/FreeBoard/memberList.do 이면 [Control 인터페이스 상속 된] MemberListControl() 실행 
		// url 이 http://localhost/FreeBoard/memberAdd.do 이면 [Control 인터페이스 상속 된] MemberAddControl() 실행 
		
		// 회원목록 보기 
		map.put("/memberList.do", new MemberListControl()); // control 이라는 인터페이스를 구현하는 클래스 형성 
		
		
		
		
		// 회원등록 1) 등록 화면, 2) 등록 처리 
		map.put("/memberAddForm.do", new MemberAddFormControl());
		
		map.put("/memberAdd.do",  new MemberAddControl()); // control 이라는 인터페이스를 구현하는 클래스 형성 
		
		// 게시판 관련
		map.put("/boardList.do", new BoardListControl()); // 목록 보기
		map.put("/board.do", new BoardControl()); // 상세내용(content) 보기
		// 글 등록 (등록화면 -> 등록 처리)
		map.put("/addBoardForm.do", new AddBoardForm()); 
		map.put("/addBoard.do", new AddBoardControl());
		//글 수정 (수정 화면 -> 변경 처리 )
		map.put("/modifyBoard.do", new ModifyBoardControl()); // control 하나로 get 방식 (화면 출력), post방식(수정)으로 두가지로 나눠서 사용 
		//글 삭제 
		map.put("/removeBoard.do", new removeBoardControl());
		
	}
	
	// service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service호출");
		
		
		// 요청페이지 
		// 사용자가 웹에서 url 작성한 값을 가져온다. 
		// e.g http://localhost/FreeBoard/memberList.do  | URI = FreeBoard/memberList.do 로 프로젝트 이름만 가져오기 
		String uri = req.getRequestURI(); 
		String context = req.getContextPath(); // context = FreeBoard
		String page = uri.substring(context.length()); // substring (ㅃㅐ기) | URI - context = /memberList.do 만 나오게 된다. 
		
		Control control = map.get(page); 
		control.exec(req, resp);
	}
}// close class
