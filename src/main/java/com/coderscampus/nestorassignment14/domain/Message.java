package com.coderscampus.nestorassignment14.domain;

import java.time.LocalDateTime;

public class Message {

	private static int idCounter = 0;
	private int id;
	private int userId;
	private String content;
	private LocalDateTime timestamp;

	public Message(int id, int userId, String content) {
		this.id = generateUniqueId();
		this.userId = userId;
		this.content = content;
		this.timestamp = LocalDateTime.now();
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	//Methods
	
	private synchronized int generateUniqueId() {
		return ++idCounter;
	}
}
