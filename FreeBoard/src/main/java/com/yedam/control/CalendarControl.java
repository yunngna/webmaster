package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class CalendarControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  WEB-INF/jsp/etc/calendar.jsp 호출 하기
		req.getRequestDispatcher("etc/calendar.tiles").forward(req, resp);

	}

}
