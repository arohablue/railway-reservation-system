package com.sunbeam.dto;

import java.util.Date;

import com.sunbeam.entity.Train;

import org.springframework.beans.BeanUtils;

public class TrainDTO {
	private int trainId;
	private String trainName;
	private String trainType;
	private Date departureTime;
	private Date arrivalTime;
	private RouteDTO route;
	private Integer noOfSeatsGen;
	private Integer noOfSeatsAC;

	public TrainDTO() {
	}

	public TrainDTO(int trainId, String trainName, String trainType, int noOfSeatsGen, int noOfSeatsAC,
			Date departureTime, Date arrivalTime, RouteDTO route) {
		this.trainId = trainId;
		this.trainName = trainName;
		this.trainType = trainType;
		this.noOfSeatsGen = noOfSeatsGen;
		this.noOfSeatsAC = noOfSeatsAC;
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
		return train;
	}
}
