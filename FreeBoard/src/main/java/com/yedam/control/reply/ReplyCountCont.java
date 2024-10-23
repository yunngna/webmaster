package com.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class ReplyCountCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시글 번호 parameter 가져오기 
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt = svc.replyCount(Integer.parseInt(bno));
		
		//{"totalCount:" 10 } 이런식으로 반환 되도록 한다.
		resp.getWriter().print("{\"totalCount\":"+ totalCnt +"}");
		
		
	}

}
