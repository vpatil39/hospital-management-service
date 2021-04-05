package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the block database table.
 * 
 */
@Embeddable
public class BlockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int blockFloor;

	private int blockCode;

	public BlockPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BlockPK)) {
			return false;
		}
		BlockPK castOther = (BlockPK)other;
		return 
			(this.blockFloor == castOther.blockFloor)
			&& (this.blockCode == castOther.blockCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.blockFloor;
		hash = hash * prime + this.blockCode;
		
		return hash;
	}
}