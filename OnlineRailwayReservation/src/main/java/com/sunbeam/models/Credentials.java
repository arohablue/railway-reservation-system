package com.sunbeam.models;

import org.springframework.beans.BeanUtils;

import com.sunbeam.dto.UserDTO;
import com.sunbeam.entity.User;

public class Credentials {
	private String email;
	private String password;
	public Credentials() {
	}
	public Credentials(String email, String password) {
		this.email = email;
		this.password = password;
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
	@Override
	public String toString() {
		return "Credentials [email=" + email + ", password=" + password + "]";
	}
	public static Credentials fromEntity(User user) {
		Credentials cred = new Credentials();
		BeanUtils.copyProperties(user, cred);
		return cred;
	}
	
	public static User toEntity(Credentials cred) {
		User user = new User();
		BeanUtils.copyProperties(cred, user);
		return user;
	}
	
}
