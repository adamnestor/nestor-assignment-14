package com.coderscampus.nestorassignment14.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public List<Message> getMessagesByChannel (Long channelId){
		return messageRepo.findMessagesByChannel(channelId).orElse(new ArrayList<>());
	}
	
	public void addMessageToChannel(Message message) {
		Optional<Channel> channelOpt = channelRepo.findById(message.getChannelId());
		if (channelOpt.isPresent()) {
			List<Message> messagesByChannel = getMessagesByChannel(message.getChannelId());
			messageRepo.saveMessagesByChannel(message.getChannelId(), messagesByChannel);
		}
	}
}
