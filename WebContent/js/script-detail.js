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