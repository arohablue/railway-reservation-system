package com.sunbeam.services;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.sunbeam.dao.PNRTableDao;
import com.sunbeam.dao.PassengerTicketDao;
import com.sunbeam.dao.TrainDao;
import com.sunbeam.dto.RevenueDTO;
import com.sunbeam.dto.TicketDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.PNRTable;
import com.sunbeam.entity.PassengerTicket;
import com.sunbeam.entity.Train;

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
            List<PassengerTicket> passengerTickets = passengerTicketDao.findByPnr(ticketDTO.getPnr());
            for (PassengerTicket passengerTicket : passengerTickets) {
                passengerTicket.setBookingStatus(ticketDTO.getStatus());
            }
            return true;
        }
        return false;
    }

    @Override
    public RevenueDTO getRevenue() {
        RevenueDTO revenueDTO = new RevenueDTO();
        Double totalRevenue = 0.0;
        Double acRevenue[] = new Double[11];
        Double genRevenue[] = new Double[11];
        Arrays.fill(acRevenue, 0.0);
        Arrays.fill(genRevenue, 0.0);
        List<PNRTable> pnrTables = pnrTableDao.findAllByPnrStatus("CONFIRMED");
        for (PNRTable pnrTable : pnrTables) {

            if (pnrTable.getPassengerTickets().size() > 0) {
                Train train = trainDao.findById(pnrTable.getPassengerTickets().get(0).getTrain().getId());

                Date date = train.getDepartureTime(); // the date instance
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int index = calendar.get(Calendar.MONTH);
                for (PassengerTicket ticket : pnrTable.getPassengerTickets()) {
                    if (ticket.getBookingClass().equals("AC")) {
                        acRevenue[index] = acRevenue[index]
                                + pnrTable.getPassengerTickets().size() * train.getRoute().getAcClassFair();
                        totalRevenue += train.getRoute().getAcClassFair() * pnrTable.getPassengerTickets().size();
                    } else {
                        genRevenue[index] = genRevenue[index]
                                + pnrTable.getPassengerTickets().size() * train.getRoute().getGeneralClassFair();
                        totalRevenue += train.getRoute().getGeneralClassFair() * pnrTable.getPassengerTickets().size();
                    }
                }
            }
        }
        revenueDTO.setAcRevenue(acRevenue);
        revenueDTO.setGenRevenue(genRevenue);
        revenueDTO.setTotalRevenue(totalRevenue);

        return revenueDTO;
    }

}
