package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class ProjectLoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//프로젝트체크용 
		String id = req.getParameter("memberId");
		String pw = req.getParameter("password");
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			// login.jsp페이지로 이동 
			req.getRequestDispatcher("etc/login.tiles").forward(req, resp);
		}else if (req.getMethod().equalsIgnoreCase("POST")) {
			MemberService svc = new MemberServiceImpl();
			MemberVO member = svc.MemberLogin(id, pw);
			System.out.println(member);
			if (member == null) {
				//로그인 실패 (login.jsp로 이동)
				req.setAttribute("msg", "아이디와 비밀번호를 입력하세요");
				req.getRequestDispatcher("etc/login.tiles").forward(req, resp);
				return;
			}
			
			//정상 로그인 시
			HttpSession sessions = req.getSession();
			sessions.setAttribute("memberId", id);
		}

	}

}
