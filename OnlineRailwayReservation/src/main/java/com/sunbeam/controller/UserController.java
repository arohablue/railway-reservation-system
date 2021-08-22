package com.sunbeam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.User;
import com.sunbeam.models.ChangePassword;
import com.sunbeam.models.Credentials;
import com.sunbeam.services.UserService;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService uService;
	
//Admin will fetch all user so these method will be in admincontroller
//	@GetMapping("/{email}")
//	public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {
//		User user = uService.findByEmail(email);
//		return ResponseEntity.ok(UserDTO.fromEntity(user));
//	}
	
	//Admin will fetch all user so these method will be in admincontroller
//	@GetMapping("")
//	public ResponseEntity<?> findUserAll() {
//		List<User> list = uService.findAll();
//		List<UserDTO> result = new ArrayList<UserDTO>();
//		for (User user : list) 
//			result.add(UserDTO.fromEntity(user));
//		return ResponseEntity.ok(result);
//	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> save(UserDTO userDto) {
		User user = UserDTO.toEntity(userDto);
		System.out.println(user.toString());
		user = uService.save(user);
		return ResponseEntity.ok(user);
	}
	
	//trial n error
//	@PostMapping("/signin")
//	public ResponseEntity<?> auth(@RequestParam String email,@RequestParam String password) {
//		User user = uService.findByEmail(email);
//		if (user.getPassword().equals(password)) {
//			System.out.println("login ho gya");
//		}
//		return ResponseEntity.ok(user);
//	}	


	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(Credentials cred) { 
		User user = uService.authenticate(cred.getEmail(), cred.getPassword());
		if(user != null)
			System.out.println("login validate");  
		return ResponseEntity.ok(user); 
	}
	
	@PostMapping("/changepassword")
	public ResponseEntity<?> update(ChangePassword cred){
		User user = uService.findByEmail(cred.getEmail());
		if(user.getEmail().equals(cred.getEmail())) {
			
			user.setPassword(cred.getPassword());
			uService.save(user);
			
			return ResponseEntity.ok(user);
		}
		return null;
	}
	
	
}
