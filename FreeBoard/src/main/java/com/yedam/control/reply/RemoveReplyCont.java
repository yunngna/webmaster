package com.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter 받아오기 (rno) --> 삭제 (성공시 ok , 실패시 fail  json 형태로 반환 )
		
		String rno = req.getParameter("rno");
		System.out.println("control ron="+ rno);
		ReplyService svc = new ReplyServiceImpl();
		if (svc.deleteReply(Integer.parseInt(rno))){
			// 잘 삭제 된다면 {"retCod":"OK"}
		resp.getWriter().print(" {\"retCode\":\"OK\"}");
		}else {
			//삭제 실패시  {"retCod":"Fail"}
			resp.getWriter().print(" {\"retCode\":\"FAIL\"}");
		}

	}

}
