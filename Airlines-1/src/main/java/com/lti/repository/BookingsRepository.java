package com.lti.repository;

import java.time.LocalDate;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Ticket;
import com.lti.entity.User;

public interface BookingsRepository {
	long bookATicket(Bookings booking);
	User findUserById(long userId);
	Flight findFlightById(long flightId);
	Bookings findBookingsByBookingId(long bookingId);
	Ticket cancelTicket(long ticketId);
	Flight searchFlight(LocalDate departureDate,String source,String Destination);
}
