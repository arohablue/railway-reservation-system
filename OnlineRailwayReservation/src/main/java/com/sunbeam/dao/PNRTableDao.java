package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.PNRTable;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.TrainStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PNRTableDao extends JpaRepository<PNRTable, Integer> {
	PNRTable findById(Long Id);

	List<PNRTable> findAll();

	PNRTable save(PNRTable pnrTable);

	boolean deleteById(Long Id);
}