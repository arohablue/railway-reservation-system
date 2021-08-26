package com.sunbeam.services;

import java.util.List;

import com.sunbeam.dto.TrainDTO;
import com.sunbeam.entity.Train;

public interface TrainService {
	Train findById(int Id);
	List<Train>findAll();
	Train save(Train train);
	boolean deleteById(int Id);
	Boolean saveTrain(TrainDTO trainDTO);
    Boolean updateTrain(TrainDTO trainDTO);
    Boolean deleteTrain(TrainDTO trainDTO);
}
