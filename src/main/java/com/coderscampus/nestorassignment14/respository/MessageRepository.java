package com.coderscampus.nestorassignment14.respository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coderscampus.nestorassignment14.domain.Message;

@Component
public class MessageRepository {

	private Map<Long, List<Message>> messages = new HashMap<>();

	public Optional<List<Message>> getMessages(Long channelId) {
		List<Message> messagesByChannel = messages.get(channelId);
		return Optional.ofNullable(messagesByChannel);
	}

	public void saveMessage(Long channelId, Message message) {
		List<Message> messagesInChannel = messages.getOrDefault(channelId, new ArrayList<>());
		messagesInChannel.add(message);
		messages.put(channelId, messagesInChannel);
	}
}
