var textBox = document.querySelector(`#textBox`)
var user = JSON.parse(sessionStorage.getItem('user'))
var channelId = textBox.getAttribute('data-id')


function sendMessage(){
	var message = {
		'channelId': channelId,
		'messageText': textBox.value,
		'user': user,
	}
	textBox.value = ''
	fetch('/message', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(message)
	})
	.then(response => response.json())
	.then(data => {
		console.log(data)
	})
}

textBox.addEventListener('keydown', function(e){
	if (e.key === 'Enter'){
		e.preventDefault()
		sendMessage();
	}
})

setInterval(getMessages, 500)

function getMessages(){
	var messagesDisplay = document.querySelector('#messagesDisplay')
	fetch(`/messages/${channelId}`)
	.then(response => response.json())
	.then(data => {
		messagesDisplay.innerHTML = ''
		data.forEach(message => {
			messagesDisplay.innerHTML += `<div>
			  <span><b>${message.user.username}</b>: ${message.messageText}</span>
			</div>`
		})
	})
}