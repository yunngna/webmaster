package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// id 와 pw 를 받아오는 parameter
		String id = req.getParameter("logId");
		String pw = req.getParameter("logPw");
		
		
		if (req.getMethod().equals("GET")) {
		// 보여줄 jsp 페이지  
		req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
		
		}else if (req.getMethod().equals("POST")) {
			// 로그인 실행 
			MemberService svc = new MemberServiceImpl();
			if (svc.loginCheck(id, pw)==null) {
				//로그인 실패 
				// 로그인 화면(loginForm.jsp)으로 이동 + 알림 참과 함께 
				req.setAttribute("msg", "아이디와 비밀번호 확인하세요"); 
				req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
				return;
			}
			// 정상 실행 (정상 로그인) | session 객체 : 사용자가 일부러 지우지 않으면 화면 종료 까지 지워지지 않는다.
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);
			
			// 글 목록으로 이동 
			resp.sendRedirect("boardList.do");
		}
	}

}
