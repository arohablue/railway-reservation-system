package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.RouteDao;
import com.sunbeam.dao.StationDao;
import com.sunbeam.dto.RouteDTO;
import com.sunbeam.entity.Route;

@Transactional
@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private StationDao stationDao;

	@Override
	public Route findById(Long Id) {
		// TODO Auto-generated method stub
		return routeDao.findById(Id);
	}

	@Override
	public List<Route> findAll() {
		// TODO Auto-generated method stub
		return routeDao.findAll();
	}

	@Override
	public Route save(Route route) {
		// TODO Auto-generated method stub
		return routeDao.save(route);
	}

	// Not working write another
	@Override
	public boolean deleteById(Long id) {
		if (routeDao.findById(id) != null) {
			routeDao.deleteById(id);
			return true;
		}
		return false;

	}

	@Override
	public Route saveRoute(RouteDTO routeDTO) {
		Route route = RouteDTO.toEntity(routeDTO);
		if(stationDao.findById(routeDTO.getSourceStation().getStationId()) != null &&  
		stationDao.findById(routeDTO.getDestinationStation().getStationId()) != null ){
			route.setSourceStation(stationDao.findById(routeDTO.getSourceStation().getStationId()));
			route.setDestinationStation(stationDao.findById(routeDTO.getDestinationStation().getStationId()));
		}
		save(route);
		return route;
	}

	@Override
	public Boolean updateRoute(RouteDTO routeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteRoute(RouteDTO routeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
