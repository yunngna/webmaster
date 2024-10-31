package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AddMemberCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id, name, phone , password= '1111' 
		MemberVO member = new MemberVO();
		member.setMemberId(req.getParameter("id"));
		member.setMemberName(req.getParameter("name"));
		member.setPhone(req.getParameter("phone"));
		member.setPassword("1111");
		
		MemberService svc = new MemberServiceImpl();
		try {
			svc.addMember(member);
			// 잘 등록이 된다면 {"retCod":"OK"}
			resp.getWriter().print(" {\"retCod\":\"OK\"}");
			
		}catch(Exception e){
			//등록 실패시  {"retCod":"Fail"}
			resp.getWriter().print(" {\"retCod\":\"FAIL\"}");
			
		}

	}

}
