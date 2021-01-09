package com.lti.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Ticket;
import com.lti.entity.User;
import com.lti.service.BookingsService;

@Controller
public class BookingsController {

	@Autowired
	BookingsService bookingsService;
	public long bookATicket(Bookings booking) {
		return bookingsService.bookATicket(booking);
	}
	
	public User findUserById(long userId) {
		return bookingsService.findUserById(userId);
	}
	public Flight findFlightById(long flightId) {
		return bookingsService.findFlightById(flightId);
	}
	
	public Bookings findTicketsByBookingId(long bookingId) {
		return bookingsService.findBookingsByBookingId(bookingId);
	}
	
	public Ticket cancelTicket(long ticketId) {
		return bookingsService.cancelTicket(ticketId);
	}
	
	public Flight searchFlight(LocalDate departureDate,String source,String Destination) {
		return bookingsService.searchFlight(departureDate, source, Destination);
	}
}
