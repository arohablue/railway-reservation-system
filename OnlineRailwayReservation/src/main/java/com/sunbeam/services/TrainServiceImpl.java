package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import com.sunbeam.dao.TrainDao;
import com.sunbeam.dao.TrainStatusDao;
import com.sunbeam.dao.RouteDao;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.TrainStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainDao trainDao;

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private TrainStatusDao trainStatusDao;

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
	public boolean deleteById(Long id) {
		trainDao.deleteById(id);
		if (trainDao.findById(id) == null) {
			return true;
		}
		return false;
	}

	@Override
	public Train saveTrain(TrainDTO trainDTO) {
		Train train = TrainDTO.toEntity(trainDTO);
		if (trainDTO.getRoute().getRouteId() != null) {
			train.setRoute(routeDao.findById(trainDTO.getRoute().getRouteId()));
		}
		TrainStatus trainStatus = new TrainStatus();
		save(train);
		trainStatus.setTrain(train);
		trainStatus.setAvailableSeatAC(trainDTO.getNoOfSeatsAC());
		trainStatus.setAvailableSeatGen(trainDTO.getNoOfSeatsGen());
		trainStatus.setJourneyDate(trainDTO.getDepartureTime());
		trainStatusDao.save(trainStatus);
		return train;
	}

	@Override
	public Boolean updateTrain(TrainDTO trainDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean searchTrain(TrainDTO trainDTO) {

		return null;
	}

	@Override
	public Boolean deleteTrain(TrainDTO trainDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
