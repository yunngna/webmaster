package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.CalendarVO;

public class RemoveEventCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); // 값을 받을 때 (클라이언트가 보낸 값) 문자 안깨지게 해주는 것 
		resp.setContentType("text/json;charset=utf-8"); // 값을 보낼 때 문자 안깨지게 해주는것
		
		// title, startDate ,endDate 세개 parameter받아오기 
		String title = req.getParameter("title");
		String startD = req.getParameter("start");
		String endD = req.getParameter("end");
		
		CalendarVO rvo = new CalendarVO();
		rvo.setTitle(title);
		rvo.setStartDate(startD);
		rvo.setEndDate(endD);
		
		System.out.println(rvo);
		
		Map<String,Object> result = new HashMap<>();
		MemberService svc = new MemberServiceImpl();
		if(svc.removeEvent(rvo)) {
			result.put("retCode", "OK");
			System.out.println(result);
		}else {
			result.put("retCode", "FAIL");
		}
		
		//Gson 활용해서 json으로 변경 
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));

	}

}
