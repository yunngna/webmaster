<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl 사용하기 위한 라이브러리 불러오기 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c태그 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- 데이터 포맷에 사용 -->
    
<style>
	.reply span{
		display: inline-block;
	}
	.reply ul{
		list-style-type: none;
	}
	
</style>
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

<!-- 댓글관련 -->


<div class="container reply">
<!-- 댓글등록 -->
<div class="header">
	댓글내용<input class="col-sm-8" id="reply">
	<button class="col-sm-3" id="addReply">댓글등록</button>
</div>
<!-- 댓글목록 -->
<div class="content">
	<ul>
		<li>
			<span class="col-sm-2">글번호</span>
			<span class="col-sm-5">글내용</span>
			<span class="col-sm-2">작성자</span>
			<span class="col-sm-2">삭제</span>
		</li>
		<!--  <li>
			<span class="col-sm-2">3</span>
			<span class="col-sm-5">댓글입니다.</span>
			<span class="col-sm-2">user01</span>
			<span class="col-sm-2"><button>삭제</button></span>
		</li>-->
		
	</ul>
</div>
<!-- 댓글페이징 -->
<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>


<jsp:include page="../includes/footer.jsp"></jsp:include>


<script>

	const bno = "${boardvo.boardNo}";//console.log(bno); //페이지의 게시글 번호 가져오기 
	const logId = "${logId}"; //console.log(logId);  // 로그인 상태의 로그아이디 가져오기

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

<!--댓글 자바스크립트 연결 -->
<!--<script src ="js/replyService.js"></script>  -->
<!-- <script src="js/reply.js"></script> -->

<!-- jquery 라이브러리리 추가  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src = "js/jreply.js"></script>