<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inTheForestLogin</title>
<link rel="stylesheet" href="css/login.css">

</head>
<body>
	<h2>로그인</h2>
    <form action= "#"  method = "POST">
		<fieldset>
			<ul>
				<li>
					<label for="u-id">아이디:</label>
					<input type="text" id="u-id" name="u-id" autofocus required>
				</li>
				<li>
					<label for="pw">비밀번호:</label>
					<input type="password" id="pw" name="pw" required>
				</li>
			</ul>
		</fieldset>
		<fieldset class="center">
			<button type="submit" class="btn btn-secondary">로그인</button>
			<button type="reset" class="btn btn-secondary">회원가입</button>
		</fieldset>
	</form>
</body>
</html>