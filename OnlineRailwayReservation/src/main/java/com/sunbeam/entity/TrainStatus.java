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
    private int id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date journeyDate;

    @Column(name = "available_seat_gen")
    private int availableSeatGen;

    @Column(name = "booked_seat_gen")
    private int bookedSeatGen;

    @Column(name = "available_seat_AC")
    private int availableSeatAC;

    @Column(name = "booked_seat_AC")
    private int bookedSeatAC;

	// Parent Relationships	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "train_id")
	private Train train;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public int getAvailableSeatGen() {
        return availableSeatGen;
    }

    public void setAvailableSeatGen(int availableSeatGen) {
        this.availableSeatGen = availableSeatGen;
    }

    public int getBookedSeatGen() {
        return bookedSeatGen;
    }

    public void setBookedSeatGen(int bookedSeatGen) {
        this.bookedSeatGen = bookedSeatGen;
    }

    public int getAvailableSeatAC() {
        return availableSeatAC;
    }

    public void setAvailableSeatAC(int availableSeatAC) {
        this.availableSeatAC = availableSeatAC;
    }

    public int getBookedSeatAC() {
        return bookedSeatAC;
    }

    public void setBookedSeatAC(int bookedSeatAC) {
        this.bookedSeatAC = bookedSeatAC;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

}