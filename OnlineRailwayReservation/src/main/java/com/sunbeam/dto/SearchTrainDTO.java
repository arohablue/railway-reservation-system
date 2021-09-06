package com.sunbeam.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchTrainDTO {
	private StationDTO fromStation;
	private StationDTO toStation;
	private Date journeyDate;
	private String coachClass;

	
	public SearchTrainDTO() {
	}
	public SearchTrainDTO(StationDTO fromStation, StationDTO toStation, Date journeyDate, String coachClass) {
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.journeyDate = journeyDate;
		this.coachClass = coachClass;
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
	public String getCoachClass() {
		return coachClass;
	}
	public void setCoachClass(String coachClass) {
		this.coachClass = coachClass;
	}
	
}
