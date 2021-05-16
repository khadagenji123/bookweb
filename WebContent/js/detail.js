var btn = document.getElementById("myBtn");
btn.onclick=function(){

	var resultTag = document.getElementById('result');
	var cookies = document.cookie;
	if(cookies == ""){
		resultTag.innerHTML = 'chua co cookie';
	}
	else{
		resultTag.innerHTML = cookies;
	}
	resultTag.innerHTML = cookies;
	let modal = btn.getAttribute('data-modal');
	  document.getElementById(modal)
	    .style.display = "block";
	
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
}