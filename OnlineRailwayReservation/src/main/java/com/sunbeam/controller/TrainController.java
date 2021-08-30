package com.sunbeam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.sunbeam.dto.StationDTO;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.entity.Train;
import com.sunbeam.models.Response;
import com.sunbeam.services.StationService;
import com.sunbeam.services.TrainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/train")
@RestController
public class TrainController {
	@Autowired
	private TrainService trainService;

	@Autowired
	private StationService stationService;

	@GetMapping("")
	public ResponseEntity<?> findTrainAll() {
		List<Train> list = trainService.findAll();
		List<TrainDTO> result = new ArrayList<TrainDTO>();
		for (Train train : list)
			result.add(TrainDTO.fromEntity(train));
		return Response.success(result);
	}

	@GetMapping("/getsourcestations")
	public ResponseEntity<?> getSourceStations() {
		Stream<StationDTO> result = stationService.getSourceStations();
		return Response.success(result);
	}

	@GetMapping("/getdestinationstations")
	public ResponseEntity<?> getDestinationStations() {
		Stream<StationDTO> result = stationService.getDestinationStations();
		return Response.success(result);
	}

}
