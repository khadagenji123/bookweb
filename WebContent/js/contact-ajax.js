$(document).ready(function() {
	

// Get the modal
var modal = document.getElementById("myModal"); 

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// When the user clicks the button, open the modal

// btn.onclick = function() {
// modal.style.display = "block";
// var email = document.getElementById("email").value;
// document.getElementById("popup_show_email").innerHTML = `Chúng tối sẽ phản
// hồi sớm nhất qua email: ${email}`;
// }

// When the user clicks on <span> (x), close the modal
// span.onclick = function() {
// modal.style.display = "none";
// }
//
// // When the user clicks anywhere outside of the modal, close it
// window.onclick = function(event) {
// if (event.target == modal) {
// modal.style.display = "none";
// }
// }
	btn.onclick=(function() {
		$.ajax({
			type: 'POST',
			url : 'http://localhost:8080/bookweb/ContactServlet',
			data : {
				command : $('#command').val(),
				name : $('#name').val(),
				email : $('#email').val(),
				subject : $('#subject').val(),
				message : $('#message').val()
			},
			success : function(responseText) {
				modal.style.display = "block";
				 var email = document.getElementById("email").value;
				 document.getElementById("popup_show_email").innerHTML = `Chúng tối sẽ phản hồi sớm nhất 
				 qua email: ${email}`;
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
