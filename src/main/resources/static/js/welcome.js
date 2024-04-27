const username = document.querySelector('#username')
const welcomeForm = document.querySelector('#welcomeForm')


function askForName(){
	const username = prompt("Please enter your name:")
	if (username === null || username.trim() === ""){
		askForName();
	} else {
		username.value = username;
		welcomeForm.submit();
	}
}

window.onload = function(){
	askForName();
}