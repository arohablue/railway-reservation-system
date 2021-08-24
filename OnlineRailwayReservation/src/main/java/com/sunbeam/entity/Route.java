package com.sunbeam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "train_route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "train_route_id")
	private int id;

	@Column(name = "source_id")
	private String sourceId;

	@Column(name = "destination_id")
	private String destinationId;

	// Child Relationships
	@OneToMany(mappedBy = "route", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Train> trains = new ArrayList<>();

	@JsonIgnore
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "source_station_id")
	private Station sourceStation;

	@JsonIgnore
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_station_id")
	private Station destinationStation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	public Station getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(Station sourceStation) {
		this.sourceStation = sourceStation;
	}

	public Station getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(Station destinationStation) {
		this.destinationStation = destinationStation;
	}

}
