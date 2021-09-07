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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "train")
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "train_id")
	private Long id;

	@Column(name = "train_name")
	private String trainName;

	@Column(name = "train_number")
	private Integer trainNumber;

	@Column(name = "train_type")
	private String trainType;

	@Column(name = "no_of_seats_gen")
	private Integer noOfSeatsGen;

	@Column(name = "no_of_seats_AC")
	private Integer noOfSeatsAC;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "departure_time")
	private Date departureTime;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "arrival_time")
	private Date arrivalTime;

	// Parent Relationships
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "route_id")
	@JsonIgnore
	private Route route;

	// Child Relationships
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "train", orphanRemoval = true)
	@JsonIgnore
	private List<PassengerTicket> passengerTickets = new ArrayList<>();

	@OneToMany(mappedBy = "train", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<TrainStatus> trainStatus = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public Integer getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public Integer getNoOfSeatsGen() {
		return noOfSeatsGen;
	}

	public void setNoOfSeatsGen(Integer noOfSeatsGen) {
		this.noOfSeatsGen = noOfSeatsGen;
	}

	public Integer getNoOfSeatsAC() {
		return noOfSeatsAC;
	}

	public void setNoOfSeatsAC(Integer noOfSeatsAC) {
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
