package com.lti.service;

import com.lti.entity.User;

public interface UserService {

	long addAUser(User user);
	User findUserById(long userId);
}
