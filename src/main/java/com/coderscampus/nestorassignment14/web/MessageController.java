package com.coderscampus.nestorassignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.nestorassignment14.domain.Channel;
import com.coderscampus.nestorassignment14.domain.Message;
import com.coderscampus.nestorassignment14.service.ChannelService;
import com.coderscampus.nestorassignment14.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ChannelService channelService;
	
	@PostMapping("/sendMessage/{channelId}")
	@ResponseBody
	public Message createNewMessage(@RequestBody Message message, @PathVariable Long channelId) {
		message = messageService.saveMessage(message);
		Channel channel = channelService.findByChannelId(channelId);
		channel.getMessages().add(message);
		return message;
	}
	
	@GetMapping("/getNewMessages/{channelId}")
	@ResponseBody
	public List<Message> getNewMessagesForChannel(@PathVariable Long channelId){
		Channel channel = channelService.findByChannelId(channelId);
		List<Message> messages = channel.getMessages();
		return messages;
	}
	
}
