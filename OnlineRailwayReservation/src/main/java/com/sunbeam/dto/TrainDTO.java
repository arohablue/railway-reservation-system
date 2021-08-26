package com.sunbeam.dto;

import java.util.Date;

import com.sunbeam.entity.Train;

import org.springframework.beans.BeanUtils;

public class TrainDTO {
	private int trainId;
	private String trainName;
	private String trainType;
	private int noOfClassGenSeats;
	private int noOfClassACSeats;
	private Date departureTime;
	private Date arrivalTime;
	private RouteDTO route;

	public TrainDTO() {
	}

	public TrainDTO(int trainId, String trainName, String trainType, int noOfClassGenSeats, int noOfClassACSeats,
			Date departureTime, Date arrivalTime, RouteDTO route) {
		this.trainId = trainId;
		this.trainName = trainName;
		this.trainType = trainType;
		this.noOfClassGenSeats = noOfClassGenSeats;
		this.noOfClassACSeats = noOfClassACSeats;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.route = route;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public int getNoOfClassGenSeats() {
		return noOfClassGenSeats;
	}

	public void setNoOfClassGenSeats(int noOfClassGenSeats) {
		this.noOfClassGenSeats = noOfClassGenSeats;
	}

	public int getNoOfClassACSeats() {
		return noOfClassACSeats;
	}

	public void setNoOfClassACSeats(int noOfClassACSeats) {
		this.noOfClassACSeats = noOfClassACSeats;
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

	public RouteDTO getRoute() {
		return route;
	}

	public void setRoute(RouteDTO route) {
		this.route = route;
	}

	public static TrainDTO fromEntity(Train train) {
		TrainDTO tdto = new TrainDTO();
		BeanUtils.copyProperties(train, tdto);
		tdto.setTrainId(train.getId());
		return tdto;
	}

	public static Train toEntity(TrainDTO tdto) {
		Train train = new Train();
		BeanUtils.copyProperties(tdto, train);
		train.setId(tdto.getTrainId());
		return train;
	}
}
