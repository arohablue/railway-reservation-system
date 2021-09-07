package com.sunbeam.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "station")
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "station_id")
	private Long id;

	@Column(name = "station_name")
	private String stationName;

	// // Parent Relationships
	// @JsonIgnore
	// @OneToOne(mappedBy = "sourceStation", fetch = FetchType.LAZY, cascade =
	// CascadeType.ALL, orphanRemoval = true)
	// private Route routeSource;

	// @JsonIgnore
	// @OneToOne(mappedBy = "destinationStation", fetch = FetchType.LAZY, cascade =
	// CascadeType.ALL, orphanRemoval = true)
	// private Route routeDestination;

	public Long getId() {
		return id;
	}

	public Station(Long id, String stationName) {
		this.id = id;
		this.stationName = stationName;
	}

	public Station() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	// public Route getRouteSource() {
	// return routeSource;
	// }

	// public void setRouteSource(Route routeSource) {
	// this.routeSource = routeSource;
	// }

	// public Route getRouteDestination() {
	// return routeDestination;
	// }

	// public void setRouteDestination(Route routeDestination) {
	// this.routeDestination = routeDestination;
	// }

}
