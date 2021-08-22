package com.sunbeam.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.sunbeam.entities.Train;
import com.sunbeam.entities.User;

public class UserDTO {
	private int id;
	private String email;
	private String password;
	private int age;
	private String gender;
	private String mobile;
	private String state;
	private String city;
	private String role;
	public UserDTO() {
		
	}
	public UserDTO(int id, String email, String password, int age, String gender, String mobile, String state,
			String city, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.state = state;
		this.city = city;
		this.role = role;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", email=" + email + ", password=" + password + ", age=" + age + ", gender="
				+ gender + ", mobile=" + mobile + ", state=" + state + ", city=" + city + ", role=" + role + "]";
	}



	public static UserDTO fromEntity(User user) {
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user, dto);
		dto.setId(user.getId());
		return dto;
	}
	
	public static User toEntity(UserDTO dto) {
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		user.setId(dto.getId());
		return user;
	}
	
	
}
