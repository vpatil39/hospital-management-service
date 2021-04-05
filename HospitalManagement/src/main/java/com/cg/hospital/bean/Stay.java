package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the stay database table.
 * 
 */
@Entity
@NamedQuery(name = "Stay.findAll", query = "SELECT s FROM Stay s")
public class Stay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int stayID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date stayEnd;

	@Temporal(TemporalType.TIMESTAMP)
	private Date stayStart;

	// bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name = "Patient")
	private Patient patientBean;

	// bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name = "Room")
	private Room roomBean;

	// bi-directional many-to-one association to Undergoe
	@OneToMany(mappedBy = "stayBean")
	private List<Undergoe> undergoes;

	public Stay() {
	}

	public int getStayID() {
		return this.stayID;
	}

	public void setStayID(int stayID) {
		this.stayID = stayID;
	}

	public Date getStayEnd() {
		return this.stayEnd;
	}

	public void setStayEnd(Date stayEnd) {
		this.stayEnd = stayEnd;
	}

	public Date getStayStart() {
		return this.stayStart;
	}

	public void setStayStart(Date stayStart) {
		this.stayStart = stayStart;
	}

	@JsonBackReference(value = "patient-stay")
	public Patient getPatientBean() {
		return this.patientBean;
	}

	public void setPatientBean(Patient patientBean) {
		this.patientBean = patientBean;
	}

	@JsonBackReference(value = "room-stay")
	public Room getRoomBean() {
		return this.roomBean;
	}

	public void setRoomBean(Room roomBean) {
		this.roomBean = roomBean;
	}

	@JsonManagedReference(value = "stay-undergoes")
	public List<Undergoe> getUndergoes() {
		return this.undergoes;
	}

	public void setUndergoes(List<Undergoe> undergoes) {
		this.undergoes = undergoes;
	}

	public Undergoe addUndergoe(Undergoe undergoe) {
		getUndergoes().add(undergoe);
		undergoe.setStayBean(this);

		return undergoe;
	}

	public Undergoe removeUndergoe(Undergoe undergoe) {
		getUndergoes().remove(undergoe);
		undergoe.setStayBean(null);

		return undergoe;
	}

}