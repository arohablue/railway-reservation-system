package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sunbeam.daos.StationDao;
import com.sunbeam.entities.Station;


@Transactional
@Service
public class StationServiceImpl implements StationService{

	@Autowired
	private StationDao sDao;
	
	@Override
	public Station findById(int Id) {
		// TODO Auto-generated method stub
		return sDao.findById(Id);
	}

	@Override
	public List<Station> findAll() {
		// TODO Auto-generated method stub
		return sDao.findAll();
	}

	@Override
	public Station save(Station station) {
		// TODO Auto-generated method stub
		return sDao.save(station);
	}

	
	//Not working write another
	@Override
	public boolean deleteById(int Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
