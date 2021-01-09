package com.lti.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.UserController;
import com.lti.entity.User;

public class UserTest {

	@Test
	public void registerNewUser() {
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		UserController userController=context.getBean(UserController.class);
		
		User user = new User();
		user.setUserName("virat");
		user.setFirstName("Virat");
		user.setLastName("Kohli");
		user.setUserDateOfBirth(LocalDate.of(1998, 05, 05));
		user.setUserEmail("vir@gmail.com");
		user.setUserModile("8796541230");
		user.setUserPassword("123");
		
		userController.registerNewUser(user);
	}

}
