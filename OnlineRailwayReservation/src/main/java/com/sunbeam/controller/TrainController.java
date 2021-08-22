package com.sunbeam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.daos.TrainDao;
import com.sunbeam.dtos.TrainDTO;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.Train;
import com.sunbeam.entities.User;
import com.sunbeam.services.TrainService;
import com.sunbeam.services.UserService;

@CrossOrigin
@RequestMapping("/train")
@RestController
public class TrainController {
	@Autowired
	private TrainService tService;
	
	@GetMapping("")
	public ResponseEntity<?> findTrainAll() {
		List<Train> list = tService.findAll();
		List<TrainDTO> result = new ArrayList<TrainDTO>();
		for (Train train : list) 
			result.add(TrainDTO.fromEntity(train));
		return ResponseEntity.ok(result);
	}
	
	
}
