package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the block database table.
 * 
 */
@Entity
@NamedQuery(name="Block.findAll", query="SELECT b FROM Block b")
public class Block implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BlockPK id;

	//bi-directional many-to-one association to OnCall
	@OneToMany(mappedBy="block")
	private List<OnCall> onCalls;

	//bi-directional many-to-one association to Room
	@OneToMany(mappedBy="block")
	private List<Room> rooms;

	public Block() {
	}

	public BlockPK getId() {
		return this.id;
	}

	public void setId(BlockPK id) {
		this.id = id;
	}

	@JsonManagedReference(value = "block-oncall")
	public List<OnCall> getOnCalls() {
		return this.onCalls;
	}

	public void setOnCalls(List<OnCall> onCalls) {
		this.onCalls = onCalls;
	}

	public OnCall addOnCall(OnCall onCall) {
		getOnCalls().add(onCall);
		onCall.setBlock(this);

		return onCall;
	}

	public OnCall removeOnCall(OnCall onCall) {
		getOnCalls().remove(onCall);
		onCall.setBlock(null);

		return onCall;
	}
	@JsonManagedReference(value = "block-room")
	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room addRoom(Room room) {
		getRooms().add(room);
		room.setBlock(this);

		return room;
	}

	public Room removeRoom(Room room) {
		getRooms().remove(room);
		room.setBlock(null);

		return room;
	}

}