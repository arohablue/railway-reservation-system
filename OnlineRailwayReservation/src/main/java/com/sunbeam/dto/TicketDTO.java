package com.sunbeam.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunbeam.entity.PassengerTicket;

import org.springframework.beans.BeanUtils;

public class TicketDTO {
    private TrainDTO train;
    private UserDTO user;
    private String pnr;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date bookingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date reservationDate;
    private String status;
    private String bookingClass;
    private List<UserDTO> passengers;
    private String cardNumber;
    private String cardHolderName;
    private String cardExpiry;

    public TicketDTO() {
    }

    public TicketDTO(TrainDTO train, UserDTO user, String pnr, Date bookingDate, Date reservationDate, String status,
            String bookingClass, List<UserDTO> passengers) {
        this.train = train;
        this.user = user;
        this.pnr = pnr;
        this.bookingDate = bookingDate;
        this.reservationDate = reservationDate;
        this.status = status;
        this.bookingClass = bookingClass;
        this.passengers = passengers;
    }

    

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass) {
        this.bookingClass = bookingClass;
    }

    public List<UserDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<UserDTO> passengers) {
        this.passengers = passengers;
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

    public static TicketDTO fromEntity(PassengerTicket passengerTicket) {
        TicketDTO ticketDTO = new TicketDTO();
        BeanUtils.copyProperties(passengerTicket, ticketDTO);
        if (passengerTicket.getTrain() != null && passengerTicket.getPnrTable() != null
                && passengerTicket.getPnrTable().getUser() != null) {
            ticketDTO.setTrain(TrainDTO.fromEntity(passengerTicket.getTrain()));
            UserDTO user = new UserDTO();
            user.setUserId(passengerTicket.getPnrTable().getUser().getId());
            user.setAge(passengerTicket.getAge());
            user.setGender(passengerTicket.getGender());
            user.setName(passengerTicket.getName());
            user.setEmail(passengerTicket.getEmail());
            ticketDTO.setReservationDate(passengerTicket.getDate());
            ticketDTO.setBookingDate(passengerTicket.getBookingDate());
            ticketDTO.setBookingClass(passengerTicket.getBookingClass());
            ticketDTO.setStatus(passengerTicket.getBookingStatus());
            ticketDTO.setUser(user);
            ticketDTO.setTrain(TrainDTO.fromEntity(passengerTicket.getTrain()));
        }
        return ticketDTO;
    }

    public static TicketDTO toEntity(TicketDTO ticketDTO) {
        TicketDTO train = new TicketDTO();
        BeanUtils.copyProperties(ticketDTO, train);
        return train;
    }

}
