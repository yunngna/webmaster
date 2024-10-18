<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@page import="com.yedam.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- MVC 디자인 : View (JSP페이지) , Model(DB처리) , 컨트롤 (보통 자바코드는 Model , 컨트롤에서 하고 보여지는 것만 JSP 페이지에서 실시-->

	<!-- Expression Language : EL -->
	<p>${"Hello"}</p>
	<p>${3+5>4}</p>
	<p>${3+5==4}</p>
	<p>${logId}</p>
	
	<!-- Action tag = 태그안에 기능을 담고 있는 것 ( jsp 가 기본적으로 가지고 있는 action tag 가 있다.) -->
	<!-- JSP Standard Tag Library = JSTL ; jsp 가 기본적으로 가지고 있는 action tag -->
	<!-- jstl 사용하면 자바코드 삭제 가능  -->
	
	
	
	<c:set var="name" value="Hong"></c:set> <!-- 변수 지정 e.g String name = "Hong"-->
	<c:out value ="${name}"></c:out> <!-- 변수 출력 -->
	<c:out value ="홍길동"></c:out> 
	
	<!-- 조건문 -->
	<c:set var="age" value="20"></c:set>
	<c:if test ="${age >= 20 }">
		<p>성년입니다.</p>
	</c:if>
	
	<!-- ifelse 구문 = when 사용-->
	<c:choose>
		<c:when test="${age>=60 }">
			<p>노인</p>
		</c:when>
		<c:when test="${age>=20 }">
			<p>성인</p>
		</c:when>
		<c:otherwise>
			<p>미성년</p>
		</c:otherwise>
	</c:choose>
	
	<!-- 반복문 for each | step : 증가하는 수-->
	<c:forEach var="i" begin="1" end="5" step="1">
		<p>i의 값은 ${i }입니다.</p>
	</c:forEach>
	
	<!-- url 이동  -->
	<c:set var="page" value="boardList.do"></c:set>
	<jsp:forward page="${page }"></jsp:forward>
	
	
	
	
	
	
</body>
</html>