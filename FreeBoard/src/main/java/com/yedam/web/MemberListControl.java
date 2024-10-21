package com.yedam.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

// 인터페이스를 적용받는 구현클래스는 반드시 인터페이스 적용 된 이름으로 메소드 생성 되어야 한다. 
public class MemberListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberListControl");
		
		MemberService svc = new MemberServiceImpl();
		List<MemberVO>list = svc.memberList();
		
		req.setAttribute("memberList", list); // 요청을 받은 결과 
		
		try {
			// memberList.do 요청을 재지정 |  요청하는 곳을 재 지정 하는 기능 (= 요청받아보내줄 값을 나타낼 곳을 지정)
			// memberList.do 로 요청된 페이지에서 memberList.jsp 요청 재 지정  ( 실제 url 은 동일하게 나타난다. )
			req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}//close class
