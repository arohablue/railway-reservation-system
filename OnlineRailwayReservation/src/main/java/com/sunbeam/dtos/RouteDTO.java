package com.sunbeam.dtos;

import org.springframework.beans.BeanUtils;

import com.sunbeam.entities.Route;
import com.sunbeam.entities.User;

public class RouteDTO {
	private int id;
	private String sourceid;
	private String destinationid;
	public RouteDTO() {
	}
	public RouteDTO(int id, String sourceid, String destinationid) {
		this.id = id;
		this.sourceid = sourceid;
		this.destinationid = destinationid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSourceid() {
		return sourceid;
	}
	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}
	public String getDestinationid() {
		return destinationid;
	}
	public void setDestinationid(String destinationid) {
		this.destinationid = destinationid;
	}
	@Override
	public String toString() {
		return "RouteDTO [id=" + id + ", sourceid=" + sourceid + ", destinationid=" + destinationid + "]";
	}
	
	public static RouteDTO fromEntity(Route route) {
		RouteDTO rdto = new RouteDTO();
		BeanUtils.copyProperties(route, rdto);
		rdto.setId(route.getId());
		return rdto;
	}
	
	public static Route toEntity(RouteDTO rdto) {
		Route route = new Route();
		BeanUtils.copyProperties(rdto, route);
		route.setId(rdto.getId());
		return route;
	}
}
