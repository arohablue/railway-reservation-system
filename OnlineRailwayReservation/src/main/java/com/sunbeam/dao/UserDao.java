package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	List<User>findAll();
	User save(User user);
	boolean deleteByEmail(String email);
	
}
