package com.sunbeam.dto;

import com.sunbeam.entity.Route;

import org.springframework.beans.BeanUtils;

public class RouteDTO {
	private Long routeId;
	private StationDTO sourceStation;
	private StationDTO destinationStation;
	private Double acClassFair;
	private Double generalClassFair;

	public RouteDTO() {
	}

	public RouteDTO(Long routeId, StationDTO sourceStation, StationDTO destinationStation, Double acClassFair,
			Double generalClassFair) {
		this.routeId = routeId;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.acClassFair = acClassFair;
		this.generalClassFair = generalClassFair;
	}

	public Double getAcClassFair() {
		return acClassFair;
	}

	public void setAcClassFair(Double acClassFair) {
		this.acClassFair = acClassFair;
	}

	public Double getGeneralClassFair() {
		return generalClassFair;
	}

	public void setGeneralClassFair(Double generalClassFair) {
		this.generalClassFair = generalClassFair;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
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
		rdto.setSourceStation(StationDTO.fromEntity(route.getSourceStation()));
		rdto.setDestinationStation(StationDTO.fromEntity(route.getDestinationStation()));
		rdto.setRouteId(route.getId());
		return rdto;
	}

	public static Route toEntity(RouteDTO rdto) {
		Route route = new Route();
		BeanUtils.copyProperties(rdto, route);
		return route;
	}
}
