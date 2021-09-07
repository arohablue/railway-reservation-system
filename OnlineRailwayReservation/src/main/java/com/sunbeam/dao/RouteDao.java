package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.Route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RouteDao extends JpaRepository<Route, Integer> {
	Route findById(Long Id);

	List<Route> findAll();

	Route save(Route route);

	void deleteById(Long Id);
}
