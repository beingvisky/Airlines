package com.lti.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bookings;
import com.lti.entity.Cancellation;
import com.lti.entity.Flight;
import com.lti.entity.Ticket;
import com.lti.entity.User;


@Repository
public class BookingsRepositoryImpl implements BookingsRepository {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public long bookATicket(Bookings booking) {
		return em.merge(booking).getBookingId();
	}
	
	@Transactional
	public Ticket cancelTicket(long ticketId) {
		Ticket ticket=em.find(Ticket.class, ticketId);
		Cancellation cancellation = new Cancellation();
		cancellation.setTicketId(ticketId);
		cancellation.setRefundAmount(250);
		em.merge(cancellation);
		em.remove(ticket);
		return ticket;
	}
	
	public User findUserById(long userId) {
		return em.find(User.class, userId);
	}
	public Flight findFlightById(long flightId) {
		return em.find(Flight.class, flightId);
	}
	
	public Bookings findBookingsByBookingId(long bookingId) {
		return em.find(Bookings.class, bookingId);
	}
	
	public Flight searchFlight(LocalDate departureDate,String source,String destination) {
		String jpql="select f from Flight f where f.source=:sour and f.destination=:dest and f.departureDate=:date";
		TypedQuery<Flight>query=em.createQuery(jpql,Flight.class);
		query.setParameter("sour", source);
		query.setParameter("dest", destination);
		query.setParameter("date", departureDate);
		Flight flight=query.getSingleResult();
		return flight;
	}
	
	

}
