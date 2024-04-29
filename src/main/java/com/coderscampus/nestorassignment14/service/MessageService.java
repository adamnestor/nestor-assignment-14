package com.coderscampus.nestorassignment14.service;

import java.util.ArrayList;
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

	public List<Message> getMessages(Long channelId) {
		return messageRepo.getMessages(channelId).orElse(new ArrayList<>());
	}

	public void saveMessage(Message message) {
		Long channelId = message.getChannelId();
		Channel channel = channelRepo.findById(channelId);
        if (channel != null) {
            messageRepo.saveMessage(channelId, message);
        }
	}
}
