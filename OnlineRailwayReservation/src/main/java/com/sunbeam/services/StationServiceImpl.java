package com.sunbeam.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import com.sunbeam.dao.RouteDao;
import com.sunbeam.dao.StationDao;
import com.sunbeam.dao.TrainDao;
import com.sunbeam.dto.StationDTO;
import com.sunbeam.entity.Station;
import com.sunbeam.entity.Train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private StationDao stationDao;

	@Autowired
	private TrainDao trainDao;

	@Autowired
	private RouteDao routeDao;

	@Override
	public Station findById(Long Id) {
		// TODO Auto-generated method stub
		return stationDao.findById(Id);
	}

	@Override
	public List<Station> findAll() {
		// TODO Auto-generated method stub
		return stationDao.findAll();
	}

	@Override
	public Station save(Station station) {
		// TODO Auto-generated method stub
		return stationDao.save(station);
	}

	// Not working write another
	@Override
	public boolean deleteById(Long id) {
		stationDao.deleteById(id);
		if (stationDao.findById(id) == null) {
			return true;
		}
		return false;
	}

	@Override
	public Station saveStation(StationDTO stationDTO) {
		Station station = StationDTO.toEntity(stationDTO);
		save(station);
		return null;
	}

	@Override
	public Boolean updateStation(StationDTO stationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteStation(StationDTO stationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<StationDTO> getSourceStations() {
		Set<Station> stations = new HashSet<Station>();
		List<Train> trains = trainDao.findAll();
		if (trains.size() > 0) {
			for (Train train : trains) {
				stations.add(train.getRoute().getSourceStation());
			}
		}
		Stream<StationDTO> result = stations.stream().map(station -> StationDTO.fromEntity(station));
		return result;
	}

	@Override
	public Stream<StationDTO> getDestinationStations() {
		Set<Station> stations = new HashSet<Station>();
		List<Train> trains = trainDao.findAll();
		if (trains.size() > 0) {
			for (Train train : trains) {
				stations.add(train.getRoute().getDestinationStation());
			}
		}
		Stream<StationDTO> result = stations.stream().map(station -> StationDTO.fromEntity(station));
		return result;
	}

}
