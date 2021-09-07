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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "train_route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "train_route_id")
	private Long id;

	@Column(name = "route_name")
	private String routeName;

	@Column(name = "ac_fair")
	private Double acClassFair = 0.0;

	@Column(name = "general_fair")
	private Double generalClassFair = 0.0;

	// Child Relationships
	@OneToMany(mappedBy = "route", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Train> trains = new ArrayList<>();

	@OneToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "source_station_id")
	@JsonIgnore
	private Station sourceStation;

	@OneToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "destination_station_id")
	@JsonIgnore
	private Station destinationStation;

	@Override
	public String toString() {
		return "Route [acClassFair=" + acClassFair + ", destinationStation=" + destinationStation
				+ ", generalClassFair=" + generalClassFair + ", id=" + id + ", sourceStation=" + sourceStation
				+ ", trains=" + trains + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
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
