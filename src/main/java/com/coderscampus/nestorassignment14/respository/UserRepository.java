package com.coderscampus.nestorassignment14.respository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.coderscampus.nestorassignment14.domain.User;

@Component
public class UserRepository {

	List<User> users = new ArrayList<>();

	public User save(User user) {
		user.setUserId((long) (users.size() + 1));
		users.add(user);
		return user;
	}

}
