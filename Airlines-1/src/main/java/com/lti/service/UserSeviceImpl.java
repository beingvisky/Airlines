package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.User;
import com.lti.repository.UserRepository;

@Service
public class UserSeviceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	public long addAUser(User user) {
		
		return userRepository.addAUser(user);
	}
	
	public User findUserById(long userId) {
		return userRepository.findUserById(userId);
	}

}
