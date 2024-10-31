<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<!-- jstl 사용하기 위한 라이브러리 불러오기 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

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
	<%for (BoardVO board : list) { 
		//date 포맷 (2024-01-01 12:22:33)
	String wdate= sdf.format(board.getWriteDate()); // 날짜를 문자 변수에 넣어 저장 
	%>
		<tr>
		<td><%=board.getBoardNo() %></td>
		<!--(1) 페이지에서 수정 한 후 목록으로 나가면 수정한 목록 페이지에 유지 하기 위해 현재 페이지 번호와 게시글 번호를 같이 넘겨 준다. (두개 이상 넘기는 경우 &으로 연결)
		그리고 board.do 에도 페이지, 게시글 번호 둘다 넘겨준다.  -->
		<td><a href='board.do?page=<%=paging.getPage()%>&bno=<%=board.getBoardNo()%>&searchCondition=<%=sc%>&keyword=<%=kw%>'><%=board.getTitle()%></a></td>
		<td><%=board.getWriter() %></td>
		<td><%=wdate %></td>
		<td><%=board.getViewCnt() %></td>
		</tr>
	<%} %>
	</tbody>
</table>
<!-- paging 값 불러 오면 PageDTO(startPage=1, endPage=10, prev=false, next=true, page=10) 이렇게 출력됨     -->

<!-- paging -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  
  <!-- 이전페이지 여부  -->
  <!-- isPrev() | prev 는 boolean 타입의 변수로 해당 변수가 true인지 여부 알려줄때 is변수() 사용한다. -->
  <%if (paging.isPrev()){ %> 
 		<li class="page-item">
    	 	<a class="page-link" href="boardList.do?page=<%=paging.getStartPage()-1%>">Previous</a>
    	 </li>
    <%} else{ %>
    	<li class="page-item disabled">
      		<a class="page-link">Previous</a>
      	 </li>
      	<%} %>
      	
    <!-- 페이지 출력  -->
    <%for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {%>
    	<%if (paging.getPage() == p){%>
    	<li class="page-item active" aria-current="page">
    		<span class="page-link"><%=p %></span>
    		</li>
    <%}else{ %>
    	<li class="page-item">
    	<!-- 리스트에 검색해서 나온 결과가 페이지가 변환되도 (searchCondition 와 keyword , page 전달해서) 연속해서 출력 되게 하기  -->
    		<a class="page-link" href="boardList.do?searchCondition=<%=sc%>&keyword=<%=kw %>&page=<%=p %>"><%=p %></a>
    	</li>
    	<%}%>
   <%}%>
   
    
     <!-- 다음페이지 여부  -->
  <%if (paging.isNext()){ %>
 		<li class="page-item">
    	 	<a class="page-link" href="boardList.do?page=<%=paging.getEndPage() %>">Next</a>
    	 </li>
    <%}else{ %>
    	<li class="page-item disabled">
      		<a class="page-link">Next</a>
      	 </li>
      	<%} %>
  </ul>
</nav>

<jsp:include page="../includes/footer.jsp"></jsp:include>