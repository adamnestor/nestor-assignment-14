let senderName = sessionStorage.getItem('username');
let senderId = sessionStorage.getItem('userId');
let channelId = sessionStorage.getItem('channelId');

checkIfUserExistsInSession();

function checkIfUserExistsInSession() {
	if (sessionStorage.getItem('username') === "null" || sessionStorage.getItem('username') === null) {
		return window.location.replace("http://localhost:8080/welcome")
	} else {
		console.log("User on channel: " + senderName);
		console.log("UserId of User on channel: " + senderId);
		console.log("Current Channel you are on: " + channelId);
	}
}

//SENDS MESSAGE WHEN "ENTER" IS PRESSED.
let messageToSend = document.getElementById("messageBox");
let chatBox = document.querySelector("#chatBox");

messageToSend.addEventListener('keydown', (event) => {
	if (event.key === "Enter") {
		event.preventDefault();
		sendMessage();
	}
});

function sendMessage() {
	let message = {
		sender: {
			userId: senderId,
			username: senderName
		},
		channel: channelId,
		messageBody: messageToSend.value.trim(),
	};

	if (message.messageBody !== '') {
		chatBox.innerHTML += '<p>' + '<strong>' + senderName + ": " + '</strong>' + message.messageBody + '</p>';
		messageToSend.value = '';
	}

	fetch(`/sendMessage/${channelId}`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(message)
	})
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
		});

}

//DISPLAYS NEW MESSAGES EVERY 500 MILLISECONDS
function fetchNewMessages() {
	let previousMessages = JSON.parse(localStorage.getItem("messages")) || [];
	fetch(`/getNewMessages/${channelId}`)
		.then((response) => response.json())
		.then((messages) => {
			let newMessages = messages.filter((message) => {
				return message.channelId == channelId;
			});

			if (newMessages.length > previousMessages?.length) {
				newMessages.forEach((message) => {
					let messageElement = document.createElement('p');
					messageElement.textContent = `${message.sender.username} : ${message.messageBody}`;
					chatBox.append(messageElement)
				})
			}

			localStorage.setItem("messages", JSON.stringify(newMessages));

		});
}
function renderMessages(newMessages) {
    chatBox.innerHTML = "";

    newMessages.forEach((message) => {
        if (message.sender && message.sender.username && message.messageBody) {
            let messageElement = document.createElement('p');
            messageElement.textContent = `${message.sender.username} : ${message.messageBody}`;
            chatBox.append(messageElement);
        } else {
            console.error("Invalid message format:", message);
        }
    });
}

setInterval(fetchNewMessages, 500);


document.addEventListener("DOMContentLoaded", () => {
	fetchAllMessages();
})

function fetchAllMessages(){
	fetch(`/getAllMessages/${channelId}`)
	.then((response) => response.json())
	.then((messages) => {
		renderMessages(messages)
		
		localStorage.setItem("messages", JSON.stringify(messages))
	})
}



//LOADS ALL NEW MESSAGES WHEN NEW USER JOINS PAGE
//document.addEventListener("DOMContentLoaded", () => {
//	fetchNewMessages();
//	let messagesFromLocalStorage = JSON.parse(localStorage.getItem("messages")) || [];
//
//	if (messagesFromLocalStorage.length > 0) {
//		renderMessages(messagesFromLocalStorage);
//	}
//
//});