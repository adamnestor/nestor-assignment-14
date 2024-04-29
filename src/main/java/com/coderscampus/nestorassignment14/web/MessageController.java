package com.coderscampus.nestorassignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.nestorassignment14.domain.Message;
import com.coderscampus.nestorassignment14.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/messages/{channelId}")
	public List<Message> getMessages(@PathVariable Long channelId){
		List<Message> messages = messageService.getMessages(channelId);
		return messages;
	}
	
	@PostMapping("/message")
	public Message postMessage(@RequestBody Message message) {
		messageService.saveMessage(message);
		return message;
	}
	
}
