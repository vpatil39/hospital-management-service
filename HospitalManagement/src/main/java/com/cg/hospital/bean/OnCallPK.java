package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the on_call database table.
 * 
 */
@Embeddable
public class OnCallPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int nurse;

	@Column(insertable=false, updatable=false)
	private int blockFloor;

	@Column(insertable=false, updatable=false)
	private int blockCode;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date onCallStart;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date onCallEnd;

	public OnCallPK() {
	}
	public int getNurse() {
		return this.nurse;
	}
	public void setNurse(int nurse) {
		this.nurse = nurse;
	}
	public int getBlockFloor() {
		return this.blockFloor;
	}
	public void setBlockFloor(int blockFloor) {
		this.blockFloor = blockFloor;
	}
	public int getBlockCode() {
		return this.blockCode;
	}
	public void setBlockCode(int blockCode) {
		this.blockCode = blockCode;
	}
	public java.util.Date getOnCallStart() {
		return this.onCallStart;
	}
	public void setOnCallStart(java.util.Date onCallStart) {
		this.onCallStart = onCallStart;
	}
	public java.util.Date getOnCallEnd() {
		return this.onCallEnd;
	}
	public void setOnCallEnd(java.util.Date onCallEnd) {
		this.onCallEnd = onCallEnd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OnCallPK)) {
			return false;
		}
		OnCallPK castOther = (OnCallPK)other;
		return 
			(this.nurse == castOther.nurse)
			&& (this.blockFloor == castOther.blockFloor)
			&& (this.blockCode == castOther.blockCode)
			&& this.onCallStart.equals(castOther.onCallStart)
			&& this.onCallEnd.equals(castOther.onCallEnd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nurse;
		hash = hash * prime + this.blockFloor;
		hash = hash * prime + this.blockCode;
		hash = hash * prime + this.onCallStart.hashCode();
		hash = hash * prime + this.onCallEnd.hashCode();
		
		return hash;
	}
}