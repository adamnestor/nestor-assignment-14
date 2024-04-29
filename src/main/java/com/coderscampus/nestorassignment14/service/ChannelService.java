package com.coderscampus.nestorassignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.nestorassignment14.domain.Channel;
import com.coderscampus.nestorassignment14.respository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;

	public Channel findById(Long channelId) {
		return channelRepo.findById(channelId);
	}

	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
}
