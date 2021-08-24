package com.sunbeam.dto;

import com.sunbeam.entity.Station;

import org.springframework.beans.BeanUtils;


public class StationDTO {
	private int id ;
	private String stationname;
	public StationDTO() {
	}
	public StationDTO(int id, String stationname) {
		this.id = id;
		this.stationname = stationname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	@Override
	public String toString() {
		return "StationDTO [id=" + id + ", stationname=" + stationname + "]";
	}
	
//	public static StationDTO fromEntity(Station station) {
//		StationDTO sdto = new StationDTO();
//		BeanUtils.copyProperties(station, sdto);
//		sdto.setId(station.getId());
//		return sdto;
//	}
	
//	public static Station toEntity(StationDTO sdto) {
//		Station station = new Station();
//		BeanUtils.copyProperties(sdto, station);
//		station.setId(sdto.getId());
//		return station;
//	}
}
