<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 


<!-- jstl 사용하기 위한 라이브러리 불러오기 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c태그 -->

	<h3>회원목록</h3>
	<%
		List<MemberVO> list =(List<MemberVO>) request.getAttribute("memberList"); //memberList가 object를 List 로 강제 타입 변환 
		System.out.println(list);
	%>
	<table class="table"> 
	  <tbody>
		<c:forEach var="mvo" items="${memberList}">
            <tr>
                <td>${mvo.memberId}</td>
                <td>${mvo.memberName}</td>
                <td>${mvo.phone}</td>
            </tr>
        </c:forEach>
		</tbody>
	</table>

