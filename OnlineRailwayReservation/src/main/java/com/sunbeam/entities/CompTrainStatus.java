package com.sunbeam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class CompTrainStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date journeyDate;

	private String trainId;

	public CompTrainStatus() {
	}

	public CompTrainStatus(Date journeyDate, String trainId) {
		this.journeyDate = journeyDate;
		this.trainId = trainId;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((journeyDate == null) ? 0 : journeyDate.hashCode());
		result = prime * result + ((trainId == null) ? 0 : trainId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompTrainStatus other = (CompTrainStatus) obj;
		if (journeyDate == null) {
			if (other.journeyDate != null)
				return false;
		} else if (!journeyDate.equals(other.journeyDate))
			return false;
		if (trainId == null) {
			if (other.trainId != null)
				return false;
		} else if (!trainId.equals(other.trainId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompTrainStatus [journeyDate=" + journeyDate + ", trainId=" + trainId + "]";
	}

}
