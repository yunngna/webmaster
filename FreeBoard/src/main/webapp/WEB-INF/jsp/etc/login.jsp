<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c태그 -->
<title>inTheForestLogin</title>
<!-- <link rel="stylesheet" href="css/site/template.css"> -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- 데이터 포맷에 사용 -->


<c:if  test="${msg != null }">
	 <p style="color:red;">${msg }</p>
</c:if>


<div class="container min-vh-100 d-flex justify-content-center align-items-center">
		<form action="logins.do" method="POST" class="text-center">
			<!-- ID  -->
			<div data-mdb-input-init class="form-outline mb-4">
				<input type="text" name ="memberId" class="form-control" placeholder="ID"/>
			</div>
		  
			<!-- Password -->
			<div data-mdb-input-init class="form-outline mb-4">
			  <input type="password" name="password" class="form-control" placeholder="password" />
			</div>
		  
			<!-- 아이디기억하기 -->
			<div class="row mb-4">
			  <div class="col d-flex justify-content-center">
				<!-- Checkbox -->
				<div class="form-check">
				  <input class="form-check-input" type="checkbox" value="" id="checkId" name="checkId" checked />
				  <label class="form-check-label" for="form2Example31"> RememberId</label>
				</div>
			  </div>
		  	</div>
		  
			 
			<!-- Submit 로그인버튼-->
			<button  type="submit" class="btn btn-outline-success btn-lg" >Sign in</button>
		  
			
			<div class="text-center">
			<!-- Register 회원가입 링크 -->
			  	<a href="#!">회원가입</a>
			  	<!-- id.password찾기 링크-->
				<a href="#!">아이디/비밀번호 찾기</a>
			</div>
			

		  </form>
</div>

<script src ="js/login.js"></script>