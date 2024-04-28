package com.coderscampus.nestorassignment14.respository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.coderscampus.nestorassignment14.domain.Channel;

@Repository
public class ChannelRepository {

	private List<Channel> channels = new ArrayList<>();

	public ChannelRepository() {
		Channel general = new Channel();
		general.setChannelId(1L);
		general.setName("General");

		channels.add(general);
	}

	public Optional<Channel> findById(Long channelId) {
		return channels.stream().filter(channel -> channel.getChannelId().equals(channelId)).findAny();
	}

	public List<Channel> findAll() {
		return channels;
	}
}
