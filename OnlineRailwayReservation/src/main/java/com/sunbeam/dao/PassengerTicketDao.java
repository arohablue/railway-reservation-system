package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.PassengerTicket;
import com.sunbeam.entity.Train;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTicketDao extends JpaRepository<PassengerTicket, Integer> {
	PassengerTicket findById(Long Id);

	PassengerTicket findByPnr(String pnr);

	List<PassengerTicket> findAll();

	PassengerTicket save(PassengerTicket passengerTicket);

	boolean deleteById(Long Id);	
}
