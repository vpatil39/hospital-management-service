package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the prescribes database table.
 * 
 */
@Embeddable
public class PrescribePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int physician;

	@Column(insertable=false, updatable=false)
	private int patient;

	@Column(insertable=false, updatable=false)
	private int medication;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date prescibeDate;

	public PrescribePK() {
	}
	public int getPhysician() {
		return this.physician;
	}
	public void setPhysician(int physician) {
		this.physician = physician;
	}
	public int getPatient() {
		return this.patient;
	}
	public void setPatient(int patient) {
		this.patient = patient;
	}
	public int getMedication() {
		return this.medication;
	}
	public void setMedication(int medication) {
		this.medication = medication;
	}
	public java.util.Date getDate() {
		return this.prescibeDate;
	}
	public void setDate(java.util.Date prescibeDate) {
		this.prescibeDate = prescibeDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrescribePK)) {
			return false;
		}
		PrescribePK castOther = (PrescribePK)other;
		return 
			(this.physician == castOther.physician)
			&& (this.patient == castOther.patient)
			&& (this.medication == castOther.medication)
			&& this.prescibeDate.equals(castOther.prescibeDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.physician;
		hash = hash * prime + this.patient;
		hash = hash * prime + this.medication;
		hash = hash * prime + this.prescibeDate.hashCode();
		
		return hash;
	}
}