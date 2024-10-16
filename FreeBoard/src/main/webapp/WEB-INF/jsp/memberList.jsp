<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<jsp:include page="../includes/header.jsp"></jsp:include> 

	<h3>회원목록</h3>
	<%
		List<MemberVO> list =(List<MemberVO>) request.getAttribute("memberList"); //memberList가 object를 List 로 강제 타입 변환 
		System.out.println(list);
	%>
	<table class="table"> 
	  <tbody>
	<%
		for(MemberVO mvo : list){
	%>
	<tr><td><%=mvo.getMemberId() %></td>
		<td><%=mvo.getMemberName() %></td>
		<td><%=mvo.getPhone() %></td>
	</tr>
	<%}%>
		</tbody>
	</table>

<jsp:include page="../includes/footer.jsp"></jsp:include>