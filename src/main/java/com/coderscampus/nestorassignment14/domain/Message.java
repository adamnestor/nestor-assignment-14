package com.coderscampus.nestorassignment14.domain;

import java.time.Instant;

public class Message {

	private Long messageId;
	private User sender;
	private Long channelId;
	private String content;

	public Message(Long messageId, User sender, Long channelId, String content, Instant timestamp) {
		this.messageId = messageId;
		this.sender = sender;
		this.channelId = channelId;
		this.content = content;
	}

	// Getters and Setters

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
