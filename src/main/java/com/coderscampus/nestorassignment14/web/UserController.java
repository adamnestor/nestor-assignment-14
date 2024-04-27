package com.coderscampus.nestorassignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.nestorassignment14.domain.Channel;
import com.coderscampus.nestorassignment14.domain.User;
import com.coderscampus.nestorassignment14.service.ChannelService;
import com.coderscampus.nestorassignment14.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ChannelService channelService;
	
	@PostMapping("/createUser")
	@ResponseBody
	public User createNewUser(@RequestBody String username) {
		User user = new User(username);
		userService.saveUser(user);
		return user;
	}
	
	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {
		List<Channel> channels = channelService.findAll();
		model.put("channels", channels);
		return "welcome";
	}
}
