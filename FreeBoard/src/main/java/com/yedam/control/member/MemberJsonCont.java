package com.yedam.control.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberJsonCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//회원목록을 json형태 로 반환 
		resp.setContentType("Text/json;charset=utf-8");
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list =svc.memberList();
		
		//[{"memberId: "user01", "memberName":"사용자1",....},
		// {                 .......                       },
		//{                 .......                       }]
		// 데이터 담을 변수 형성
		String json = "[";
		for(int i=0; i<list.size(); i++) {
			json += "{\"memberId\":\"" + list.get(i).getMemberId()+"\",\"memberName\":\""+list.get(i).getMemberName()+"\",\"phone\":\""+list.get(i).getPhone()+"\"}";
			if(i !=list.size()-1) { // 맨 마지막 데이터 전 까지 마지막에 , 붙이기 
				json += ",";
			}
			
		}
		json += "]";
		resp.getWriter().print(json);
		

	}

}
