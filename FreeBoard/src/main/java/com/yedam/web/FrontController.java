package com.yedam.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("*.do") // * 전체  ,  .do : .do로 끝나는 것 
public class FrontController extends HttpServlet {

}
