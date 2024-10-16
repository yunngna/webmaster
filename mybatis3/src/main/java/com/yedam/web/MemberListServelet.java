package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

/**
 * Servlet implementation class MemberListServelet
 */
// tomcat 이 정한 순서 (IOC ; 제어의 역전 [제어가 개발자가 안하고 tomcat이 한다는 의미])
// 객체 생성 -> init() -> service ()  -> 서버가 종료시 destroy() 실행 == 서블릿의 생명주기 

@WebServlet("/MemberListServelet") // 해당 URL 호출이 들어오면 해당 클래스가 실행된다. 
public class MemberListServelet extends HttpServlet { // 서블릿을 만들려면 HttpServlet을 상속 받아야 만들 수 있다. 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		SqlSession sqlSession = DataSource.getInstance().openSession(); 
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		response.setContentType("text/html;charset=utf-8"); 
		
		List<Member> result = dao.members();
		
		// html table 만들기
		String str = "<h3>회원목록</h3>";
		
		
		
		str += "<table border='1'>";
		str += "<thread><tr><th>회원아이디</th><th>회원이름</th><th>연락처</th>";
		str += "<tbody>";
		//버튼 링크가 아니라 내용 링크 넣어줄 때 순서 : ' 이동원하는 ULR ? (?뒤에 parameter 적어줘야 한다 = 해당하는 내용이 해당하는 변수) 
		//여기서 그냥 member.getMemberId를 작은 따옴표 안에 들어가면 문자 취급이라 큰따옴표로 감싸주고 +로 연결해준다 [" + member.getMemberId() + "] '
		
		for (Member member : result) { 
			str += "<tr><td><a href='member.action?mid="+ member.getMemberId()+ "'>" + member.getMemberId() 
				    +"</a></td><td>" + member.getMemberName() 
				    +"</td><td>" + member.getPhone() + "</td></tr>";	
		}
		str += "</tbody>";
		str += "</table>";
		
		
		str += "<a href='index.html'> 첫페이지로 이동></a>";
		
		
		response.getWriter().print(str);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
