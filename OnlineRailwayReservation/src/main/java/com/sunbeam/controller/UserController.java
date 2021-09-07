package com.sunbeam.controller;

import java.util.stream.Stream;

import com.sunbeam.dao.FeedbackDao;
import com.sunbeam.dto.FeedbackDTO;
import com.sunbeam.dto.SearchTrainDTO;
import com.sunbeam.dto.TicketDTO;
import com.sunbeam.dto.TrainDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.Feedback;
import com.sunbeam.entity.User;
import com.sunbeam.models.ChangePassword;
import com.sunbeam.models.Credentials;
import com.sunbeam.models.Response;
import com.sunbeam.services.TrainService;
import com.sunbeam.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private TrainService trainService;

	@Autowired
	private FeedbackDao feedbackDao;

	// Admin will fetch all user so these method will be in admincontroller
	// @GetMapping("/{email}")
	// public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {
	// User user = uService.findByEmail(email);
	// return ResponseEntity.ok(UserDTO.fromEntity(user));
	// }

	// Admin will fetch all user so these method will be in admincontroller
	// @GetMapping("")
	// public ResponseEntity<?> findUserAll() {
	// List<User> list = uService.findAll();
	// List<UserDTO> result = new ArrayList<UserDTO>();
	// for (User user : list)
	// result.add(UserDTO.fromEntity(user));
	// return ResponseEntity.ok(result);
	// }

	@PostMapping("/signup")
	public ResponseEntity<?> save(UserDTO userDto) {
		User user = UserDTO.toEntity(userDto);
		System.out.println(user.toString());

		if (userService.save(user) != null) {
			user = userService.save(user);
			return Response.success(user);
		} else {
			return Response.error("Something went Wrong / Check Auth code");
		}
	}

	// trial n error
	// @PostMapping("/signin")
	// public ResponseEntity<?> auth(@RequestParam String email,@RequestParam String
	// password) {
	// User user = uService.findByEmail(email);
	// if (user.getPassword().equals(password)) {
	// System.out.println("login ho gya");
	// }
	// return ResponseEntity.ok(user);
	// }

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(Credentials cred) {
		User user = userService.authenticate(cred.getEmail(), cred.getPassword());
		if (user != null) {
			System.out.println("login validate");
			UserDTO userDto = new UserDTO();
			userDto.setAge(user.getAge());
			userDto.setEmail(user.getEmail());
			userDto.setCity(user.getCity());
			userDto.setGender(user.getGender());
			userDto.setUserId(user.getId());
			userDto.setMobile(user.getMobile());
			userDto.setRole(user.getRole());
			userDto.setState(user.getState());
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.ok(user);
	}

	@PostMapping("/changepassword")
	public ResponseEntity<?> update(@RequestBody ChangePassword cred) {
		User user = userService.findByEmail(cred.getEmail());
		if (user.getEmail().equals(cred.getEmail())) {

			user.setPassword(cred.getPassword());
			userService.save(user);

			return Response.success(user);
		}
		return null;
	}

	@PostMapping("/searchtrain")
	public ResponseEntity<?> searchTrain(@RequestBody SearchTrainDTO searchTrainDTO) {
		Stream<TrainDTO> result = userService.searchTrain(searchTrainDTO);
		return Response.success(result);
	}

	@PostMapping("/bookticket")
	public ResponseEntity<?> bookTicket(@RequestBody TicketDTO ticketDTO) {
		TicketDTO result = userService.bookTicket(ticketDTO);

		if (result != null) {
			return Response.success(result);
		}
		return Response.error("Something went Wrong");
	}

	@PostMapping("/checkpnr")
	public ResponseEntity<?> checkPnr(@RequestBody TicketDTO ticketDTO) {
		TicketDTO result = userService.checkPnrStatus(ticketDTO);

		if (result != null) {
			return Response.success(result);
		}
		return Response.error("Something went Wrong");
	}

	@PostMapping("/sendfeedback")
	public ResponseEntity<?> sendFeedback(@RequestBody FeedbackDTO feedbackDTO) {
		Feedback feedback = new Feedback();
		feedback.setEmail(feedbackDTO.getEmail());
		feedback.setFeedback(feedbackDTO.getSuggestion());
		feedback.setName(feedbackDTO.getName());
		feedbackDao.save(feedback);
		return Response.success("feedback Saved");
	}

	@PostMapping("/sendotp")
	public ResponseEntity<?> sendOTP(@RequestBody UserDTO userDTO) {
		Boolean result = userService.sendOTP(userDTO);
		if (result) {
			return Response.success("OTP Sent");
		}
		return Response.error("Failed");
	}

	@PostMapping("/verifyotp")
	public ResponseEntity<?> verifyOTP(@RequestBody UserDTO userDTO) {
		Boolean result = userService.verifyOTP(userDTO);
		if (result) {
			return Response.success("OTP Verifed");
		}
		return Response.error("Failed");
	}

	@PostMapping("/cancelticket")
	public ResponseEntity<?> cancelTicket(@RequestBody TicketDTO ticketDTO) {
		Boolean result = userService.cancelTicket(ticketDTO.getPnr());
		return Response.success("Cancel Ticket :" + result);
	}
}
