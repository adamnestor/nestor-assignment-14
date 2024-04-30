package com.coderscampus.nestorassignment14.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coderscampus.nestorassignment14.domain.Channel;

@Component
public class ChannelRepository {

	List<Channel> channels = new ArrayList<>();

	public ChannelRepository() {
		// Adding General Channel
		Channel generalChannel = new Channel();
		generalChannel.setChannelId(1L);
		generalChannel.setName("General");

		channels.add(generalChannel);

		//// Decided to add additional channels to test functionality of rending
		//// channels only to channels they were sent on. Now feeling the pressure to
		//// make a method to create new channels instead of hardcoding. Maybe a future
		//// refactoring.

		// Adding Coding Channel

		Channel codingChannel = new Channel();
		codingChannel.setChannelId(2L);
		codingChannel.setName("Coding");

		channels.add(codingChannel);

		// Adding Coding Channel
		Channel sportsChannel = new Channel();
		sportsChannel.setChannelId(3L);
		sportsChannel.setName("Sports");

		channels.add(sportsChannel);

	}

	public Channel findById(Long channelId) {
		return channels.stream().filter(channel -> channel.getChannelId().equals(channelId)).findFirst().orElse(null);
	}

	public List<Channel> findAll() {
		return channels;
	}
}
