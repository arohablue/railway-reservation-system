package com.sunbeam.dto;

import java.util.Date;

import com.sunbeam.entity.Train;

import org.springframework.beans.BeanUtils;

public class TicketDTO {
    private TrainDTO train;
    private UserDTO user;
    private String pnr;
    private Date bookingDate;
    private Date reservationDate;
    private String status;

    
    public TicketDTO(TrainDTO train, UserDTO user, String pnr, Date bookingDate, Date reservationDate, String status) {
        this.train = train;
        this.user = user;
        this.pnr = pnr;
        this.bookingDate = bookingDate;
        this.reservationDate = reservationDate;
        this.status = status;
    }
    public TrainDTO getTrain() {
        return train;
    }
    public void setTrain(TrainDTO train) {
        this.train = train;
    }
    public UserDTO getUser() {
        return user;
    }
    public void setUser(UserDTO user) {
        this.user = user;
    }
    public String getPnr() {
        return pnr;
    }
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    public Date getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
}


