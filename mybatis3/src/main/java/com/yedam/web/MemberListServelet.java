package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

/**
 * Servlet implementation class MemberListServelet
 */
@WebServlet("/MemberListServelet")
public class MemberListServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		SqlSession sqlSession = DataSource.getInstance().openSession(); // 자동 commit 으로 true 적기 
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		response.setContentType("text/html;charset=utf-8"); 
		
		List<Member> result = dao.members();
		for (Member member : result) {
			response.getWriter().print(member+"\n");		
		}
		PrintWriter out = response.getWriter();
		out.print("<a href='index.html'> 첫페이지로 이동></a>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
