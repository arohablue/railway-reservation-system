package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.TrainDao;
import com.sunbeam.entity.Train;


@Transactional
@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainDao tDao;
	
	
	@Override
	public Train findById(int Id) {
		return tDao.findById(Id);
	}

	@Override
	public List<Train> findAll() {
		return tDao.findAll();
	}

	@Override
	public Train save(Train train) {
		return tDao.save(train);
	}

	@Override
	public boolean deleteById(int Id) {
		return tDao.deleteById(Id);
	}

	

}
