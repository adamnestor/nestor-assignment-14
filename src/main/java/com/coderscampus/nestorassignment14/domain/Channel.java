package com.coderscampus.nestorassignment14.domain;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	private static int idCounter = 0;
	private int id;
	private String name;
	private List<User> members;
	private List<Message> messages;

	public Channel(int id, String name) {
		this.id = generateUniqueId();
		this.name = name;
		this.members = new ArrayList<>();
		this.messages = new ArrayList<>();
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

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	// Methods

	
	public void addMember(User user) {
		members.add(user);
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}

	private synchronized int generateUniqueId() {
		return ++idCounter;
	}
}
