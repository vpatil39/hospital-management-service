package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * The persistent class for the nurse database table.
 * 
 */
@Entity
@NamedQuery(name = "Nurse.findAll", query = "SELECT n FROM Nurse n")
public class Nurse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int employeeID;

	private String name;

	private String position;

	private byte registered;

	private int ssn;

	// bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy = "nurse")
	private List<Appointment> appointments;

	// bi-directional many-to-one association to OnCall
	@OneToMany(mappedBy = "nurseBean")
	private List<OnCall> onCalls;

	// bi-directional many-to-one association to Undergoe
	@OneToMany(mappedBy = "nurse")
	private List<Undergoe> undergoes;

	public Nurse() {
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public byte getRegistered() {
		return this.registered;
	}

	public void setRegistered(byte registered) {
		this.registered = registered;
	}

	public int getSsn() {
		return this.ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	@JsonManagedReference(value = "nurse-appointment")
	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setNurse(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setNurse(null);

		return appointment;
	}

	@JsonManagedReference(value = "nurse-oncall")
	public List<OnCall> getOnCalls() {
		return this.onCalls;
	}

	public void setOnCalls(List<OnCall> onCalls) {
		this.onCalls = onCalls;
	}

	public OnCall addOnCall(OnCall onCall) {
		getOnCalls().add(onCall);
		onCall.setNurseBean(this);

		return onCall;
	}

	public OnCall removeOnCall(OnCall onCall) {
		getOnCalls().remove(onCall);
		onCall.setNurseBean(null);

		return onCall;
	}

	@JsonManagedReference(value = "nurse-undergoes")
	public List<Undergoe> getUndergoes() {
		return this.undergoes;
	}

	public void setUndergoes(List<Undergoe> undergoes) {
		this.undergoes = undergoes;
	}

	public Undergoe addUndergoe(Undergoe undergoe) {
		getUndergoes().add(undergoe);
		undergoe.setNurse(this);

		return undergoe;
	}

	public Undergoe removeUndergoe(Undergoe undergoe) {
		getUndergoes().remove(undergoe);
		undergoe.setNurse(null);

		return undergoe;
	}

}