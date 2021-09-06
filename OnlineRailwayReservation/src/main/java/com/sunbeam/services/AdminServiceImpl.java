package com.sunbeam.services;

import javax.transaction.Transactional;

import com.sunbeam.dao.PNRTableDao;
import com.sunbeam.dao.PassengerTicketDao;
import com.sunbeam.dao.TrainDao;
import com.sunbeam.dto.RevenueDTO;
import com.sunbeam.dto.TicketDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.PassengerTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private PNRTableDao pnrTableDao;

    @Autowired
    private PassengerTicketDao passengerTicketDao;

    @Override
    public Boolean saveUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean updateUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean deleteUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean updateTicketStatus(TicketDTO ticketDTO) {
        if (passengerTicketDao.findByPnr(ticketDTO.getPnr()) != null) {
            PassengerTicket passengerTicket = passengerTicketDao.findByPnr(ticketDTO.getPnr());
            passengerTicket.setBookingStatus(ticketDTO.getStatus());
            return true;
        }
        return false;
    }

    @Override
    public RevenueDTO getRevenue() {
        // TODO Auto-generated method stub
        return null;
    }

}
