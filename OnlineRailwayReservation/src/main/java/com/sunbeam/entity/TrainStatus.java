package com.sunbeam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "train_status")
public class TrainStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_status_id")
    private Long id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date journeyDate;

    @Column(name = "available_seat_gen")
    private Integer availableSeatGen;

    @Column(name = "booked_seat_gen")
    private Integer bookedSeatGen;

    @Column(name = "available_seat_AC")
    private Integer availableSeatAC;

    @Column(name = "booked_seat_AC")
    private Integer bookedSeatAC;

	// Parent Relationships	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "train_id")
	private Train train;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Integer getAvailableSeatGen() {
        return availableSeatGen;
    }

    public void setAvailableSeatGen(Integer availableSeatGen) {
        this.availableSeatGen = availableSeatGen;
    }

    public Integer getBookedSeatGen() {
        return bookedSeatGen;
    }

    public void setBookedSeatGen(Integer bookedSeatGen) {
        this.bookedSeatGen = bookedSeatGen;
    }

    public Integer getAvailableSeatAC() {
        return availableSeatAC;
    }

    public void setAvailableSeatAC(Integer availableSeatAC) {
        this.availableSeatAC = availableSeatAC;
    }

    public Integer getBookedSeatAC() {
        return bookedSeatAC;
    }

    public void setBookedSeatAC(Integer bookedSeatAC) {
        this.bookedSeatAC = bookedSeatAC;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

}