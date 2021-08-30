package com.sunbeam.services;

import java.util.List;

import com.sunbeam.dto.TrainDTO;
import com.sunbeam.entity.Train;

public interface TrainService {
	Train findById(Long Id);
	List<Train>findAll();
	Train save(Train train);
	boolean deleteById(Long Id);
	Train saveTrain(TrainDTO trainDTO);
    Boolean updateTrain(TrainDTO trainDTO);
    Boolean deleteTrain(TrainDTO trainDTO);
    Boolean searchTrain(TrainDTO trainDTO);
}
