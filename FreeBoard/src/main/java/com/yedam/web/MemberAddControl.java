package com.yedam.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberAddControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("MemberAddControl");
		
		// 값 받아오기 (클라이언트로 부터 )
		String id = req.getParameter("mid");
		String nm = req.getParameter("mname");
		String pw = req.getParameter("passwd");
		String pn = req.getParameter("phone");
		
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setMemberName(nm);
		mvo.setPassword(pw);
		mvo.setPhone(pn);
		
		MemberService svc = new MemberServiceImpl();
	
			try {
				//입력받은 값이 잘 넣어 지는 경우 
				svc.addMember(mvo); 
				// 목록 페이지로 이동 
				// 페이지 제지정  방법 2가지 
				//1. getRequestDispatcher("jsp/memberList.jsp").forward(req, resp)
				//2. sendRedirct  => 값은 전달 하지 못하고 그냥 페이지 이동 
				resp.sendRedirect("memberList.do");
			} catch (Exception e) {
				// 등록화면으로 이동 (예외 사항으로 동일 값 넣으면 입력 페이지 이동)
				e.printStackTrace();
				resp.sendRedirect("memberAddForm.do");
			}
		
		
	}
	
}// close class
