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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pnr_table")
public class PNRTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pnr_table_id")
	private Long id;

	@Column(name = "pnr")
	private String pnr;

	@Column(name = "email")
	private String email;

	@Column(name = "pnr_status")
	private String pnrStatus;

	// Parent Relationships
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	// Child Relationships
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pnrTable", orphanRemoval = true)
	private List<PassengerTicket> passengerTickets = new ArrayList<>();

	public String getPnrStatus() {
		return pnrStatus;
	}

	public void setPnrStatus(String pnrStatus) {
		this.pnrStatus = pnrStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PassengerTicket> getPassengerTickets() {
		return passengerTickets;
	}

	public void setPassengerTickets(List<PassengerTicket> passengerTickets) {
		this.passengerTickets = passengerTickets;
	}

}
