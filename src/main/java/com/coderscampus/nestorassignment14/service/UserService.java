package com.coderscampus.nestorassignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.nestorassignment14.domain.User;
import com.coderscampus.nestorassignment14.respository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User createUser(String username) {
		User user = new User();
		user.setUsername(username);
		return userRepo.save(user);
	}
}
