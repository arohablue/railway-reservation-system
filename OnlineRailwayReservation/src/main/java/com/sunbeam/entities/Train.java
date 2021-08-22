package com.sunbeam.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import jdk.jfr.Timestamp;



@Entity 
@Table(name="train")
public class Train {
	@Id
	@Column(name="trainId")
	private int id ;
	private String trainName;
	private String trainType;
	private int classGen;
	private int classAC;
	@DateTimeFormat(pattern = "HH:MM:SS")
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	@DateTimeFormat(pattern = "HH:MM:SS")
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;
	private int routeId;
	public Train() {
	}
	public Train(int id, String trainName, String trainType, int classGen, int classAC, Date departureTime,
			Date arrivalTime, int routeId) {
		this.id = id;
		this.trainName = trainName;
		this.trainType = trainType;
		this.classGen = classGen;
		this.classAC = classAC;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.routeId = routeId;
	}
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
	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	public int getClassGen() {
		return classGen;
	}
	public void setClassGen(int classGen) {
		this.classGen = classGen;
	}
	public int getClassAC() {
		return classAC;
	}
	public void setClassAC(int classAC) {
		this.classAC = classAC;
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
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	@Override
	public String toString() {
		return "Train [id=" + id + ", trainName=" + trainName + ", trainType=" + trainType + ", classGen=" + classGen
				+ ", classAC=" + classAC + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", routeId=" + routeId + "]";
	}
	
	

}
