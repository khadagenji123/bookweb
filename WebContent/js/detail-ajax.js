var count = 1;

function up() {
	if (count < 10) {
		count++;
		document.getElementById('up').innerHTML = count;
	}
}	
function down() {
	if (count > 1) {
		count--;
		document.getElementById('up').innerHTML = count;
	}
}

$(document).ready(function() {
	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");
	
	btn.onclick=(function() {
	
		$.ajax({
			type: 'POST',
			url : 'http://localhost:8080/bookweb/UserServlet',
			data : {
				command : $('#command').val(),
				amount : count,
				bookId : $('#bookId').val()
			},
			success : function(data) {
				if(data.userName == null){
					let modal = btn.getAttribute('data-modal');
		          document.getElementById(modal)
		            .style.display = "block";
				}
				else{
					window.location.href = 'http://localhost:8080/bookweb/BuyBook?command=BUY';
				}
			},
			error: function (error) {
				console.log(error)
			}
		});
	});
	let closeBtns = [...document.querySelectorAll(".close")];
      closeBtns.forEach(function(btn) {
        btn.onclick = function() {
          let modal = btn.closest('.modal');
          modal.style.display = "none";
        }
      });
      window.onclick = function(event) {
        if(event.target.className === "modal") {
          event.target.style.display = "none";
        }
      }
});


$(document).ready(function() {
	
	// Get the button that opens the modal
	var btnn = document.getElementById("myBtn1");

	
	btnn.onclick=(function() {
		$.ajax({
			type: 'POST',
			url : 'http://localhost:8080/bookweb/UserServlet',
			data : {
				command : $('#command1').val(),
				userName : $('#userName1').val(),
				password : $('#password1').val()
			},
			success : function(data) {
				if(data.checkUser==2){
					 window.location.href = 'http://localhost:8080/bookweb/BuyBook?command=BUY';
				}
				else{
					document.getElementById("missmatch").innerHTML="Mật khẩu nhập không đúng. Vui lòng nhập lại!";
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