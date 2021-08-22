package com.sunbeam.dtos;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.sunbeam.entities.Train;


public class TrainDTO {
	private int id ;
	private String trainname;
	private String traintype;
	private int classgen;
	private int classac;
	private Date departuretime;
	private Date arrivaltime;
	private int routeid;
	public TrainDTO() {
	}
	public TrainDTO(int id, String trainname, String traintype, int classgen, int classac, Date departuretime,
			Date arrivaltime, int routeid) {
		this.id = id;
		this.trainname = trainname;
		this.traintype = traintype;
		this.classgen = classgen;
		this.classac = classac;
		this.departuretime = departuretime;
		this.arrivaltime = arrivaltime;
		this.routeid = routeid;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	public String getTraintype() {
		return traintype;
	}
	public void setTraintype(String traintype) {
		this.traintype = traintype;
	}
	public int getClassgen() {
		return classgen;
	}
	public void setClassgen(int classgen) {
		this.classgen = classgen;
	}
	public int getClassac() {
		return classac;
	}
	public void setClassac(int classac) {
		this.classac = classac;
	}
	public Date getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(Date departuretime) {
		this.departuretime = departuretime;
	}
	public Date getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(Date arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	public static TrainDTO fromEntity(Train train) {
		TrainDTO tdto = new TrainDTO();
		BeanUtils.copyProperties(train, tdto);
		tdto.setId(train.getId());
		return tdto;
	}
	
	public static Train toEntity(TrainDTO tdto) {
		Train train = new Train();
		BeanUtils.copyProperties(tdto, train);
		train.setId(tdto.getId());
		return train;
	}
}
