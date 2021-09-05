package com.sunbeam.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.transaction.Transactional;

import com.sunbeam.dao.PNRTableDao;
import com.sunbeam.dao.PassengerTicketDao;
import com.sunbeam.dao.StationDao;
import com.sunbeam.dao.TrainDao;
import com.sunbeam.dao.TrainStatusDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.SearchTrainDTO;
import com.sunbeam.dto.TicketDTO;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.entity.PNRTable;
import com.sunbeam.entity.PassengerTicket;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.TrainStatus;
import com.sunbeam.entity.User;
import com.sunbeam.helpers.DateAndTimeHelper;

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
	private PNRTableDao pnrTableDao;

	@Autowired
	private PassengerTicketDao passengerTicketDao;

	@Autowired
	private TrainStatusDao trainStatusDao;

	DateAndTimeHelper dateAndTimeHelper;

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
		if (!user.getRole().equals("") && user.getRole() != null && user.getRole().equals("Admin")) {
			if (!user.getRole().equals("") && user.getRole() != null && user.getAdminKey().equals("Admin1234")) {
				return uDao.save(user);
			} else {
				return null;
			}
		} else if (!user.getRole().equals("") && user.getRole() != null) {
			return uDao.save(user);
		} else {
			return null;
		}

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
	public Boolean deleteById(Long id) {
		uDao.deleteById(id);
		if (uDao.findById(id) == null) {
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
		try {
			Date startDate = dateAndTimeHelper.getStartDate(searchTrainDTO.getJourneyDate());
			Date endDate = dateAndTimeHelper.getEndDate(searchTrainDTO.getJourneyDate());

			TrainStatus trainStatus = trainStatusDao.findByTrainAndJourneyDateBetween(train, startDate, endDate);
			if (trainStatus != null && trainStatus.getAvailableSeatGen() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public TicketDTO bookTicket(TicketDTO ticketDTO) {
		PassengerTicket passengerTicket = new PassengerTicket();
		if (uDao.findById(ticketDTO.getUser().getUserId()) != null
				&& trainDao.findById(ticketDTO.getTrain().getTrainId()) != null) {
			User user = uDao.findById(ticketDTO.getUser().getUserId());
			Train train = trainDao.findById(ticketDTO.getTrain().getTrainId());

			System.out.println("Age is " + ticketDTO.getUser().getAge());
			passengerTicket.setAge(ticketDTO.getUser().getAge());
			passengerTicket.setGender(ticketDTO.getUser().getGender());
			passengerTicket.setName(ticketDTO.getUser().getName());
			passengerTicket.setBookingStatus("CONFIRMED");
			passengerTicket.setEmail(ticketDTO.getUser().getEmail());
			passengerTicket.setDate(ticketDTO.getReservationDate());
			passengerTicket.setBookingDate(ticketDTO.getBookingDate());
			passengerTicket.setTrain(train);

			// Create and save PNR table
			PNRTable pnrTable = new PNRTable();
			pnrTable.setEmail(ticketDTO.getUser().getEmail());
			pnrTable.setUser(user);
			long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			pnrTable.setPnr(String.valueOf(number));
			pnrTableDao.save(pnrTable);

			// associate pnr table
			passengerTicket.setPnrTable(pnrTable);
			passengerTicket.setPnr(String.valueOf(number));

			if (udpateSeats(ticketDTO)) {

				// save ticket
				passengerTicketDao.save(passengerTicket);
			}
			return TicketDTO.fromEntity(passengerTicket);
		}
		return null;
	}

	@Override
	public TicketDTO checkPnrStatus(TicketDTO ticketDTO) {
		PassengerTicket passengerTicket = passengerTicketDao.findByPnr(ticketDTO.getPnr());
		return TicketDTO.fromEntity(passengerTicket);
	}

	private boolean udpateSeats(TicketDTO ticketDTO) {
		try {

			Train train = trainDao.findById(ticketDTO.getTrain().getTrainId());
			Date startDate = dateAndTimeHelper.getStartDate(ticketDTO.getTrain().getDepartureTime());
			Date endDate = dateAndTimeHelper.getEndDate(ticketDTO.getTrain().getArrivalTime());

			TrainStatus trainStatus = trainStatusDao.findByTrainAndJourneyDateBetween(train, startDate, endDate);
			if (trainStatus != null && trainStatus.getAvailableSeatGen() > 0 && trainStatus.getAvailableSeatAC() > 0) {
				if (ticketDTO.getClass().equals("AC")) {
					trainStatus.setAvailableSeatAC(trainStatus.getAvailableSeatAC() - 1);
					return true;
				} else {
					trainStatus.setAvailableSeatGen(trainStatus.getAvailableSeatGen() - 1);
					return true;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// @Override
	// public User findById(int id) {
	//
	// return uDao.findById(id);
	// }

}
