package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * The persistent class for the physician database table.
 * 
 */
@Entity
@NamedQuery(name = "Physician.findAll", query = "SELECT p FROM Physician p")
public class Physician implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeID;

	@NotEmpty(message = "Physician name cannot be empty")
	private String name;

	@NotEmpty(message = "Physician position cannot be empty")
	private String position;

	private int ssn;

	// bi-directional many-to-one association to AffiliatedWith
	@OneToMany(mappedBy = "physicianBean")
	private List<AffiliatedWith> affiliatedWiths;

	// bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy = "physicianBean")
	private List<Appointment> appointments;

	// bi-directional many-to-one association to Department
	@OneToMany(mappedBy = "physician")
	private List<Department> departments;

	// bi-directional many-to-one association to Patient
	@OneToMany(mappedBy = "physician")
	private List<Patient> patients;

	// bi-directional many-to-one association to Prescribe
	@OneToMany(mappedBy = "physicianBean")
	private List<Prescribe> prescribes;

	// bi-directional many-to-one association to TrainedIn
	@OneToMany(mappedBy = "physicianBean")
	private List<TrainedIn> trainedIns;

	// bi-directional many-to-one association to Undergoe
	@OneToMany(mappedBy = "physicianBean")
	private List<Undergoe> undergoes;

	/*
	 * @JsonManagedReference(value = "physician")
	 * 
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	 * 
	 * @JoinColumn(name = "user_id", nullable = false) private User user;
	 */
	
	public Physician() {
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

	public int getSsn() {
		return this.ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	@JsonManagedReference(value = "phy-affiliated")
	public List<AffiliatedWith> getAffiliatedWiths() {
		return this.affiliatedWiths;
	}

	public void setAffiliatedWiths(List<AffiliatedWith> affiliatedWiths) {
		this.affiliatedWiths = affiliatedWiths;
	}

	public AffiliatedWith addAffiliatedWith(AffiliatedWith affiliatedWith) {
		getAffiliatedWiths().add(affiliatedWith);
		affiliatedWith.setPhysicianBean(this);

		return affiliatedWith;
	}

	public AffiliatedWith removeAffiliatedWith(AffiliatedWith affiliatedWith) {
		getAffiliatedWiths().remove(affiliatedWith);
		affiliatedWith.setPhysicianBean(null);

		return affiliatedWith;
	}

	@JsonManagedReference(value = "physician-appointment")
	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setPhysicianBean(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setPhysicianBean(null);

		return appointment;
	}

	@JsonManagedReference(value = "physician-department")
	public List<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setPhysician(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setPhysician(null);

		return department;
	}

	@JsonManagedReference(value = "physician-patient")
	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient addPatient(Patient patient) {
		getPatients().add(patient);
		patient.setPhysician(this);

		return patient;
	}

	public Patient removePatient(Patient patient) {
		getPatients().remove(patient);
		patient.setPhysician(null);

		return patient;
	}

	@JsonManagedReference(value = "physician-prescribe")
	public List<Prescribe> getPrescribes() {
		return this.prescribes;
	}

	public void setPrescribes(List<Prescribe> prescribes) {
		this.prescribes = prescribes;
	}

	public Prescribe addPrescribe(Prescribe prescribe) {
		getPrescribes().add(prescribe);
		prescribe.setPhysicianBean(this);

		return prescribe;
	}

	public Prescribe removePrescribe(Prescribe prescribe) {
		getPrescribes().remove(prescribe);
		prescribe.setPhysicianBean(null);

		return prescribe;
	}

	@JsonManagedReference(value = "physician-trainedIn")
	public List<TrainedIn> getTrainedIns() {
		return this.trainedIns;
	}

	public void setTrainedIns(List<TrainedIn> trainedIns) {
		this.trainedIns = trainedIns;
	}

	public TrainedIn addTrainedIn(TrainedIn trainedIn) {
		getTrainedIns().add(trainedIn);
		trainedIn.setPhysicianBean(this);

		return trainedIn;
	}

	public TrainedIn removeTrainedIn(TrainedIn trainedIn) {
		getTrainedIns().remove(trainedIn);
		trainedIn.setPhysicianBean(null);

		return trainedIn;
	}

	@JsonManagedReference(value = "physician-undergoes")
	public List<Undergoe> getUndergoes() {
		return this.undergoes;
	}

	public void setUndergoes(List<Undergoe> undergoes) {
		this.undergoes = undergoes;
	}

	public Undergoe addUndergoe(Undergoe undergoe) {
		getUndergoes().add(undergoe);
		undergoe.setPhysicianBean(this);

		return undergoe;
	}

	public Undergoe removeUndergoe(Undergoe undergoe) {
		getUndergoes().remove(undergoe);
		undergoe.setPhysicianBean(null);

		return undergoe;
	}

}