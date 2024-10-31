<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>javascript.jsp</h3>
<table class="table">
	<!--데이터 등록 | 정보 받기-->
	<tr>
		<th>회원아이디</th>
		<td><input type ="text" id="mid"></td>
	</tr>
	<tr>
		<th>회원이름</th>
		<td><input type ="text" id="mname"></td>
	</tr>
	<tr>
		<th>연락처</th>
		<td><input type ="text" id="phone"></td>
	</tr>
	<tr>
		<td colspan="2" class="text-center">
		<button id="addBtn">등록</button></td>
	</tr>
</table>

<div id="show">
	<!-- 회원목록 출력-->
	<table class="table">
		<thead>
			<tr>s
				<th>회원아이디</th>
				<th>회원이름</th>
				<th>연락처</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>

</div>
<!-- 데이터 와 자바스크립트 사용을 위해 변수 선언 -->
<!-- <script src="js/data.js"></script> -->
<!-- <script src="js/json.js"></script> -->

<!-- <script src="js/members.js"></script>  -->
<script src="js/ajax1.js"></script> 
