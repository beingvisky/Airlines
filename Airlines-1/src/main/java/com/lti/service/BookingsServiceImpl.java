package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Ticket;
import com.lti.entity.User;
import com.lti.repository.BookingsRepository;

@Service
public class BookingsServiceImpl implements BookingsService {

	
	@Autowired
	BookingsRepository bookingsRepository;
	public long bookATicket(Bookings booking) {
		
		return bookingsRepository.bookATicket(booking);
	}
	
	public User findUserById(long userId) {
		return bookingsRepository.findUserById(userId);
	}
	public Flight findFlightById(long flightId) {
		return bookingsRepository.findFlightById(flightId);
	}
	
	public Bookings findBookingsByBookingId(long bookingId) {
		return bookingsRepository.findBookingsByBookingId(bookingId);
	}
	
	public Ticket cancelTicket(long ticketId) {
		return bookingsRepository.cancelTicket(ticketId);
	}
	
	public Flight searchFlight(LocalDate departureDate,String source,String Destination) {
		return bookingsRepository.searchFlight(departureDate, source, Destination);
	}

}
