<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/style-login-again.css" type="text/css">
<title>Wrong login</title>
</head>
<body>
	<a href="HomePage">Trang chủ</a>
	<form action="../UserServlet" method="post">
		<input type="hidden" name="command" value="SIGNIN" >
	    <h2>Đăng nhập sai! Vui lòng đăng nhập lại để tiếp tục</h2>
	    <div>
	      <input type="text" name="userName" placeholder="Tài khoản">
	      <br>
	      <input type="password" name="password" placeholder="Mật khẩu">
	    </div>
	    <button type="submit" class="submit">Submit</button>
	</form>
</body>
</html>