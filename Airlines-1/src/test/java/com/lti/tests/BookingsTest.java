package com.lti.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.BookingsController;
import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Passanger;
import com.lti.entity.Ticket;
import com.lti.entity.User;

public class BookingsTest {

	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
	BookingsController bookingsController=context.getBean(BookingsController.class);
	@Test
	public void bookATicket() {
		double totalFare=0.0;
		Bookings booking= new Bookings();
		Passanger passanger= new Passanger();
		List<Passanger>passangerList= new ArrayList<Passanger>();
		List<Ticket>ticketList = new ArrayList<Ticket>();
		User user=bookingsController.findUserById(10001);
		Flight flight = bookingsController.findFlightById(40001);
		Ticket ticket = new Ticket();
		ticket.setSeatNumber(12);
		ticket.setSource("Chennai");
		ticket.setDestination("Mumbai");
		ticket.setFare(500);
		ticket.setFlight(flight);
		ticket.setPassanger(passanger);
		ticket.setBookings(booking);
		
		passanger.setPassangerName("Ram");
		passanger.setPassangerMobile("7896541230");
		passanger.setPassangerEmail("Ram@gmail.com");
		passanger.setPassangerAddress("Egmore");
		passanger.setTicket(ticket);
		passanger.setBookings(booking);
		
		totalFare=totalFare+ticket.getFare();
		
			
		ticketList.add(ticket);
		passangerList.add(passanger);
		
		ticket = new Ticket();
		ticket.setSeatNumber(12);
		ticket.setSource("Chennai");
		ticket.setDestination("Mumbai");
		ticket.setFare(2000);
		ticket.setFlight(flight);
		
		passanger= new Passanger();
		passanger.setPassangerName("Giri");
		passanger.setPassangerMobile("9996541230");
		passanger.setPassangerEmail("gi@gmail.com");
		passanger.setPassangerAddress("Guindy");
		passanger.setTicket(ticket);
		passanger.setBookings(booking);

		ticket.setPassanger(passanger);
		ticket.setBookings(booking);
		
		ticketList.add(ticket);
		passangerList.add(passanger);
		
		totalFare=totalFare+ticket.getFare();
		
		booking.setTotalFare(totalFare);
		booking.setPassanger(passangerList);
		booking.setTicket(ticketList);
		booking.setUser(user);
		bookingsController.bookATicket(booking);
			
	}
	
	@Test
	public void getBookingsByUserId() {
		User user = bookingsController.findUserById(10001);
		List<Bookings>bookings=user.getBookings();
		for(Bookings b : bookings) {
			System.out.println(b.getBookingId() + " " + b.getTotalFare());
		}
	}
	
	@Test
	public void getTicketsByBookingId() {
		Bookings booking = bookingsController.findTicketsByBookingId(50008);
		List<Ticket>tickets=booking.getTicket();
		for(Ticket t :tickets ) {
			System.out.println(t);
		}
	}
	
	@Test
	public void cancelTicket() {
		System.out.println( "Ticket Id " + bookingsController.cancelTicket(7015).getTicketId() + " has been successfully cancelled");
	}
	
	@Test
	public void searchFlight() {
		Flight flight=bookingsController.searchFlight(LocalDate.of(2021, 01, 02), "Chennai", "Mumbai");
		System.out.println(flight);
	}

}
