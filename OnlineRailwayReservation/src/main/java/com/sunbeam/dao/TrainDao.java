package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.Train;
import com.sunbeam.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainDao extends JpaRepository<Train, Integer> {
	Train findById(Long Id);

	List<Train> findAll();

	Train save(Train train);

	void deleteById(Long id);

	List<Train> findByTrainNumber(Integer trainNumber);
}
