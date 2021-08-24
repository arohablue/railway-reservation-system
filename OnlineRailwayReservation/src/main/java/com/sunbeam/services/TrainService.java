package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entity.Train;

public interface TrainService {
	Train findById(int Id);
	List<Train>findAll();
	Train save(Train train);
	boolean deleteById(int Id);
	
}
