package com.lti.repository;

import com.lti.entity.User;

public interface UserRepository {

	long addAUser(User user);
	User findUserById(long userId);
}
