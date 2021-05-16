<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/signin.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script type="text/javascript" src="../js/signin-ajax.js"></script>
<title>Sign in</title>
</head>
<body>
	<div class="all-login">
		<form>
			<input type="hidden" id="command" value="SIGNIN">
			<p id="Title-Login">Đăng Nhập</p>
			<div class="text-login">
				<p class="information">Tên đăng nhập</p>
				<input class="text-input" type="text" id="userName" placeholder="Tên tài khoản">
	            <p class="information">Mật khẩu</p>
				<input class="text-input" type="password" id="password" placeholder="Mật khẩu">
			</div>	

			<div class="submit-login">
			 	<input class="button-login" type="button" id="myBtn" value="ĐĂNG NHẬP"> 
			 	<div id="myModal" class="modal">
					<!-- Modal content -->
					<div class="modal-content">
						<span class="close">&times;</span>
						<p id="message"></p>
					</div>
				</div>
				<p id="exam">-hoặc-</p>
				<a 	id="sign-up" href="dangky.jsp">Đăng ký tài khoản</a>
			</div>
		</form>
		
	</div>
	
	
	

		
</body>
</html>