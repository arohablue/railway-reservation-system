package com.sunbeam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dao.TrainDao;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.Train;
import com.sunbeam.entity.User;
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
