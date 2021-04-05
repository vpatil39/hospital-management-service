package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the trained_in database table.
 * 
 */
@Embeddable
public class TrainedInPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int physician;

	@Column(insertable=false, updatable=false)
	private int treatment;

	public TrainedInPK() {
	}
	public int getPhysician() {
		return this.physician;
	}
	public void setPhysician(int physician) {
		this.physician = physician;
	}
	public int getTreatment() {
		return this.treatment;
	}
	public void setTreatment(int treatment) {
		this.treatment = treatment;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrainedInPK)) {
			return false;
		}
		TrainedInPK castOther = (TrainedInPK)other;
		return 
			(this.physician == castOther.physician)
			&& (this.treatment == castOther.treatment);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.physician;
		hash = hash * prime + this.treatment;
		
		return hash;
	}
}