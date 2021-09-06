package com.sunbeam.controller;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import com.sunbeam.dto.RevenueDTO;
import com.sunbeam.dto.RouteDTO;
import com.sunbeam.dto.StationDTO;
import com.sunbeam.dto.TicketDTO;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.PassengerTicket;
import com.sunbeam.entity.Route;
import com.sunbeam.entity.Station;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.User;
import com.sunbeam.models.Credentials;
import com.sunbeam.models.Response;
import com.sunbeam.services.AdminService;
import com.sunbeam.services.PassengerTicketService;
import com.sunbeam.services.RouteService;
import com.sunbeam.services.StationService;
import com.sunbeam.services.TrainService;
import com.sunbeam.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	private UserService userService;

	@Autowired
	private TrainService trainService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private RouteService routeService;

	@Autowired
	private StationService stationService;

	@Autowired
	private PassengerTicketService passengerTicketService;

	// @Autowired
	// private AdminService adminService;

	// @GetMapping("/adminpanel/user")
	// public ResponseEntity<?> findUserAll() {
	// List<User> list = uService.findAll();
	// List<UserDTO> result = new ArrayList<UserDTO>();
	// for (User user : list)
	// result.add(UserDTO.fromEntity(user));
	// return ResponseEntity.ok(result);
	// }

	@GetMapping("/adminpanel/user")
	public ResponseEntity<?> findUserAll() {
		List<User> listOfusers = userService.findAll();
		List<User> userFiltered = listOfusers.stream().filter(user -> !user.getRole().equals("Admin"))
				.collect(Collectors.toList());
		Stream<UserDTO> result = userFiltered.stream().map(user -> UserDTO.fromEntity(user));
		return Response.success(result);
	}

	@GetMapping("/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {
		User user = userService.findByEmail(email);
		return ResponseEntity.ok(UserDTO.fromEntity(user));
	}

	// @PostMapping("/signup")
	// public ResponseEntity<?> save(UserDTO userDto) {
	// User user = UserDTO.toEntity(userDto);
	// System.out.println(user.toString());
	// user = uService.save(user);
	// return ResponseEntity.ok(user);
	// }

	@PutMapping("/{id}")
	public ResponseEntity<?> update(UserDTO userDto) {
		User user = UserDTO.toEntity(userDto);
		user = userService.update(user);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(Credentials cred) {
		User user = userService.authenticate(cred.getEmail(), cred.getPassword());
		if (user != null && user.getRole().equals("admin"))
			System.out.println("Admin login validate");
		return ResponseEntity.ok(user);
	}

	@GetMapping("/adminpanel/getalltrains")
	public ResponseEntity<?> getAllTrains() {
		List<Train> list = trainService.findAll();
		Stream<TrainDTO> result = list.stream().map(train -> TrainDTO.fromEntity(train));
		return Response.success(result);
	}

	@GetMapping("/adminpanel/getallroutes")
	public ResponseEntity<?> getAllRoutes() {
		List<Route> list = routeService.findAll();
		Stream<RouteDTO> result = list.stream().map(route -> RouteDTO.fromEntity(route));
		return Response.success(result);
	}

	@PostMapping("/adminpanel/addroute")
	public ResponseEntity<?> saveRoute(@RequestBody RouteDTO routeDto) {
		Route route = routeService.saveRoute(routeDto);
		return Response.success(route);
	}

	@PostMapping("/adminpanel/addtrain")
	public ResponseEntity<?> addTrain(@RequestBody TrainDTO trainDto) {
		Train train = trainService.saveTrain(trainDto);
		return Response.success(train);
	}

	@PostMapping("/adminpanel/addstation")
	public ResponseEntity<?> addStation(StationDTO stationDto) {
		Station station = stationService.saveStation(stationDto);
		return Response.success(station);
	}

	@GetMapping("/adminpanel/getallstation")
	public ResponseEntity<?> getAllStation(StationDTO stationDto) {
		List<Station> stationList = stationService.findAll();
		Stream<StationDTO> result = stationList.stream().map(station -> StationDTO.fromEntity(station));
		return Response.success(result);
	}

	@GetMapping("/adminpanel/getalltickets")
	public ResponseEntity<?> getAllTickets() {
		List<PassengerTicket> ticketsList = passengerTicketService.findAll();
		Stream<TicketDTO> result = ticketsList.stream().map(ticket -> TicketDTO.fromEntity(ticket));
		return Response.success(result);
	}

	@GetMapping("/adminpanel/getrevenue")
	public ResponseEntity<?> getRevenue() {
		RevenueDTO result = adminService.getRevenue();
		return Response.success(result);
	}

	@PostMapping("/adminpanel/updateticketstatus")
	public ResponseEntity<?> updateTicketStatus(@RequestBody TicketDTO ticketDTO) {
		Boolean result = adminService.updateTicketStatus(ticketDTO);

		if (result) {
			return Response.success(result);
		}
		return Response.error("Something went wrong");

	}

	@DeleteMapping("/adminpanel/route/{id}")
	public ResponseEntity<?> deleteRoute(@PathVariable("id") Long id) {
		boolean success = routeService.deleteById(id);
		return Response.success(success);
	}

	@DeleteMapping("/adminpanel/station/{id}")
	public ResponseEntity<?> deleteStation(@PathVariable("id") Long id) {
		boolean success = stationService.deleteById(id);
		return Response.success(success);
	}

	@DeleteMapping("/adminpanel/train/{id}")
	public ResponseEntity<?> deleteTrain(@PathVariable("id") Long id) {
		boolean success = trainService.deleteById(id);
		return Response.success(success);
	}

	@DeleteMapping("/adminpanel/user/{id}")
	public ResponseEntity<?> user(@PathVariable("id") Long id) {
		boolean success = userService.deleteById(id);
		return Response.success(success);
	}
}
