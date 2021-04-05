package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * The persistent class for the patient database table.
 * 
 */
@Entity

@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ssn;

	@NotEmpty(message = "Patient address cannot be empty")
	private String address;

	@NotNull
	private int insuranceID;

	@NotNull(message = "Patient's contact no. cannot be empty")
	private String name;

	@Column(name = "phone", unique = true)
	@Min(value = 1000000000l, message = "Phone number should be 10 digits long")
	@Max(value = 9999999999l, message = "Phone number should be 10 digits long")
	private long phone;

	// bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy = "patientBean")
	private List<Appointment> appointments;

	// bi-directional many-to-one association to Physician
	@ManyToOne
	@JoinColumn(name = "PCP")
	private Physician physician;

	// bi-directional many-to-one association to Prescribe
	@OneToMany(mappedBy = "patientBean")
	private List<Prescribe> prescribes;

	// bi-directional many-to-one association to Stay
	@OneToMany(mappedBy = "patientBean")
	private List<Stay> stays;

	// bi-directional many-to-one association to Undergoe
	@OneToMany(mappedBy = "patientBean")
	private List<Undergoe> undergoes;

	@JsonManagedReference(value = "patient")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Patient() {
	}

	public int getSsn() {
		return this.ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getInsuranceID() {
		return this.insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getPhone() {
		return this.phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@JsonManagedReference(value = "patient-appointment")
	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setPatientBean(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setPatientBean(null);

		return appointment;
	}

	@JsonBackReference(value = "physician-patient")
	public Physician getPhysician() {
		return this.physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	@JsonManagedReference(value = "patient-prescribe")
	public List<Prescribe> getPrescribes() {
		return this.prescribes;
	}

	public void setPrescribes(List<Prescribe> prescribes) {
		this.prescribes = prescribes;
	}

	public Prescribe addPrescribe(Prescribe prescribe) {
		getPrescribes().add(prescribe);
		prescribe.setPatientBean(this);

		return prescribe;
	}

	public Prescribe removePrescribe(Prescribe prescribe) {
		getPrescribes().remove(prescribe);
		prescribe.setPatientBean(null);

		return prescribe;
	}

	@JsonManagedReference(value = "patient-stay")
	public List<Stay> getStays() {
		return this.stays;
	}

	public void setStays(List<Stay> stays) {
		this.stays = stays;
	}

	public Stay addStay(Stay stay) {
		getStays().add(stay);
		stay.setPatientBean(this);

		return stay;
	}

	public Stay removeStay(Stay stay) {
		getStays().remove(stay);
		stay.setPatientBean(null);

		return stay;
	}

	@JsonManagedReference(value = "patient-undergoes")
	public List<Undergoe> getUndergoes() {
		return this.undergoes;
	}

	public void setUndergoes(List<Undergoe> undergoes) {
		this.undergoes = undergoes;
	}

	public Undergoe addUndergoe(Undergoe undergoe) {
		getUndergoes().add(undergoe);
		undergoe.setPatientBean(this);

		return undergoe;
	}

	public Undergoe removeUndergoe(Undergoe undergoe) {
		getUndergoes().remove(undergoe);
		undergoe.setPatientBean(null);

		return undergoe;
	}

}