package com.sunbeam.dao;

import java.util.Date;
import java.util.List;

import com.sunbeam.entity.Train;
import com.sunbeam.entity.TrainStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainStatusDao extends JpaRepository<TrainStatus, Integer> {
	TrainStatus findById(Long Id);

	TrainStatus findByTrainAndJourneyDate(Train train, Date journeyDate);

	List<TrainStatus> findAll();

	TrainStatus save(TrainStatus trainStatus);

	boolean deleteById(Long Id);
}
