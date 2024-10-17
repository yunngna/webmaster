<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include> 
	<h3>글목록</h3>
<%
	List<BoardVO>list = (List<BoardVO>) request.getAttribute("boardList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜 규격 만들기 
%>
<table class="table">
	<thread>
		<tr>
		<th>글번호</th><th>제목</th><th>작성자</th><th>작성일자</th><th>조회수</th>
		</tr>
	</thread>
	<tbody>
	<%for (BoardVO board : list) { 
		//date 포맷 (2024-01-01 12:22:33)
	String wdate= sdf.format(board.getWriteDate()); // 날짜를 문자 변수에 넣어 저장 
	%>
		<tr>
		<td><%=board.getBoardNo() %></td>
		<td><a href='board.do?bno=<%=board.getBoardNo()%>'><%=board.getTitle()%></a></td>
		<td><%=board.getWriter() %></td>
		<td><%=wdate %></td>
		<td><%=board.getViewCnt() %></td>
		</tr>
	<%} %>
	</tbody>
</table>
<%
	PageDTO paging = (PageDTO)request.getAttribute("page");
%>
<%=paging %>

<!-- paging -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
    <%for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {%>
    <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
    <% }%>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>

<jsp:include page="../includes/footer.jsp"></jsp:include>