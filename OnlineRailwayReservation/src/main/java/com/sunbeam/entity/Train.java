package com.sunbeam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "train")
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "train_id")
	private int id;

	@Column(name = "train_name")
	private String trainName;

	@Column(name = "train_number")
	private String trainNumber;

	@Column(name = "train_type")
	private String trainType;

	@Column(name = "no_of_seats_gen")
	private int noOfSeatsGen;

	@Column(name = "no_of_seats_AC")
	private int noOfSeatsAC;

	@DateTimeFormat(pattern = "HH:MM:SS")
	@Temporal(TemporalType.TIME)
	@Column(name = "departure_time")
	private Date departureTime;

	@DateTimeFormat(pattern = "HH:MM:SS")
	@Temporal(TemporalType.TIME)
	@Column(name = "arrival_time")
	private Date arrivalTime;

	// Parent Relationships
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id")
	private Route route;

	// Child Relationships
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "train")
	@JsonIgnore
	private List<PassengerTicket> passengerTickets= new ArrayList<>();

	@OneToMany(mappedBy = "train", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<TrainStatus> trainStatus = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public int getNoOfSeatsGen() {
		return noOfSeatsGen;
	}

	public void setNoOfSeatsGen(int noOfSeatsGen) {
		this.noOfSeatsGen = noOfSeatsGen;
	}

	public int getNoOfSeatsAC() {
		return noOfSeatsAC;
	}

	public void setNoOfSeatsAC(int noOfSeatsAC) {
		this.noOfSeatsAC = noOfSeatsAC;
	}

	public List<TrainStatus> getTrainStatus() {
		return trainStatus;
	}

	public void setTrainStatus(List<TrainStatus> trainStatus) {
		this.trainStatus = trainStatus;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<PassengerTicket> getPassengerTickets() {
		return passengerTickets;
	}

	public void setPassengerTickets(List<PassengerTicket> passengerTickets) {
		this.passengerTickets = passengerTickets;
	}

}
