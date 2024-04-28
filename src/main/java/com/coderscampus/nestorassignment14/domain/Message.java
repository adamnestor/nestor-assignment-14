package com.coderscampus.nestorassignment14.domain;

public class Message {

	private String text;
	private Long channelId;
	private User user;
	
	
	// Getters and Setters
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
