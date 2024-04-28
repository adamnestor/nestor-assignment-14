// Get user information from session storage
const senderName = sessionStorage.getItem('username');
const senderId = sessionStorage.getItem('userId');
const channelId = sessionStorage.getItem('channelId');


//Function to check if user exists in session
function checkIfUserExistsInSession() {
	if (!senderName) {
		window.location.replace("http://localhost:8080/welcome");
	} else {
		console.log("User on channel: " + senderName);
		console.log("UserId of User on channel: " + senderId);
		console.log("Current Channel you are on: " + channelId);
	}
}

checkIfUserExistsInSession();

//Function to send a message
function sendMessage() {
	const messageToSend = document.getElementById("messageBox").value.trim();

	if (messageToSend !== '') {
		const message = {
			sender: {
				userId: senderId,
				username: senderName
			},
			channel: channelId,
			messageBody: messageToSend
		};

		//Update UI with the sent message
		const chatBox = document.querySelector("#chatBox");
		chatBox.innerHTML += `<p><strong>${senderName}: </strong>${messageToSend}</p>`;

		//Clear message input
		document.getElementById("messageBox").value = '';

		// Send message to server
		fetch(`/sendMessage/${channelId}`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(message)
		})
			.then(response => response.json())
			.then(data => console.log(data))
			.catch(error => console.error('Error sending message:', error));
	}
}

// Function to handle keydown event (e.g., Enter key press) in message input field
function handleKeyDown(event) {
	if (event.key === "Enter") {
		event.preventDefault(); // Prevent default form submission behavior
		sendMessage(); // Call sendMessage() function
	}
}

// Add event listener for keydown event on message input field
document.getElementById("messageBox").addEventListener("keydown", handleKeyDown)

// Function to fetch and display all messages for the channel
function fetchAllMessages() {
    fetch(`/getAllMessages/${channelId}`)
        .then(response => response.json())
        .then(messages => {
            renderMessages(messages);
            localStorage.setItem("messages", JSON.stringify(messages));
        })
        .catch(error => console.error('Error fetching all messages:', error));
}

// Function to fetch and display new messages every 500 milliseconds
function fetchNewMessages() {
    let previousMessages = JSON.parse(localStorage.getItem("messages")) || [];
    fetch(`/getNewMessages/${channelId}`)
        .then(response => response.json())
        .then(messages => {
            let newMessages = messages.filter(message => message.channelId == channelId);

            if (newMessages.length > previousMessages?.length) {
                newMessages.forEach(message => {
                    let messageElement = document.createElement('p');
                    messageElement.textContent = `${message.sender.username} : ${message.messageBody}`;
                    chatBox.append(messageElement)
                })
            }

            localStorage.setItem("messages", JSON.stringify(newMessages));
        })
        .catch(error => console.error('Error fetching new messages:', error));
}

// Function to render messages in the chat box
function renderMessages(newMessages) {
    const chatBox = document.querySelector("#chatBox");
    chatBox.innerHTML = "";

    newMessages.forEach(message => {
        if (message.sender && message.sender.username && message.messageBody) {
            let messageElement = document.createElement('p');
            messageElement.textContent = `${message.sender.username} : ${message.messageBody}`;
            chatBox.append(messageElement);
        } else {
            console.error("Invalid message format:", message);
        }
    });
}

// Periodically fetch new messages every 500 milliseconds
setInterval(fetchNewMessages, 500);

// Fetch all messages when the page loads
document.addEventListener("DOMContentLoaded", fetchAllMessages);