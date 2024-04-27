package com.coderscampus.nestorassignment14.domain;

import java.util.List;

public class Channel {

	private Long channelId;
	private List<User> users;
	private List<Message> messages;

	public Channel(Long channelId, List<User> users, List<Message> messages) {
		this.channelId = channelId;
		this.users = users;
		this.messages = messages;
	}
	
	public Channel() {}

	// Getters and Setters

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	
}
