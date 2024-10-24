package com.yedam.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

public class AddEventCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); // 값을 받을 때 (클라이언트가 보낸 값) 문자 안깨지게 해주는 것 
		resp.setContentType("text/json;charset=utf-8"); // 값을 보낼 때 문자 안깨지게 해주는것
		
		// title,start,end parameter 받기 
		String title = req.getParameter("title");
		String startD = req.getParameter("start");
		String endD = req.getParameter("end");
		
		
		
		CalendarVO rvo = new CalendarVO();
		rvo.setTitle(title);
		rvo.setStartDate(startD);
		rvo.setEndDate(endD);
		
		
		System.out.println("dfjhdjfhdjfhdjskhfjdhjf="+rvo);
		
		
		MemberService svc = new MemberServiceImpl();
		
		Map<String,Object> result = new HashMap<>();
		
		try {
			//성공시에는 {retCod:OK retVal:rvo} 반환  
			svc.addEvent(rvo);
			System.out.println(rvo);
			result.put("retCode", "OK");
			result.put("retVal",rvo);
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
			// 실패시에는 {retCod:FAIL retVal:null} 반환 
			result.put("retCode", "FAIL");
			result.put("retVal",null);
		}
		//Gson 활용해서 json으로 변경 
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));
		

	}

}
