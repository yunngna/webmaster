<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../includes/header.jsp"></jsp:include> 
<!-- jstl 사용하기 위한 라이브러리 불러오기 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c태그 -->


	<h3>수정화면 (modifyForm.jsp)</h3>
<%
	String msg = (String) request.getAttribute("msg");
	String pg = (String) request.getAttribute("page");
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
	
	//리스트에 검색해서 나온 결과가 페이지가 변환되도 연속해서 출력 되게 하기 
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	
	//session 의 아이디값 가져와서 다른 아이디는 수정 불가 하게 만들기
	String logId = (String) session.getAttribute("logId");
%>

<c:if  test="${msg != null }">
	 <p style="color:red;">${msg}</p>
</c:if>



	<form action="modifyBoard.do" method ="POST">
	<!-- hidden 으로 안보기에 게시글 번호와 페이지  modifyBoard.do post 로 전달-->
		<input type ="hidden" name="bno" value="${boardvo.boardNo}">
		<input type ="hidden" name="page" value="${page}">
		<input type = "hidden" name="searchCondition" value="${searchCondition}">
		<input type = "hidden" name ="keyword" value="${keyword}">
	 	<table class="table">
	 	<tr>
	 		<th>글번호</th><td>${boardvo.boardNo}</td>
	 		<th>조회수</th><td>${boardvo.viewCnt}</td>
	 	</tr>
	 	<tr>
	 		<th>제목</th>
	 		<td>
	 			<input class="form-control" type="text" name="title" value = "${boardvo.title}">
	 		</td>
	 	</tr>
	 	<tr>
	 		<th>내용</th>
	 		<td>
	 		<textarea class="form-control" name="content" rows="3" cols="100" >${boardvo.content}</textarea>
	 		</td>
	 	</tr>
	 	<tr>
	 		<th>작성자</th><td colspan ="3">${boardvo.writer}</td>
	 	</tr>	
	 	<tr>
	 		<td colspan ="2" align = "center">
	 			<c:choose>
	 				<c:when test = "${logId != null && logId == boardvo.writer}">
	 					<input type="submit" value="저장" class="btn btn-success">
	 				</c:when>
	 				<c:otherwise>
	 					<input type="submit" value="저장" class="btn btn-success" disabled >
	 				</c:otherwise>
	 			</c:choose>
	 			<input type="reset" value="취소" class="btn btn-warning">
	 		</td>
	 	</tr>		
	 	</table>
	</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>