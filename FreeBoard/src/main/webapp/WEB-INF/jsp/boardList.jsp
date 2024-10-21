<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- jstl 사용하기 위한 라이브러리 불러오기 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c태그 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- 데이터 포맷에 사용 -->

	<h3>글목록(boardList.jsp)</h3>
<%
	PageDTO paging = (PageDTO)request.getAttribute("page");
%>
<%
	List<BoardVO>list = (List<BoardVO>) request.getAttribute("boardList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜 규격 만들기
	
	//리스트에 검색해서 나온 결과가 페이지가 변환되도 연속해서 출력 되게 하기 
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	kw = kw == null ? "" : kw ; // null 값 처리하기 
%>

<!-- 검색 조건 (게시글 검색)-->
<form action ="boardList.do" class="row g-3">
  <div class="col-md-3">
    <select name="searchCondition" class="form-select">
      <option selected value="">선택하세요.</option>
      <option value="T" <%=(sc != null && sc.equals("T") ? "selected" : "") %>>제목</option>
      <option value="W">작성자</option>
      <option value="TW">제목 & 작성자</option> <!-- 제목이나 작성자 둘 중 하나에 keyword가 있으면 출력 -->
    </select>
  </div>
  <div class="col-md-4">
    <input type="text" class="form-control" name="keyword" value="<%=kw %>">
  </div>
  <div class="col-md-5">
    <button type="submit" class="btn btn-primary">조회</button>
  </div>
</form>


<table class="table">
	<thead>
		<tr>
		<th>글번호</th><th>제목</th><th>작성자</th><th>작성일자</th><th>조회수</th>
		</tr>
	</thead>
	<tbody>
	
	<!-- 반복문 사용 (열고 닫고 한번에 하려면 마지막에 / 붙여준다)-->
	<c:forEach var="board" items="${boardList}">
		<tr>
		<td><c:out value="${board.boardNo}"/> </td>
		<td><a href='board.do?page=${paging.page}&bno=${board.boardNo}&searchCondition=${searchCondition}&keyword=${keyword}'>${board.title}</a></td>
		<td><c:out value="${board.writer}"/></td>
		<td><fmt:formatDate value ="${board.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><c:out value="${board.viewCnt}"/></td>
		</tr>
	</c:forEach>
	
	</tbody>
</table>

<!-- paging -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  
  <!-- 이전페이지 여부  -->
  <!-- isPrev() | prev 는 boolean 타입의 변수로 해당 변수가 true인지 여부 알려줄때 is변수() 사용한다. -->
		<c:choose>
			<c:when test="${page.prev}">
				<li class="page-item"><a class="page-link"
					href='boardList.do?page=${page.startPage-1}&searchCondition=${searchCondition}&keyword=${keyword}'>Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Previous</a>
				</li>
			</c:otherwise>
		</c:choose>



<!-- 페이지 출력  -->
    <c:forEach var="p" begin="${page.startPage}" end="${page.endPage}">
    	<c:choose>
    		<c:when test="${page.page==p}">
    			<li class="page-item active" aria-current="page">
    			<span class="page-link">${p}</span>
    			</li>
    		</c:when>
    		<c:otherwise>
    			<li class="page-item">
    			<a class="page-link" href='boardList.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${p}'>${p}</a>
   				</li>
    		</c:otherwise>
    	
    	</c:choose>
    
    </c:forEach>

   
     <!-- 다음페이지 여부  -->
     
   <c:choose>
  	<c:when test="${page.next}">
  		<li class="page-item">
    	 	<a class="page-link" href="boardList.do?page=${page.endPage+1}">Next</a>
    	 </li>
    </c:when>
    <c:otherwise>
    	<li class="page-item disabled">
      		<a class="page-link">Next</a>
      	 </li>
   </c:otherwise>
  </c:choose>
  

  </ul>
</nav>

