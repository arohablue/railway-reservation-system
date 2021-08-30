package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.Station;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StationDao extends JpaRepository<Station, Integer> {
	Station findById(Long Id);
	List<Station>findAll();
	Station save(Station station);
	void deleteById(Long Id);
}
