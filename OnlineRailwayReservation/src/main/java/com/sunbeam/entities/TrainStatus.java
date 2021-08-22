//package com.sunbeam.entities;
//
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//
//import javax.persistence.IdClass;
//import javax.persistence.Table;
//
//
//@Entity 
//@IdClass(Train.class)
//@Table(name="trainStatus")
//public class TrainStatus {
//	@EmbeddedId
//	private CompTrainStatus comptrainstatus;	
//	private int availableSeatGen;
//	private int bookedSeatGen;
//	private int availableSeatAC;
//	private int bookedSeatAC;
//	public TrainStatus() {
//		super();
//	}
//	public TrainStatus(CompTrainStatus comptrainstatus, int availableSeatGen, int bookedSeatGen, int availableSeatAC,
//			int bookedSeatAC) {
//		super();
//		this.comptrainstatus = comptrainstatus;
//		this.availableSeatGen = availableSeatGen;
//		this.bookedSeatGen = bookedSeatGen;
//		this.availableSeatAC = availableSeatAC;
//		this.bookedSeatAC = bookedSeatAC;
//	}
//	public CompTrainStatus getComptrainstatus() {
//		return comptrainstatus;
//	}
//	public void setComptrainstatus(CompTrainStatus comptrainstatus) {
//		this.comptrainstatus = comptrainstatus;
//	}
//	public int getAvailableSeatGen() {
//		return availableSeatGen;
//	}
//	public void setAvailableSeatGen(int availableSeatGen) {
//		this.availableSeatGen = availableSeatGen;
//	}
//	public int getBookedSeatGen() {
//		return bookedSeatGen;
//	}
//	public void setBookedSeatGen(int bookedSeatGen) {
//		this.bookedSeatGen = bookedSeatGen;
//	}
//	public int getAvailableSeatAC() {
//		return availableSeatAC;
//	}
//	public void setAvailableSeatAC(int availableSeatAC) {
//		this.availableSeatAC = availableSeatAC;
//	}
//	public int getBookedSeatAC() {
//		return bookedSeatAC;
//	}
//	public void setBookedSeatAC(int bookedSeatAC) {
//		this.bookedSeatAC = bookedSeatAC;
//	}
//	@Override
//	public String toString() {
//		return "TrainStatus [comptrainstatus=" + comptrainstatus + ", availableSeatGen=" + availableSeatGen
//				+ ", bookedSeatGen=" + bookedSeatGen + ", availableSeatAC=" + availableSeatAC + ", bookedSeatAC="
//				+ bookedSeatAC + "]";
//	}
//		
//}