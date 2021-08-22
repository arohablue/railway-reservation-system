package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Route;

public interface RouteService {
	Route findById(int Id);
	List<Route>findAll();
	Route save(Route route);
	boolean deleteById(int Id);
}
