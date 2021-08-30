package com.sunbeam.services;

import java.util.List;
import java.util.stream.Stream;

import com.sunbeam.dto.StationDTO;
import com.sunbeam.entity.Station;

public interface StationService {
	Station findById(Long Id);
	List<Station>findAll();
	Station save(Station station);
	boolean deleteById(Long Id);
	Station saveStation(StationDTO stationDTO);
    Boolean updateStation(StationDTO stationDTO);
    Boolean deleteStation(StationDTO stationDTO);
    Stream<StationDTO> getSourceStations();
    Stream<StationDTO> getDestinationStations();
}
