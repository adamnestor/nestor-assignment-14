package com.coderscampus.nestorassignment14.domain;

public class User {

	private static Long idCounter = 1L;
	private Long userId;
	private String username;


	// Constructor
	public User(String name) {
		this.userId = generateUniqueId();
		this.username = name;
	}
	
	public User() {}

	// Getters and Setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	// Methods

	
	private static synchronized Long generateUniqueId() {
		return ++idCounter;
	}
}
