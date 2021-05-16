function category(){
	var theSelect = document.getElementById("mySelect").value;
	window.location.href = 'http://localhost:8080/bookweb/Category_Servlet?category='+theSelect;
}