package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.AddEventCont;
import com.yedam.control.CalendarControl;
import com.yedam.control.CalendarWriterCont;
import com.yedam.control.ChartControl;
import com.yedam.control.CountWriterCont;
import com.yedam.control.JavaScriptCont;
import com.yedam.control.RemoveEventCont;
import com.yedam.control.board.AddBoardControl;
import com.yedam.control.board.AddBoardForm;
import com.yedam.control.board.BoardControl;
import com.yedam.control.board.BoardListControl;
import com.yedam.control.board.ModifyBoardControl;
import com.yedam.control.board.removeBoardControl;
import com.yedam.control.member.AddMemberCont;
import com.yedam.control.member.DelMemberCont;
import com.yedam.control.member.LogOutControl;
import com.yedam.control.member.LoginControl;
import com.yedam.control.member.MemberAddControl;
import com.yedam.control.member.MemberAddFormControl;
import com.yedam.control.member.MemberJsonCont;
import com.yedam.control.member.MemberListControl;
import com.yedam.control.reply.AddReplyCont;
import com.yedam.control.reply.RemoveReplyCont;
import com.yedam.control.reply.ReplyCountCont;
import com.yedam.control.reply.ReplyListCont;

//@WebServlet("*.do") 
// * 전체  ,  .do : .do 끝나는 것  = .do 로 끝나는 url 경우 모두 호출 됨 -> 서브렛이 너무 많으면 관리가 복잡하기 때문에 사용 
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
		
		// 로그인 관련
		map.put("/loginForm.do", new LoginControl());
		map.put("/logOut.do", new LogOutControl());
		
		//자바스크립트 실행
		map.put("/javascript.do", new JavaScriptCont());
		
		// json 관련
		map.put("/memberJson.do", new MemberJsonCont());
		map.put("/addMemberJson.do", new AddMemberCont());
		map.put("/removeMemberJson.do", new DelMemberCont());
		
		
		//댓글관련
		map.put("/replyList.do", new ReplyListCont());
		map.put("/removeReply.do",new RemoveReplyCont());
		map.put("/addReply.do", new AddReplyCont());
		map.put("/replyCount.do", new ReplyCountCont());
		
		//차트 (차트API)
		map.put("/chart.do", new ChartControl()); //차트(jsp)불러오기
		map.put("/countByWriter.do",new CountWriterCont()); //데이터 불러오는 컨트롤
		
		//캘린더 (캘린더 API)
		map.put("/calendar.do", new CalendarControl()); //캘린더 (jsp) 불러오기 
		map.put("/calendarByWirter.do", new CalendarWriterCont());
			//추가
		map.put("/addEvent.do", new AddEventCont());
			//삭제 
		map.put("/removeEvent.do", new RemoveEventCont());
		
		
		
		
		
		System.out.println("rjsjsejje");
		
	}
	
	// service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//System.out.println("service호출");
		
		
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
