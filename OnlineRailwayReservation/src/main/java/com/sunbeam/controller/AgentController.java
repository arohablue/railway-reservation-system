package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.User;
import com.sunbeam.services.UserService;

@CrossOrigin
@RequestMapping("/agent")
@RestController
public class AgentController {
	@Autowired
	private UserService uService;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(UserDTO userDto){
		User user = UserDTO.toEntity(userDto);
		user = uService.update(user);
		return ResponseEntity.ok(user);
	}
	
}
