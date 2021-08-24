// package com.sunbeam.entity;

// import java.io.Serializable;
// import java.util.Date;

// import javax.persistence.Column;
// import javax.persistence.Embeddable;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;

// import org.springframework.format.annotation.DateTimeFormat;

// @Embeddable
// public class CompTrainStatus implements Serializable {

// 	private static final long serialVersionUID = 1L;
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	@Column(name = "train_id")
// 	private String compTrainId;
	
// 	@DateTimeFormat(pattern = "yyyy-MM-dd")
// 	@Temporal(TemporalType.DATE)
// 	private Date journeyDate;


// 	public CompTrainStatus() {
// 	}

// 	public CompTrainStatus(Date journeyDate, String trainId) {
// 		this.journeyDate = journeyDate;
// 		this.compTrainId = trainId;
// 	}

// 	public Date getJourneyDate() {
// 		return journeyDate;
// 	}

// 	public void setJourneyDate(Date journeyDate) {
// 		this.journeyDate = journeyDate;
// 	}

// 	public String getTrainId() {
// 		return compTrainId;
// 	}

// 	public void setTrainId(String trainId) {
// 		this.compTrainId = trainId;
// 	}

// 	@Override
// 	public int hashCode() {
// 		final int prime = 31;
// 		int result = 1;
// 		result = prime * result + ((journeyDate == null) ? 0 : journeyDate.hashCode());
// 		result = prime * result + ((compTrainId == null) ? 0 : compTrainId.hashCode());
// 		return result;
// 	}

// 	@Override
// 	public boolean equals(Object obj) {
// 		if (this == obj)
// 			return true;
// 		if (obj == null)
// 			return false;
// 		if (getClass() != obj.getClass())
// 			return false;
// 		CompTrainStatus other = (CompTrainStatus) obj;
// 		if (journeyDate == null) {
// 			if (other.journeyDate != null)
// 				return false;
// 		} else if (!journeyDate.equals(other.journeyDate))
// 			return false;
// 		if (compTrainId == null) {
// 			if (other.compTrainId != null)
// 				return false;
// 		} else if (!compTrainId.equals(other.compTrainId))
// 			return false;
// 		return true;
// 	}

// 	@Override
// 	public String toString() {
// 		return "CompTrainStatus [journeyDate=" + journeyDate + ", trainId=" + compTrainId + "]";
// 	}

// }
