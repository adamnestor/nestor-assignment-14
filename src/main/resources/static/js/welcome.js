// Create User and place in Session Storage

let username = sessionStorage.getItem('username')
let userId = sessionStorage.getItem('userId')

if (!username) {
	username = prompt("Enter your username: ")
	createUser()
} else {
	alert("Welcome back, " + username)
}


// Creates a user

function createUser() {
	fetch(`/createUser`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(username)
	})
		.then((response) => response.json())
		.then((data) => {
			userId = data.userId
			username = data.username
			sessionStorage.setItem('username', username)
			sessionStorage.setItem('userId', userId)
		})
}

// Creates general channel and joins it

function joinOrCreateGeneralChannel() {
	fetch(`/joinOrCreateGeneralChannel?username=` + username, {
		method: 'POST',
	})
		.then(response => response.json())
		.then(data => {
			const channelId = data.channelId
			sessionStorage.setItem('channelId', channelId)
			joinChannel(1)
		})
}

//Creates channel 2 and joins it
function joinOrCreateChannel2() {
	fetch(`/joinOrCreateChannel2?username=` + username, {
		method: 'POST',
	})
		.then(response => response.json())
		.then(data => {
			const channelId = data.channelId
			sessionStorage.setItem('channelId', channelId)
			joinChannel(2)
		});
}

// Join Channel

function joinChannel(channelId) {
	sessionStorage.setItem('channelId', channelId)
	const channelData = {
		channelId: channelId,
		users: [
			{ userId: userId, username: username }
		]
	}

	fetch(`/joinChannel/${channelId}`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(channelData)
	})
		.then((response) => response.json())
		.then((data) => {
			const channelId = channelData.channelId
			window.location.href = `/channel/${channelId}`
		})
}