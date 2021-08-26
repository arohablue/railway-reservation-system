package com.sunbeam.services;

import java.util.List;

import com.sunbeam.dto.RouteDTO;
import com.sunbeam.entity.Route;

public interface RouteService {
	Route findById(int Id);
	List<Route>findAll();
	Route save(Route route);
	boolean deleteById(int Id);
	Boolean saveRoute(RouteDTO routeDTO);
    Boolean updateRoute(RouteDTO routeDTO);
    Boolean deleteRoute(RouteDTO routeDTO);
}
