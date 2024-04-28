package com.coderscampus.nestorassignment14.respository;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.coderscampus.nestorassignment14.domain.User;

@Repository
public class UserRepository {
	
	private Set<User> users = new TreeSet<>();
	
	public User save (User user) {
		if (users.size() == 0) {
			user.setUserId(1L);
		} else {
			User lastUser = ((TreeSet<User>)users).last();
			user.setUserId(lastUser.getUserId() + 1L);
		}
		users.add(user);
		return user;
	}
	
}
