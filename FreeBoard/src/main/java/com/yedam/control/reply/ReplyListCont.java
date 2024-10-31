package com.yedam.control.reply;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		//게시글번호 하나가 parameter로 전달 
		// 페이지 번호 전달 
		
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		System.out.println("board_no=" + bno);
		
		//목록 가져오기
		ReplyService svc = new ReplyServiceImpl();
		//List<ReplyVO> list = svc.selectList(Integer.parseInt(bno)); 
		//페이징목록 가져오기 
		List<ReplyVO> list = svc.selectList(Integer.parseInt(bno),Integer.parseInt(page));
	
		//gson 라이브러리 사용 
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list); // 자바객체 -> json문자열로 변경
		
		resp.getWriter().print(json);	
	
	}

	
}
