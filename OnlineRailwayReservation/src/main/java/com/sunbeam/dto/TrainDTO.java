package com.sunbeam.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunbeam.dao.TrainStatusDao;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.TrainStatus;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainDTO {
	private Long trainId;
	private String trainName;
	private Integer trainNumber;
	private String trainType;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date departureTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date arrivalTime;
	private RouteDTO route;
	private Integer noOfSeatsGen;
	private Integer noOfSeatsAC;

	public TrainDTO() {
	}

	public TrainDTO(Long trainId, String trainName, String trainType, Integer noOfSeatsGen, Integer noOfSeatsAC,
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

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
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
		if (train.getRoute() != null) {
			tdto.setRoute(RouteDTO.fromEntity(train.getRoute()));
			tdto.setTrainId(train.getId());
		}
		return tdto;
		
	}

	public static Train toEntity(TrainDTO tdto) {
		Train train = new Train();
		BeanUtils.copyProperties(tdto, train);
		return train;
	}
}
