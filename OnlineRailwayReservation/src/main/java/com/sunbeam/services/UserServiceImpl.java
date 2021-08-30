package com.sunbeam.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import com.sunbeam.dao.StationDao;
import com.sunbeam.dao.TrainDao;
import com.sunbeam.dao.TrainStatusDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.SearchTrainDTO;
import com.sunbeam.dto.TicketDTO;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.TrainStatus;
import com.sunbeam.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao uDao;

	@Autowired
	private TrainDao trainDao;

	@Autowired
	private StationDao stationDao;

	@Autowired
	private TrainStatusDao trainStatusDao;

	@Override
	public User findByEmail(String email) {

		return uDao.findByEmail(email);
	}

	@Override
	public List<User> findAll() {

		return uDao.findAll();
	}

	@Override
	public User save(User user) {
		return uDao.save(user);
	}

	@Override
	public User authenticate(String email, String password) {
		User user = findByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			// if (user.getRole().equals("user")) {
			// return user;
			// }
			// else if (user.getRole().equals("admin")) {
			// return user;
			// }
			// else if(user.getRole().equals("agent")){
			// return user;
			// }
			return user;
		}

		return null;
	}

	@Override
	public User update(User user) {
		return uDao.save(user);
	}

	@Override
	public User findById(int id) {
		Optional<User> user = uDao.findById(id);
		return user.orElse(null);
	}

	@Override
	public Boolean deleteById(int id) {
		if (uDao.existsById(id)) {
			uDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Stream<TrainDTO> searchTrain(SearchTrainDTO searchTrainDTO) {
		List<Train> trains = trainDao.findAll();
		List<Train> trainsFiltered = trains.stream().filter(train -> train.getRoute().getSourceStation().getId()
				.equals(searchTrainDTO.getFromStation().getStationId())
				&& train.getRoute().getDestinationStation().getId().equals(searchTrainDTO.getToStation().getStationId())
				&& checkSeatAvailbility(train, searchTrainDTO)).collect(Collectors.toList());

		return trainsFiltered.stream().map(train -> TrainDTO.fromEntity(train));
	}

	private Boolean checkSeatAvailbility(Train train, SearchTrainDTO searchTrainDTO) {
		TrainStatus trainStatus = trainStatusDao.findByTrainAndJourneyDate(train, searchTrainDTO.getJourneyDate());
		if (trainStatus.getAvailableSeatGen() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public TicketDTO bookTicket(TicketDTO ticketDTO) {

		return null;
	}

	// @Override
	// public User findById(int id) {
	//
	// return uDao.findById(id);
	// }

}
