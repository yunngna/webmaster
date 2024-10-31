<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include> 

<!-- jstl 사용하기 위한 라이브러리 불러오기 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c태그 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- 데이터 포맷에 사용 -->

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
			<th>글번호</th>
			<td>${boardvo.boardNo}</td>
			<th>조회수</th>
			<td>${boardvo.viewCnt}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${boardbvo.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly name="content" rows="3"
					cols="100">${boardvo.content}</textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td colspan="3">
				<c:if test="${boardvo.img != null}">
					<img src="images/${boardvo.img}" width="100px">
				</c:if>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${boardvo.writer}</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td colspan="3">${boardvo.writeDate}</td>
		</tr>
		<tr>
			<td align="center" colspan="4"><input type="button" value="수정"
				class="btn btn-warning"> <input type="button" value="삭제"
				class="btn btn-warning"></td>
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