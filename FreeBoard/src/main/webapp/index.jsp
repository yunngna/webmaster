<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@page import="com.yedam.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- MVC 디자인 : View (JSP페이지) , Model(DB처리) , 컨트롤 (보통 자바코드는 Model , 컨트롤에서 하고 보여지는 것만 JSP 페이지에서 실시-->
	<%
	String myName = "권나윤";
	MemberService svc = new MemberServiceImpl();
	if (svc.retireMember("guest")) {
	%>
	<P>삭제되었습니다.</P>

	<%
	} else {
	%>
	<P>회원정보가 없습니다.</P>
	<%
	}
	%>
	
	<h3>내이름은 <%=myName %> 입니다.</h3>
	
	
</body>
</html>