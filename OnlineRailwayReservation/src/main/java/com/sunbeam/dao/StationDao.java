package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.Station;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StationDao extends JpaRepository<Station, Integer> {
	Station findById(int Id);
	List<Station>findAll();
	Station save(Station station);
	boolean deleteById(int Id);
}
