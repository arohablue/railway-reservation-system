package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="routeId")
	private int id;
	private String sourceId;
	private String destinationId;
	public Route() {
	}
	public Route(int id, String sourceId, String destinationId) {
		this.id = id;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
	}
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
	@Override
	public String toString() {
		return "Route [id=" + id + ", sourceId=" + sourceId + ", destinationId=" + destinationId + "]";
	}
}
