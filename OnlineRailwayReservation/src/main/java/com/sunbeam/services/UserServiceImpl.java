package com.sunbeam.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.PNRTable;
import com.sunbeam.entity.PassengerTicket;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.TrainStatus;
import com.sunbeam.entity.User;
import com.sunbeam.helpers.DateAndTimeHelper;
import com.sunbeam.helpers.SendEmail;

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
	private SendEmail sendEmail;

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

		for (Train train2 : trainsFiltered) {
			TrainStatus TrainStatus = trainStatusDao.findByTrain(train2);
			train2.setNoOfSeatsAC(TrainStatus.getAvailableSeatAC());
			train2.setNoOfSeatsGen(TrainStatus.getAvailableSeatGen());
		}

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
		List<PassengerTicket> passengerTickets = new ArrayList<>();
		if (uDao.findById(ticketDTO.getUser().getUserId()) != null
				&& trainDao.findById(ticketDTO.getTrain().getTrainId()) != null) {
			User user = uDao.findById(ticketDTO.getUser().getUserId());

			Train train = trainDao.findById(ticketDTO.getTrain().getTrainId());
			if (user != null && train != null) {
				for (UserDTO passenger : ticketDTO.getPassengers()) {
					PassengerTicket passengerTicket = new PassengerTicket();
					if (passenger != null && !passenger.getGender().equals("None")) {
						passengerTicket.setAge(passenger.getAge());
						passengerTicket.setGender(passenger.getGender());
						passengerTicket.setName(passenger.getName());
						passengerTicket.setBookingStatus("CONFIRMED");
						passengerTicket.setEmail(passenger.getEmail());
						passengerTicket.setDate(train.getDepartureTime());
						passengerTicket.setBookingDate(ticketDTO.getBookingDate());
						passengerTicket.setBookingClass(ticketDTO.getBookingClass());
						passengerTicket.setCardExpiry(ticketDTO.getCardExpiry());
						passengerTicket.setCardNumber(ticketDTO.getCardNumber());
						passengerTicket.setCardHolderName(ticketDTO.getCardHolderName());
						passengerTicket.setTrain(train);
						passengerTickets.add(passengerTicket);
					}
				}
			}

			// Create and save PNR table
			PNRTable pnrTable = new PNRTable();
			pnrTable.setEmail(user.getEmail());
			pnrTable.setUser(user);
			pnrTable.setPnrStatus("CONFIRMED");
			long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			pnrTable.setPnr(String.valueOf(number));
			pnrTableDao.save(pnrTable);

			// associate pnr
			for (PassengerTicket passengerTicket : passengerTickets) {
				passengerTicket.setPnrTable(pnrTable);
				passengerTicket.setPnr(String.valueOf(number));
			}

			if (udpateSeats(ticketDTO)) {

				// save ticket
				passengerTicketDao.saveAll(passengerTickets);
			}

			List<UserDTO> passengers = new ArrayList();
			for (PassengerTicket passengerTicket : passengerTickets) {
				UserDTO userDTO = new UserDTO();
				userDTO.setAge(passengerTicket.getAge());
				userDTO.setEmail(passengerTicket.getEmail());
				userDTO.setGender(passengerTicket.getGender());
				userDTO.setName(passengerTicket.getName());
				passengers.add(userDTO);
			}

			ticketDTO.setPassengers(passengers);
			ticketDTO.setPnr(String.valueOf(number));
			ticketDTO.setStatus(pnrTable.getPnrStatus());
			ticketDTO.setTrain(TrainDTO.fromEntity(train));
			return ticketDTO;
		}
		return null;
	}

	@Override
	public TicketDTO checkPnrStatus(TicketDTO ticketDTO) {
		List<PassengerTicket> passengerTickets = passengerTicketDao.findByPnr(ticketDTO.getPnr());

		TicketDTO ticket = new TicketDTO();
		List<UserDTO> passengers = new ArrayList<>();

		for (PassengerTicket passengerTicket : passengerTickets) {
			UserDTO passenger = new UserDTO();
			ticket.setPnr(passengerTicket.getPnr());
			ticket.setBookingDate(passengerTicket.getBookingDate());
			ticket.setReservationDate(passengerTicket.getTrain().getDepartureTime());
			ticket.setTrain(TrainDTO.fromEntity(passengerTicket.getTrain()));
			ticket.setBookingClass(passengerTicket.getBookingClass());
			ticket.setStatus(passengerTicket.getBookingStatus());
			passenger.setName(passengerTicket.getName());
			passenger.setAge(passengerTicket.getAge());
			passenger.setEmail(passengerTicket.getEmail());
			passenger.setGender(passengerTicket.getGender());
			passengers.add(passenger);
		}

		ticket.setPassengers(passengers);

		// Stream<TicketDTO> result = passengerTickets.stream()
		// .map(passengerTicket -> TicketDTO.fromEntity(passengerTicket));

		return ticket;
	}

	private boolean udpateSeats(TicketDTO ticketDTO) {
		try {

			Train train = trainDao.findById(ticketDTO.getTrain().getTrainId());
			Date startDate = dateAndTimeHelper.getStartDate(train.getDepartureTime());
			Date endDate = dateAndTimeHelper.getEndDate(train.getArrivalTime());

			TrainStatus trainStatus = trainStatusDao.findByTrainAndJourneyDateBetween(train, startDate, endDate);
			if (trainStatus != null && trainStatus.getAvailableSeatGen() > 0 && trainStatus.getAvailableSeatAC() > 0) {
				if (ticketDTO.getBookingClass().equals("AC")) {
					trainStatus.setAvailableSeatAC(trainStatus.getAvailableSeatAC() - ticketDTO.getPassengers().size());
				} else {
					trainStatus
							.setAvailableSeatGen(trainStatus.getAvailableSeatGen() - ticketDTO.getPassengers().size());
				}
				trainStatusDao.save(trainStatus);
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
	public Boolean cancelTicket(String pnr) {
		PNRTable pnrTable = pnrTableDao.findByPnr(pnr);
		Train train = new Train();
		Integer noOfSeatsAC = 0;
		Integer noOfSeatGen = 0;
		if (pnrTable != null) {
			pnrTable.setPnrStatus("CANCELLED");
			List<PassengerTicket> passengers = passengerTicketDao.findAllByPnr(pnr);
			for (PassengerTicket passengerTicket : passengers) {
				passengerTicket.setBookingStatus("CANCELLED");
				train = passengerTicket.getTrain();
				if (passengerTicket.getBookingClass().equals("AC")) {
					noOfSeatsAC += passengers.size();
				} else {
					noOfSeatGen += passengers.size();
				}
			}
			train = trainDao.findById(passengers.get(0).getTrain().getId());
			train.setNoOfSeatsAC(train.getNoOfSeatsAC() - noOfSeatsAC);
			train.setNoOfSeatsAC(train.getNoOfSeatsGen() - noOfSeatGen);
			return true;
		}
		return false;
	}

	@Override
	public Boolean sendOTP(UserDTO userDTO) {
		String email = userDTO.getEmail();
		User user = uDao.findByEmail(userDTO.getEmail());
		if (user != null) {
			String otp = generateOTP();
			user.setOtp(otp);
			sendEmail.sendOTP(email, otp);
			return true;
		}
		return false;
	}

	private String generateOTP() {
		long number = (long) Math.floor(Math.random() * 9_000_0L) + 1_000_0L;
		return Long.toString(number);
	}

	@Override
	public Boolean verifyOTP(UserDTO userDTO) {
		User user = uDao.findByEmail(userDTO.getEmail());
		if (user != null && userDTO.getOtp().equals(user.getOtp())) {
			return true;
		}
		return false;
	}

	// @Override
	// public User findById(int id) {
	//
	// return uDao.findById(id);
	// }

}
