package com.sunbeam.dto;

import java.util.Date;

import com.sunbeam.entity.Route;

import org.springframework.beans.BeanUtils;

public class SearchTrainDTO {
	private StationDTO fromStation;
	private StationDTO toStation;
	private Date journeyDate;
	private String coachcClass;

	
	public SearchTrainDTO(StationDTO fromStation, StationDTO toStation, Date journeyDate, String coachcClass) {
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.journeyDate = journeyDate;
		this.coachcClass = coachcClass;
	}
	public StationDTO getFromStation() {
		return fromStation;
	}
	public void setFromStation(StationDTO fromStation) {
		this.fromStation = fromStation;
	}
	public StationDTO getToStation() {
		return toStation;
	}
	public void setToStation(StationDTO toStation) {
		this.toStation = toStation;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getCoachcClass() {
		return coachcClass;
	}
	public void setCoachcClass(String coachcClass) {
		this.coachcClass = coachcClass;
	}
	
}
