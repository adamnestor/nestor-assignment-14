package com.coderscampus.nestorassignment14.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.nestorassignment14.domain.Channel;
import com.coderscampus.nestorassignment14.domain.Message;

@Repository
public class MessageRepository {

	private List<Message> messages = new ArrayList<>();
	
	public Message save(Message message) {
		message.setMessageId(generateMessageId());
		messages.add(message);
		return message;
	}
	
	public List<Message> findMessagesByChannelId(Channel channelId){
		return messages;
	}
	
	public synchronized Long generateMessageId() {
		return messages.size() + 1L;
	}
}
