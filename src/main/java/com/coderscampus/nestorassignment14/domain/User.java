package com.coderscampus.nestorassignment14.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private static int idCounter = 0;
	private int id;
	private String name;
	private Channel currentChannel;
	private List<Message> messagesSent;

	// Constructor
	public User(String name) {
		this.id = generateUniqueId();
		this.name = name;
		this.messagesSent = new ArrayList<>();
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Channel getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(Channel channel) {
		this.currentChannel = channel;
	}

	public List<Message> getMessagesSent() {
		return messagesSent;
	}

	// Methods
	
	public void sendMessage(Message message) {
		messagesSent.add(message);
	}
	
	private synchronized int generateUniqueId() {
		return ++idCounter;
	}
}
