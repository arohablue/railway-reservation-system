package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Station;

public interface StationService {
	Station findById(int Id);
	List<Station>findAll();
	Station save(Station station);
	boolean deleteById(int Id);
}
