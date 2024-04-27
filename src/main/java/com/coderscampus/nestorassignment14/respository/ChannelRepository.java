package com.coderscampus.nestorassignment14.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.nestorassignment14.domain.Channel;

@Repository
public class ChannelRepository {

private List<Channel> channels = new ArrayList<>();
	
	public Channel save(Channel newChannel) {
		newChannel.setUsers(new ArrayList<>());
		newChannel.setMessages(new ArrayList<>());
		channels.add(newChannel);
		return newChannel;
	}
	
	public Channel findByChannelId(Long channelId) {
		for (Channel channel : channels) {
			if (channel.getChannelId().equals(channelId));
			return channel;
		}
		return null;
	}
	
	public List<Channel> findAll(){
		return channels;
	}
}
