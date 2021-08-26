package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.RouteDao;
import com.sunbeam.dto.RouteDTO;
import com.sunbeam.entity.Route;


@Transactional
@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao rDao;
	
	@Override
	public Route findById(int Id) {
		// TODO Auto-generated method stub
		return rDao.findById(Id);
	}

	@Override
	public List<Route> findAll() {
		// TODO Auto-generated method stub
		return rDao.findAll();
	}

	@Override
	public Route save(Route route) {
		// TODO Auto-generated method stub
		return rDao.save(route);
	}

	//Not working write another
	@Override
	public boolean deleteById(int id) {
		if(rDao.existsById(id)) {
			rDao.deleteById(id);
			return true;
		}
		return false;
		
	}

	@Override
	public Boolean saveRoute(RouteDTO routeDTO) {
		// TODO Auto-generated method stub
		return null;
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
