package com.sunbeam.services;

import java.util.List;

import com.sunbeam.dto.RouteDTO;
import com.sunbeam.entity.Route;

public interface RouteService {
	Route findById(Long Id);

	List<Route> findAll();

	Route save(Route route);	

	boolean deleteById(Long Id);

	Route saveRoute(RouteDTO routeDTO);

	Boolean updateRoute(RouteDTO routeDTO);

	Boolean deleteRoute(RouteDTO routeDTO);
}
