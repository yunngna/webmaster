<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include> 

	<h3>상세페이지(board.jsp)</h3>
<% 
	BoardVO bvo = (BoardVO)request.getAttribute("boardvo");
	String pg = (String)request.getAttribute("page"); // (3) 페이지 번호 넘겨주기 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String wdate= sdf.format(bvo.getWriteDate());
	String sc = request.getParameter("searchCondition");
	String kw = request.getParameter("keyword");

%>
		<form action="modifyBoard.do" method="get">
			<table class="table">
			<tr>
				<th>글번호</th><td><%=bvo.getBoardNo() %></td><th>조회수</th><td><%=bvo.getViewCnt() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan ="3"><%=bvo.getTitle() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan ="3"><textarea readonly name="content" rows="3" cols="100"><%=bvo.getContent() %></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td colspan ="3"><%=bvo.getWriter() %></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td colspan ="3"><%=wdate%></td>
			</tr>
			<tr>
				<td align ="center" colspan ="4">
					<input type="button" value="수정" class="btn btn-warning">
					<input type="button" value="삭제" class="btn btn-warning">
				</td>
			</tr>
			</table>
		</form>
		

<jsp:include page="../includes/footer.jsp"></jsp:include>
<script>
 document.querySelector('input[value="수정"]')
 	.addEventListener('click', function(e){
	 location.href = 'modifyBoard.do?page=<%=pg%>&bno=<%=bvo.getBoardNo()%>&searchCondition=<%=sc%>&keyword=<%=kw%>';
	 /*(3) 수정버튼이 작동 시 페이지 번호와 게시판 번호를 modifyBoard.do 로넘겨 준다. */
 });
 
 document.querySelector('input[value="삭제"]')
	.addEventListener('click', function(e){
	 location.href = 'removeBoard.do?bno=<%=bvo.getBoardNo()%>';
});
 
 
</script>