package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entity.PassengerTicket;

public interface PassengerTicketService {
	PassengerTicket findById(Long Id);

	List<PassengerTicket> findAll();

	PassengerTicket save(PassengerTicket passengerTicket);	

	boolean deleteById(Long Id);

	PassengerTicket savePassengerTicket(PassengerTicket passengerTicket);

	Boolean updatePassengerTicket(PassengerTicket passengerTicket);

	Boolean deletePassengerTicket(PassengerTicket passengerTicket);
}
