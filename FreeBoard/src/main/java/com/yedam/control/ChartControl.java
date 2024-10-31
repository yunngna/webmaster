package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ChartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// WEB-INF/jsp/etc/chart.jsp 호출 하기  ( tiles에 적용된 곳에 넣으려면 )
		req.getRequestDispatcher("etc/chart.tiles").forward(req, resp);

	}

}
