package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	void exec (HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException,IOException; //execute 의미 [req = 요청정보담기, resp= 응답정보담기] + try and catch 예외처리 상위해서 미리 해주기  
}
