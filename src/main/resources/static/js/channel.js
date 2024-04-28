var textBox = document.querySelector("#textBox")

setInterval(getMessages, 500)

textBox.addEventListener('keydown', (e) => {
	if (e.key === "Enter") {
		console.log("Enter was pressed!!!")
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
				'Content-Type': 'application/json; charset=utf-8'
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
			  <span class="sender">${message.user.username}: </span>
		  	  <span class="message">${message.text}</span>
			</div>`
			})
		})
}