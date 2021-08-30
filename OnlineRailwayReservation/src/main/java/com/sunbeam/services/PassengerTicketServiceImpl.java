package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import com.sunbeam.dao.PNRTableDao;
import com.sunbeam.dao.PassengerTicketDao;
import com.sunbeam.dao.TrainDao;
import com.sunbeam.entity.PassengerTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class PassengerTicketServiceImpl implements PassengerTicketService {

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private PNRTableDao pnrTableDao;

    @Autowired
    private PassengerTicketDao passengerTicketDao;

    @Override
    public PassengerTicket findById(Long Id) {
        // TODO Auto-generated method stub
        return passengerTicketDao.findById(Id);
    }

    @Override
    public List<PassengerTicket> findAll() {
        // TODO Auto-generated method stub
        return passengerTicketDao.findAll();
    }

    @Override
    public PassengerTicket save(PassengerTicket passengerTicket) {
        // TODO Auto-generated method stub
        return passengerTicketDao.save(passengerTicket);
    }

    @Override
    public boolean deleteById(Long id) {
        passengerTicketDao.deleteById(id);
		if (passengerTicketDao.findById(id) == null) {
			return true;
		}
		return false;
    }

    @Override
    public PassengerTicket savePassengerTicket(PassengerTicket passengerTicket) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean updatePassengerTicket(PassengerTicket passengerTicket) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean deletePassengerTicket(PassengerTicket passengerTicket) {
        // TODO Auto-generated method stub
        return null;
    }

}
