<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/dangky.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="../js/script-signup.js"></script>
<title>Sign Up</title>
</head>
<body>
<div class="all-signup">
				<p id="Title-Signup">Đăng Ký</p>
				<form>
					<input type="hidden" id="command" value="SIGNUP">
				<div class="text-signup">
					<p class="information">Tên tài khoản</p>
					<input class="text-input2" type="text" id="userName" placeholder="Tên tài khoản đăng ký">
					
		            <p class="information">Mật khẩu</p>
					<input class="text-input2" type="password" name="password" id="password" placeholder="Nhập mật khẩu">
					<p class="information">Xác nhận mật khẩu</p>
					<input class="text-input2" type="password" name="confirm_pass" 
					id="confirm_pass" onchange="checkPass()" placeholder="Xác nhận mật khẩu">
					
					<p id="missmatch" class="missmatch" style="color: red; margin-left: 100px"></p>
					<p class="information">Tên</p>
					<input class="text-input2" type="text" id="name" placeholder="Tên của bạn">
					<p class="information">Số điện thoại</p>
					<input class="text-input2" type="text" id="phone" onchange="checkPhone()" placeholder="Số điện thoại của bạn">
					<p id="phonemessage" class="missmatch" style="color: red; margin-left: 100px"></p>
					<p class="information">Email</p>
					<input class="text-input2" type="text" id="email" onchange="checkEmail()" placeholder="Email của bạn">
					<p id="emailmessage" class="missmatch" style="color: red; margin-left: 100px"></p>
					<p class="information">Địa chỉ</p>
					<input class="text-input2" type="text" id="address" placeholder="Địa chỉ của bạn">
					<p id="message" class="missmatch" style="color: red; margin-left: 100px"></p>
				</div>

				<div class="submit-signup">
					<input class="button-signup" type="button" value="ĐĂNG KÍ" id="submit">
				</div>
				</form>
				
		</div>
<script>
function checkEmail(){
    var email  = document.getElementById("email");
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
   if(!filter.test(email.value)){
   	 document.getElementById("emailmessage").innerHTML="Hãy nhập địa chỉ email hợp lệ (rocket@gmail.com)";
   	document.getElementById("submit").disabled = true;
   }
   else{
   	 document.getElementById("emailmessage").innerHTML="";
   	 document.getElementById("submit").disabled = false;
   }
}
function checkPhone(){
    var phone  = document.getElementById("phone");
    var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
   if(!vnf_regex.test(phone.value)){
   	 document.getElementById("phonemessage").innerHTML="Hãy nhập số điện thoại hợp lệ (0999888777)";
   	document.getElementById("submit").disabled = true;
   }
   else{
   	 document.getElementById("phonemessage").innerHTML="";
   	 document.getElementById("submit").disabled = false;
   }
}
</script>
</body>
</html>