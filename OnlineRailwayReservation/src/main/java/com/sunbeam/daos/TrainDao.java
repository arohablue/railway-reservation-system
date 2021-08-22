package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Train;
import com.sunbeam.entities.User;

public interface TrainDao extends JpaRepository<Train, Integer>{
	Train findById(int Id);
	List<Train>findAll();
	Train save(Train train);
	boolean deleteById(int Id);
	
}
