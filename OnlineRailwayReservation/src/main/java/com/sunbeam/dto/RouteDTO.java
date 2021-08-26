package com.sunbeam.dto;

import com.sunbeam.entity.Route;

import org.springframework.beans.BeanUtils;

public class RouteDTO {
	private int routeId;
	private StationDTO sourceStation;
	private StationDTO destinationStation;

	public RouteDTO() {
	}

	@Override
	public String toString() {
		return "RouteDTO [destinationStation=" + destinationStation + ", routeId=" + routeId + ", sourceStation="
				+ sourceStation + "]";
	}

	public RouteDTO(int routeId, StationDTO sourceStation, StationDTO destinationStation) {
		this.routeId = routeId;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public StationDTO getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(StationDTO sourceStation) {
		this.sourceStation = sourceStation;
	}

	public StationDTO getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(StationDTO destinationStation) {
		this.destinationStation = destinationStation;
	}

	public static RouteDTO fromEntity(Route route) {
		RouteDTO rdto = new RouteDTO();
		BeanUtils.copyProperties(route, rdto);
		rdto.setRouteId(route.getId());
		return rdto;
	}

	public static Route toEntity(RouteDTO rdto) {
		Route route = new Route();
		BeanUtils.copyProperties(rdto, route);
		return route;
	}
}
