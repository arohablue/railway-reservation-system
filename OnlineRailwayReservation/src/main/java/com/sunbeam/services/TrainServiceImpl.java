package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import com.sunbeam.dao.TrainDao;
import com.sunbeam.dao.RouteDao;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.entity.Train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainDao trainDao;

	@Autowired
	private RouteDao routeDao;

	@Override
	public Train findById(Long Id) {
		return trainDao.findById(Id);
	}

	@Override
	public List<Train> findAll() {
		return trainDao.findAll();
	}

	@Override
	public Train save(Train train) {
		return trainDao.save(train);
	}

	@Override
	public boolean deleteById(Long Id) {
		return trainDao.deleteById(Id);
	}

	@Override
	public Train saveTrain(TrainDTO trainDTO) {
		Train train = TrainDTO.toEntity(trainDTO);
		if (trainDTO.getRoute().getRouteId() != null) {
			train.setRoute(routeDao.findById(trainDTO.getRoute().getRouteId()));
		}
		save(train);
		return train;
	}

	@Override
	public Boolean updateTrain(TrainDTO trainDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTrain(TrainDTO trainDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
