package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.PassengerTicket;
import com.sunbeam.entity.Train;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTicketDao extends JpaRepository<PassengerTicket, Integer> {
	PassengerTicket findById(Long Id);

	List<PassengerTicket> findByPnr(String pnr);

	List<PassengerTicket> findAll();

	List<PassengerTicket> findAllByPnr(String pnr);

	PassengerTicket save(PassengerTicket passengerTicket);

	void deleteById(Long Id);
}
