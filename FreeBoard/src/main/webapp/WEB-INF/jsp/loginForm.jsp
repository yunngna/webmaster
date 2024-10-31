<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include> 

<%
	String msg = (String) request.getAttribute("msg");
%>

<%if(msg != null){%>
<p style ="color:red;"> <%=msg%></p>	
<%}%>


<h3>로그인 화면(loginForm.jsp)</h3>
<form action= "loginForm.do"  method = "POST">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="logId"></td>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="logPw"></td>
		<tr>
			<td colspan="2" class="text-center">
				<button type="submit" class="btn btn-secondary">로그인</button>
			</td>
		</tr>
	</table>
</form>












<jsp:include page="../includes/footer.jsp"></jsp:include>
