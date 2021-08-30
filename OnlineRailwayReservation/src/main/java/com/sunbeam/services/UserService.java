package com.sunbeam.services;

import java.util.List;
import java.util.stream.Stream;

import com.sunbeam.dto.SearchTrainDTO;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.entity.User;

public interface UserService {
	User findByEmail(String email);
	List<User>findAll();
	User save(User user);
	Boolean deleteById(int id);
	User authenticate(String email, String password );
	User update(User user);
	User findById(int id);
	Stream<TrainDTO> searchTrain(SearchTrainDTO searchTrainDTO);
	
}
