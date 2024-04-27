package com.coderscampus.nestorassignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.nestorassignment14.domain.Channel;
import com.coderscampus.nestorassignment14.domain.User;
import com.coderscampus.nestorassignment14.service.ChannelService;
import com.coderscampus.nestorassignment14.service.UserService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@Autowired
	private UserService userService;

	@PostMapping("/createChannel")
	public Channel createNewChannel() {
		Channel channel = new Channel();
		channelService.saveChannel(channel);
		return channel;
	}

	@PostMapping("/joinOrCreateGeneralChannel")
	@ResponseBody
	public Channel joinOrCreateGeneralChannel(@RequestParam String username) {
		Channel existingChannel = channelService.findByChannelId(1L);

		if (existingChannel == null) {
			Channel newChannel = createNewChannel();
			newChannel.setChannelId(1L);
			User user = userService.findByUsername(username);
			newChannel.getUsers().add(user);
			return newChannel;

		} else {
			User user = userService.findByUsername(username);
			existingChannel.getUsers().add(user);
			return existingChannel;
		}
	}

	@PostMapping("/joinOrCreateChannel2")
	@ResponseBody
	public Channel joinOrCreateChannel2(@RequestParam String username) {
		Channel existingChannel = channelService.findByChannelId(2L);
		if (existingChannel == null) {
			Channel newChannel = createNewChannel();
			newChannel.setChannelId(2L);
			User user = userService.findByUsername(username);
			newChannel.getUsers().add(user);
			return newChannel;

		} else {
			User user = userService.findByUsername(username);
			existingChannel.getUsers().add(user);
			return existingChannel;
		}
	}

	@GetMapping("/channel/{channelId}")
	public String viewChannelByChannelId(@PathVariable Long channelId, ModelMap model) {
		Channel channel = channelService.findByChannelId(channelId);
		model.put("channel", channel);
		return "channel";
	}

	@PostMapping("/joinChannel/{channelId}")
	@ResponseBody
	public Channel joinChannel(@RequestBody Channel channelData, @PathVariable Long channelId) {
		Channel channel = channelData;

		if (channel == null) {
			System.out.println(channel);
		}
		return channel;
	}
}
