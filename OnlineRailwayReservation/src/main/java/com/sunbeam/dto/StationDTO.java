package com.sunbeam.dto;

import com.sunbeam.entity.Station;

import org.springframework.beans.BeanUtils;

public class StationDTO {
	private int stationId;
	private String stationName;

	public StationDTO() {
	}

	public StationDTO(int stationId, String stationName) {
		this.stationId = stationId;
		this.stationName = stationName;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		return "StationDTO [id=" + stationId + ", stationName=" + stationName + "]";
	}

	public static StationDTO fromEntity(Station station) {
		StationDTO sdto = new StationDTO();
		BeanUtils.copyProperties(station, sdto);
		sdto.setStationId(station.getId());
		return sdto;
	}

	public static Station toEntity(StationDTO sdto) {
		Station station = new Station();
		BeanUtils.copyProperties(sdto, station);
		return station;
	}
}
