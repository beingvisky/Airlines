package com.lti.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.AdminController;
import com.lti.controller.UserController;
import com.lti.entity.Flight;

public class AdminTest {

	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
	AdminController adminController=context.getBean(AdminController.class);
	@Test
	public void addAFlight() {
		Flight flight = new Flight();
		flight.setNoOfSeats(50);
		flight.setSource("Chennai");
		flight.setDestination("Delhi");
		flight.setDepartureDate(LocalDate.now());
		long number=adminController.addAFlight(flight);
		System.out.println("Flight Number " + number + " has been added");
	}
	
	@Test
	public void removeAFlight() {
		Flight flight= adminController.removeAFlight(40022);
		System.out.println(flight.getFlightId() + " has been removed");
	}
	

}
