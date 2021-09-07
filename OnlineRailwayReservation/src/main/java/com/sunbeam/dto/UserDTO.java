package com.sunbeam.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import com.sunbeam.entity.Train;
import com.sunbeam.entity.User;

import org.springframework.beans.BeanUtils;

public class UserDTO {
	private Long userId;
	private String email;
	private String name;
	private String password;
	private Integer age;
	private String gender;
	private String mobile;
	private String state;
	private String city;
	private String role;
	private String adminKey;
	private String otp;

	

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getAdminKey() {
		return adminKey;
	}

	public void setAdminKey(String adminKey) {
		this.adminKey = adminKey;
	}

	public UserDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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

	public UserDTO(Long userId, String email, String name, String password, Integer age, String gender, String mobile,
			String state, String city, String role, String adminKey) {
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.state = state;
		this.city = city;
		this.role = role;
		this.adminKey = adminKey;
	}

	@Override
	public String toString() {
		return "UserDTO [adminKey=" + adminKey + ", age=" + age + ", city=" + city + ", email=" + email + ", gender="
				+ gender + ", mobile=" + mobile + ", name=" + name + ", password=" + password + ", role=" + role
				+ ", state=" + state + ", userId=" + userId + "]";
	}

	public static UserDTO fromEntity(User user) {
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user, dto);
		dto.setUserId(user.getId());
		return dto;
	}

	public static User toEntity(UserDTO dto) {
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		return user;
	}

}
