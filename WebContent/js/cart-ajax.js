$(document).ready(function() {
	
	// Get the modal
	var modal = document.getElementById("myModal"); 
	// Get the button that opens the modal
	var btn = document.getElementById("payment");
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	
	btn.onclick=(function() {
		$.ajax({
			type: 'POST',
			url : 'http://localhost:8080/bookweb/BuyBook',
			data : {
				command : $('#command').val(),
				name : $('#name').val(),
				address : $('#address').val(),
				phone :$('#phone').val()
			},
			success : function(data) {
				if(data.message=='null'){
					 modal.style.display = "block";
					 document.getElementById("message").innerHTML = `Phải điền đầy đủ thông tin!`;
				}
				else{
					modal.style.display = "block";
					 document.getElementById("message").innerHTML = `Đã đặt hàng và thanh toán thành công!`;
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