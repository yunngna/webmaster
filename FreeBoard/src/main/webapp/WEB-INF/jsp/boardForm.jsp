<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include> 

<!-- jstl 사용하기 위한 라이브러리 불러오기 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c태그 -->

	<h3>등록화면 (boardForm.jsp)</h3>
<%
	String msg = (String) request.getAttribute("msg");
	String logId = (String) session.getAttribute("logId");
%>

<c:choose>
    <c:when test="${not empty msg}">
        <p style="color:red;">${msg}</p>
    </c:when>
    <c:otherwise>
        <p></p> <!-- 필요에 따라 빈 경우에 대한 처리 -->
    </c:otherwise>
</c:choose>



	<form action="addBoard.do" method ="POST">
		<input class="form-control" type="hidden" name="writer" value="<%=logId%>">
	 	<table class="table">
	 	<tr>
	 		<th>제목</th><td><input class="form-control" type="text" name="title"></td>
	 	</tr>
	 	<tr>
	 		<th>내용</th><td><textarea class="form-control" name="content" rows="3" cols="100"></textarea></td>
	 	</tr>
	 	<tr>
	 		<th>작성자</th><td><%=logId%></td>
	 	</tr>	
	 	<tr>
	 		<td colspan ="2" align = "center">
	 			<input type="submit" value="저장" class="btn btn-success">
	 			<input type="reset" value="취소" class="btn btn-warning">
	 		</td>
	 	</tr>		
	 	</table>
	</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>