package com.coderscampus.nestorassignment14.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderscampus.nestorassignment14.domain.User;
import com.coderscampus.nestorassignment14.respository.UserRepository;

@Controller
public class WelcomeController {

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "welcome";
	}

	@PostMapping("/join")
	public String joinChannel(@RequestParam("username") String username, 
							  @RequestParam("channelId") int channelId,
							  ModelMap model) {
		// Check if the username is empty or null
		if (username == null || username.trim().isEmpty()) {
			return "redirect:/";
		}
		
		//Logic to check if the user is unique
		List<User> existingUsers = UserRepository.getAllUsers();
		
		boolean usernameExists = existingUsers.stream().anyMatch(user -> user.getName().equalsIgnoreCase(username));
		
		if (usernameExists) {
			model.addAttribute("errorMessage", "Username is already taken. Please choose another one.");
			return "redirect:/";
		}
		
		//Logic to join the channel
		model.addAttribute("username", username);
		model.addAttribute("channelId", channelId);
		return "redirect:/channels/" + channelId;
	}
}
