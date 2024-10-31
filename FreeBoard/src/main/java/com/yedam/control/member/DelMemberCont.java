package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class DelMemberCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		MemberService svc = new MemberServiceImpl();
		if(svc.retireMember(id)) {
			// 잘 등록이 된다면 {"retCod":"OK"}
			resp.getWriter().print(" {\"retCod\":\"OK\"}");
		}else {
			//등록 실패시  {"retCod":"Fail"}
			resp.getWriter().print(" {\"retCod\":\"FAIL\"}");
		}
	}

}
