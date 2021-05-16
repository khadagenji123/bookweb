function checkPass(){
         var pass  = document.getElementById("password").value;
         var confirm_pass  = document.getElementById("confirm_pass").value;
        if(pass != confirm_pass){
            document.getElementById("submit").disabled = true;
            document.getElementById("missmatch").innerHTML="Mật khẩu nhập không đúng. Vui lòng nhập lại!";
        }else{
        	document.getElementById("missmatch").innerHTML="";
            document.getElementById("submit").disabled = false;
        }
}

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

$(document).ready(function() {
	
	var btn = document.getElementById("submit");
	btn.onclick=(function() {
		$.ajax({
			type: 'POST',
			url : 'http://localhost:8080/bookweb/UserServlet',
			data : {
				command : $('#command').val(),
				userName : $('#userName').val(),
				password : $('#password').val(),
				name : $('#name').val(),
				phone : $('#phone').val(),
				address : $('#address').val(),
				email : $('#email').val()
			},
			success : function(data) {
				if(data.message=='null'){
					 document.getElementById("message").innerHTML="Phải điền đầy đủ thông tin!";
				}
				else if(data.checkUserName == true){
					 document.getElementById("message").innerHTML="Đã tồn tại tài khoản này!";
				}
				else{
					 document.getElementById("message").innerHTML="OK!";
					 window.location.href = ' http://localhost:8080/bookweb/view/signin.jsp';
				}
			},
			error: function (error) {
				console.log(error)
			}
		});
	});
	span.onclick = function() {
		 modal.style.display = "none";
	 }
	 window.onclick = function(event) {
		 if (event.target == modal) {
		 modal.style.display = "none";
		 }
	 }
});