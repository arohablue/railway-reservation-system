package com.sunbeam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.RouteDTO;
import com.sunbeam.dto.StationDTO;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.Route;
import com.sunbeam.entity.Station;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.User;
import com.sunbeam.models.Credentials;
import com.sunbeam.models.Response;
import com.sunbeam.services.RouteService;
import com.sunbeam.services.StationService;
import com.sunbeam.services.TrainService;
import com.sunbeam.services.UserService;


@CrossOrigin
@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TrainService trainService;
	
	@Autowired
	private RouteService routeService;
	
	
	@Autowired
	private StationService stationService;
	
//	@GetMapping("/adminpanel/user")
//	public ResponseEntity<?> findUserAll() {
//		List<User> list = uService.findAll();
//		List<UserDTO> result = new ArrayList<UserDTO>();
//		for (User user : list) 
//			result.add(UserDTO.fromEntity(user));
//		return ResponseEntity.ok(result);
//	}
	
	@GetMapping("/adminpanel/user")
	public ResponseEntity<?> findUserAll() {
		List<User> list = userService.findAll();
		Stream<UserDTO> result = list.stream().map(user -> UserDTO.fromEntity(user));
		return Response.success(result);
	}
	
	
	@GetMapping("/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {
		User user = userService.findByEmail(email);
		return ResponseEntity.ok(UserDTO.fromEntity(user));
	}
	
	
//	@PostMapping("/signup")
//	public ResponseEntity<?> save(UserDTO userDto) {
//		User user = UserDTO.toEntity(userDto);
//		System.out.println(user.toString());
//		user = uService.save(user);
//		return ResponseEntity.ok(user);
//	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(UserDTO userDto){
		User user = UserDTO.toEntity(userDto);
		user = userService.update(user);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(Credentials cred) { 
		User user = userService.authenticate(cred.getEmail(), cred.getPassword());
		if(user != null && user.getRole().equals("admin"))
			System.out.println("Admin login validate");  
		return ResponseEntity.ok(user); 
	}
	
	
	@GetMapping("/adminpanel/train")
	public ResponseEntity<?> findTrainAll() {
		List<Train> list = trainService.findAll();
		Stream<TrainDTO> result = list.stream().map(train -> TrainDTO.fromEntity(train));
		return Response.success(result);
	}


	
	@DeleteMapping("/adminpanel/route/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id ) {
		boolean success = routeService.deleteById(id);
		return ResponseEntity.ok(success);
	}
	
	@GetMapping("/adminpanel/route")
	public ResponseEntity<?> findRouteAll() {
		List<Route> list = routeService.findAll();
		Stream<RouteDTO> result = list.stream().map(route -> RouteDTO.fromEntity(route));
		return Response.success(result);
	}
	
	
//	@GetMapping("/adminpanel/station")
//	public ResponseEntity<?> findStationAll() {
//		List<Station> list = sService.findAll();
//		Stream<StationDTO> result = list.stream().map(station -> StationDTO.fromEntity(station));
//		return Response.success(result);
//	}
	
//	@PostMapping("/signup")
//	public ResponseEntity<?> save(UserDTO userDto) {
//		User user = UserDTO.toEntity(userDto);
//		System.out.println(user.toString());
//		user = uService.save(user);
//		return ResponseEntity.ok(user);
//	}
	
	@PostMapping("/adminpanel/route")
	public ResponseEntity<?> saveRoute(RouteDTO routeDto) {
		Route route = RouteDTO.toEntity(routeDto);
		System.out.println(route.toString());
		route = routeService.save(route);
		return Response.success(route);
	}
	
	@PostMapping("/adminpanel/train")
	public ResponseEntity<?> saveTrain(TrainDTO trainDto) {
		Train train = TrainDTO.toEntity(trainDto);
		System.out.println(train.toString());
		train = trainService.save(train);
		return Response.success(train);
	}
	
	
//	@PostMapping("/adminpanel/station")
//	public ResponseEntity<?> saveStation(StationDTO stationDto) {
//		Station station = StationDTO.toEntity(stationDto);
//		System.out.println(station.toString());
//		station = sService.save(station);
//		return Response.success(station);
//	}
}
