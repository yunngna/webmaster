<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inTheForestLogin</title>
<link rel="stylesheet" href="css/login.css">

</head>
<div class="container mx-auto">
	<div class="container-fluid">
		<form class="text-center">
			<!-- ID  -->
			<div data-mdb-input-init class="form-outline mb-4">
				<input type="text" id="MemId" class="form-control" placeholder="ID"/>
				<!-- <label class="form-label" for="MemId">Id:</label> -->
			</div>
		  
			<!-- Password -->
			<div data-mdb-input-init class="form-outline mb-4">
			  <input type="password" id="pw" class="form-control" placeholder="password" />
			  <!-- <label class="form-label" for="pw">Password:</label> -->
			</div>
		  
			<!-- 아이디기억하기 -->
			<div class="row mb-4">
			  <div class="col d-flex justify-content-center">
				<!-- Checkbox -->
				<div class="form-check">
				  <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
				  <label class="form-check-label" for="form2Example31"> 아이디기억하기</label>
				</div>
			  </div>
		  
			  <div class="col">
				<!-- id.password찾기 링크-->
				<a href="#!">비밀번호/아이디찾기</a>
			  </div>
			</div>
		  
			<!-- Submit 로그인버튼-->
			<button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-success btn-lg" >Sign in</button>
		  
			<!-- Register 회원가입 링크 -->
			<div class="text-center">
			  	<a href="#!">회원가입</a>
			</div>
		  </form>
	</div>
</div>

</html>