package com.sunbeam.dto;

import com.sunbeam.entity.Station;

import org.springframework.beans.BeanUtils;


public class StationDTO {
	private int id ;
	private String stationName;
	public StationDTO() {
	}
	public StationDTO(int id, String stationName) {
		this.id = id;
		this.stationName = stationName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	@Override
	public String toString() {
		return "StationDTO [id=" + id + ", stationName=" + stationName + "]";
	}
	
	public static StationDTO fromEntity(Station station) {
		StationDTO sdto = new StationDTO();
		BeanUtils.copyProperties(station, sdto);
		sdto.setId(station.getId());
		return sdto;
	}
	
	public static Station toEntity(StationDTO sdto) {
		Station station = new Station();
		BeanUtils.copyProperties(sdto, station);
		return station;
	}
}
