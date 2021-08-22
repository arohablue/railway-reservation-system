/*package com.sunbeam.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity 
@Table(name="passengerTicket")
public class PassengerTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="passengerNo")
	private int id;
	private String pnr;
	private String pname;
	private String trainId;
	private int age;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;
	private String bookingStatus;
	public PassengerTicket() {
	}
	public PassengerTicket(int id, String pnr, String pname, String trainId, int age, String gender, Date date,
			String bookingStatus) {
		this.id = id;
		this.pnr = pnr;
		this.pname = pname;
		this.trainId = trainId;
		this.age = age;
		this.gender = gender;
		this.date = date;
		this.bookingStatus = bookingStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getTrainId() {
		return trainId;
	}
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public String toString() {
		return "PassengerTicket [id=" + id + ", pnr=" + pnr + ", pname=" + pname + ", trainId=" + trainId + ", age="
				+ age + ", gender=" + gender + ", date=" + date + ", bookingStatus=" + bookingStatus + "]";
	}
	
	
	
	
	
}
*/

