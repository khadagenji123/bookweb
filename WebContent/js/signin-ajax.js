$(document).ready(function() {
	
	// Get the modal
	var modal = document.getElementById("myModal"); 
	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	
	btn.onclick=(function() {
		$.ajax({
			type: 'POST',
			url : 'http://localhost:8080/bookweb/UserServlet',
			data : {
				command : $('#command').val(),
				userName : $('#userName').val(),
				password : $('#password').val()
			},
			success : function(data) {
				if(data.checkUser==1){
					 window.location.href = 'http://localhost:8080/bookweb/view/admin.jsp';
				}
				else if(data.checkUser==2){
					window.location.href = 'http://localhost:8080/bookweb/HomePage';
				}
				else{
					modal.style.display = "block";
					 document.getElementById("message").innerHTML = `Tài khoản hoặc mật khẩu 
					 không chính xác, xin vui lòng nhập lại!`;
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