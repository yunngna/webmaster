<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../includes/header.jsp"></jsp:include> 

	<h3>삭제화면 (removeForm.jsp)</h3>
<%
	String msg = (String) request.getAttribute("msg");
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
%>
<%if(msg != null){%>
<p style ="color:red;"> <%=msg%></p>	
<%}%>

	<form action="removeBoard.do" method ="POST">
		<input type ="hidden" name="bno" value="<%=board.getBoardNo()%>">
	 	<table class="table">
	 	<tr>
	 		<th>글번호</th><td><%=board.getBoardNo() %></td>
	 		<th>조회수</th><td><%=board.getViewCnt() %></td>
	 	</tr>
	 	<tr>
	 		<th>제목</th>
	 		<td>
	 			<%=board.getTitle()%>
	 		</td>
	 	</tr>
	 	<tr>
	 		<th>내용</th>
	 		<td>
	 		<textarea readonly class="form-control" name="content" rows="3" cols="100" ><%=board.getContent() %></textarea>
	 		</td>
	 	</tr>
	 	<tr>
	 		<th>작성자</th><td><%=board.getWriter() %></td>
	 	</tr>	
	 	<tr>
	 		<td colspan ="2" align = "center">
	 			<input type="submit" value="삭제" class="btn btn-warning">
	 			<input type="reset" value="취소" class="btn btn-warning">
	 		</td>
	 	</tr>		
	 	</table>
	</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>