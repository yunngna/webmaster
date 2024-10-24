package com.yedam.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;


public class CalendarWriterCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		MemberService svc = new MemberServiceImpl();
		List<Map<String,Object>> result = svc.eventList();
		
//		try {
//			Thread.sleep(1000); // 1초를 기다렸다가 나오게 하는 것 (데이터를 가져오고 나서 데이터를 웹에 그려줘야 하기 때문에 데이터 보다 먼저 그려지는걸 방지 하기 위해 1초 치연해준다)
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		
		resp.getWriter().print(json);
		
		
		

	}

}
