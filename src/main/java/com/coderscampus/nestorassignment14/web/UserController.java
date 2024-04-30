package com.coderscampus.nestorassignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.nestorassignment14.domain.User;
import com.coderscampus.nestorassignment14.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/welcome")
	public User createUser(@RequestBody String username) {
		User user = userService.createUser(username);
		return user;
	}
}
