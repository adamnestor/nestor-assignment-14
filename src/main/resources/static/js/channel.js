const textBox = document.querySelector("#textBox")

setInterval(getMessages, 500)

textBox.addEventListener('keyup', (e) => {
	if (e.keyCode === 13) {
		let message = {
			"text": textBox.value,
			"channelId": channelId,
			"user": user,
		}

//		let messageText = textBox.value
		textBox.value = ''
		fetch('/messages', {
			method: 'POST',
			headers: {
				'COntent-Type': 'applcation/json'
			},
			body: JSON.stringify(message)
		}).then(response => { getMessages() })
		return false
	}
})


function getMessages() {
	let messageDisplay = document.querySelector(".message-display")
	fetch(`/messages/${channelId}`)
		.then(response => response.json())
		.then(messages => {
			messageDisplay.innerHTML = ''
			messages.forEach(message => {
				messageDisplay.innerHTML += `<div>
			  <span class="sender">${message.user.name}: </span>
		  	  <span class="message">${message.text}</span>
			</div>`
			})
		})
}