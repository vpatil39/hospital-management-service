package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the affiliated_with database table.
 * 
 */
@Embeddable
public class AffiliatedWithPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int physician;

	@Column(insertable=false, updatable=false)
	private int department;

	public AffiliatedWithPK() {
	}
	public int getPhysician() {
		return this.physician;
	}
	public void setPhysician(int physician) {
		this.physician = physician;
	}
	public int getDepartment() {
		return this.department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AffiliatedWithPK)) {
			return false;
		}
		AffiliatedWithPK castOther = (AffiliatedWithPK)other;
		return 
			(this.physician == castOther.physician)
			&& (this.department == castOther.department);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.physician;
		hash = hash * prime + this.department;
		
		return hash;
	}
}