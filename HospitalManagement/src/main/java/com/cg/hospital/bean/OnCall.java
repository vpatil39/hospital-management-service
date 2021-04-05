package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the on_call database table.
 * 
 */
@Entity
@Table(name = "on_call")
@NamedQuery(name = "OnCall.findAll", query = "SELECT o FROM OnCall o")
public class OnCall implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OnCallPK id;

	// bi-directional many-to-one association to Block
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "BlockCode", referencedColumnName = "BlockCode", insertable = false, updatable = false),
			@JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor", insertable = false, updatable = false) })
	private Block block;

	// bi-directional many-to-one association to Nurse
	@ManyToOne
	@JoinColumn(name = "Nurse", insertable = false, updatable = false)
	private Nurse nurseBean;

	public OnCall() {
	}

	public OnCallPK getId() {
		return this.id;
	}

	public void setId(OnCallPK id) {
		this.id = id;
	}

	@JsonBackReference(value = "block-oncall")
	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	@JsonBackReference(value = "nurse-oncall")
	public Nurse getNurseBean() {
		return this.nurseBean;
	}

	public void setNurseBean(Nurse nurseBean) {
		this.nurseBean = nurseBean;
	}

}