package com.sunbeam.services;

import java.util.List;

import com.sunbeam.dto.StationDTO;
import com.sunbeam.entity.Station;

public interface StationService {
	Station findById(int Id);
	List<Station>findAll();
	Station save(Station station);
	boolean deleteById(int Id);
	Boolean saveStation(StationDTO stationDTO);
    Boolean updateStation(StationDTO stationDTO);
    Boolean deleteStation(StationDTO stationDTO);
}
