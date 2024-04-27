package com.coderscampus.nestorassignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.nestorassignment14.domain.Channel;
import com.coderscampus.nestorassignment14.domain.Message;
import com.coderscampus.nestorassignment14.respository.ChannelRepository;
import com.coderscampus.nestorassignment14.respository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private ChannelRepository channelRepo;
	
	public Message saveMessage(Message message) {
		return messageRepo.save(message);
	}
	
	public List<Message> findMessagesByChannel(Long channelId){
		Channel channel = channelRepo.findByChannelId(channelId);
		return channel.getMessages();
		
	}
	
	public Long assignMessageId() {
		return messageRepo.generateMessageId();
	}
}
