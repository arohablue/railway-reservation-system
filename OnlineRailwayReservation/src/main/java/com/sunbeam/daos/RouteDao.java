package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Route;


public interface RouteDao extends JpaRepository<Route, Integer>{
	Route findById(int Id);
	List<Route>findAll();
	Route save(Route route);
	boolean deleteById(int Id);
}
