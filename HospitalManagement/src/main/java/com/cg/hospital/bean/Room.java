package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int roomNumber;

	private String roomType;

	private byte unavailable;

	//bi-directional many-to-one association to Block
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="BlockCode", referencedColumnName="BlockCode"),
		@JoinColumn(name="BlockFloor", referencedColumnName="BlockFloor")
		})
	private Block block;

	//bi-directional many-to-one association to Stay
	@OneToMany(mappedBy="roomBean")
	private List<Stay> stays;

	public Room() {
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public byte getUnavailable() {
		return this.unavailable;
	}

	public void setUnavailable(byte unavailable) {
		this.unavailable = unavailable;
	}
	@JsonBackReference(value = "block-room")
	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}
	@JsonManagedReference(value = "room-stay")
	public List<Stay> getStays() {
		return this.stays;
	}

	public void setStays(List<Stay> stays) {
		this.stays = stays;
	}

	public Stay addStay(Stay stay) {
		getStays().add(stay);
		stay.setRoomBean(this);

		return stay;
	}

	public Stay removeStay(Stay stay) {
		getStays().remove(stay);
		stay.setRoomBean(null);

		return stay;
	}

}