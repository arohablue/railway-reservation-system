package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Station;

public interface StationDao extends JpaRepository<Station, Integer> {
	Station findById(int Id);
	List<Station>findAll();
	Station save(Station station);
	boolean deleteById(int Id);
}
