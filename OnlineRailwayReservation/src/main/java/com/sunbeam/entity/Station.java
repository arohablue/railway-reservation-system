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
	private int id;

	@Column(name = "station_name")
	private String stationName;

	// Parent Relationships	
	@OneToOne(mappedBy = "sourceStation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Route routeSource;

	@OneToOne(mappedBy = "destinationStation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Route routeDestination;

}
