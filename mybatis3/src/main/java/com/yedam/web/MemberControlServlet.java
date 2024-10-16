package com.yedam.web;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

// 서블렛 만들기
// 객체 생성 -> init() -> service() -> 서버 종료후 destroy() 

@WebServlet("/member.action") // URL 만들어주기 
public class MemberControlServlet extends HttpServlet { // 서블렛을 만들려면 HttpServlet을 상속 받아야 한다. 
	// 객체 생성 
	public MemberControlServlet () {
		System.out.println("MemberControl 객체 생성");
	}
	
	// init 생성 : 최초 요청시 한번만 실행 
	@Override // init + ctrl + space 해서 두번째 거 사용 
		public void init(ServletConfig config) throws ServletException {
			System.out.println("최초요청이면 init 실행");
		}
	
	//service 생성 : 서블렛 요청 (서버에서 요청) 마다 실행  ( doget , dopost 가 없는 경우 무조건 service 호출) = 기능은 service에 넣어줘야 한다. 
	@Override // service + ctrl + space 첫번째 거 사용 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// content type 만들어주기
		resp.setContentType("text/html;charset=utf-8");

		System.out.println("서블렛을 요청할 때 마다 실행");
		
		// Mapper 실행 
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		// 매개변수 설정 
		String id = req.getParameter("mid"); 
		// http://localhost/mybatis3/member.action?mid=user01 [: ? 뒤에 값이 parameter]
		
		
		// get : 조회 화면 , post : 삭제 처리
		if (req.getMethod().equals("GET")) { // 단건조회 

			Member member = dao.selectMember(id);

			if (member == null) { // 조회된 정보 없는 경우
				resp.getWriter().print("조회된 정보가 없습니다.");
				return;
			}

			// html table 만들기
			String str = "<h3>회원정보</h3>";

			// form 태그로 감싸기
			str += "<form action='member.action' method='post'>";
			str += "<input type='hidden' name='mid' value='" + member.getMemberId() + "'>";
			

			str += "<table border='1'>";
			str += "<tr><th>회원아이디</th><td>" + member.getMemberId() + "</td></tr>";
			str += "<tr><th>회원이름</th><td>" + member.getMemberName() + "</td></tr>";
			str += "<tr><th>연락처</th><td>" + member.getPhone() + "</td></tr>";
			str += "<tr><td colspan='2'><input type ='submit'></td></tr>";
			str += "</table>";

			str += "</form>"; // close form 태그

			// 링크 추가
			str += "<a href='MemberListServelet'> 목록으로 </a>";

			// 화면 출력
			resp.getWriter().print(str);
			
		} else if (req.getMethod().equals("POST")) { // 삭제 처리
			if (dao.deleteMember(id)==1) {
				resp.getWriter().print("<p>삭제완료</p>");
			}else {
				resp.getWriter().print("<p>삭제 할 아이디가 없습니다.</p>");
			}
			resp.getWriter().print("<a href='MemberListServelet'> 목록으로 </a>");
		}
	}
	
	// destroy 생성 : 서버 종료시 한번 실행 
	@Override
		public void destroy() {
			System.out.println("서버 종료시 한번 실행");
		}

}
