package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.User;
import com.lti.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	public long registerNewUser(User user) {
		return userService.addAUser(user);
	}
	
	public User findUserById(long userId) {
		return userService.findUserById(userId);
	}
}
