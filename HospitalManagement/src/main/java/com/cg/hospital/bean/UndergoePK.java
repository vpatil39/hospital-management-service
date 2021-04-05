package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the undergoes database table.
 * 
 */
@Embeddable
public class UndergoePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int patient;

	@Column(insertable=false, updatable=false)
	private int procedures;

	@Column(insertable=false, updatable=false)
	private int stay;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dateUndergoes;

	public UndergoePK() {
	}
	public int getPatient() {
		return this.patient;
	}
	public void setPatient(int patient) {
		this.patient = patient;
	}
	public int getProcedures() {
		return this.procedures;
	}
	public void setProcedures(int procedures) {
		this.procedures = procedures;
	}
	public int getStay() {
		return this.stay;
	}
	public void setStay(int stay) {
		this.stay = stay;
	}
	public java.util.Date getDateUndergoes() {
		return this.dateUndergoes;
	}
	public void setDateUndergoes(java.util.Date dateUndergoes) {
		this.dateUndergoes = dateUndergoes;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UndergoePK)) {
			return false;
		}
		UndergoePK castOther = (UndergoePK)other;
		return 
			(this.patient == castOther.patient)
			&& (this.procedures == castOther.procedures)
			&& (this.stay == castOther.stay)
			&& this.dateUndergoes.equals(castOther.dateUndergoes);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.patient;
		hash = hash * prime + this.procedures;
		hash = hash * prime + this.stay;
		hash = hash * prime + this.dateUndergoes.hashCode();
		
		return hash;
	}
}