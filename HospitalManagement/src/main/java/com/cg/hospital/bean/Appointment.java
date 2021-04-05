package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the appointment database table.
 * 
 */
@Entity
@NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Lob
	private String examinationRoom;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	// bi-directional many-to-one association to Nurse
	@ManyToOne
	@JoinColumn(name = "PrepNurse")
	private Nurse nurse;

	// bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name = "Patient")
	private Patient patientBean;

	// bi-directional many-to-one association to Physician
	@ManyToOne
	@JoinColumn(name = "Physician")
	private Physician physicianBean;

	// bi-directional many-to-one association to Prescribe
	@OneToMany(mappedBy = "appointmentBean")
	private List<Prescribe> prescribes;

	public Appointment() {
	}

	public int getAppointmentID() {
		return this.appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	

	public String getExaminationRoom() {
		return this.examinationRoom;
	}

	public void setExaminationRoom(String examinationRoom) {
		this.examinationRoom = examinationRoom;
	}

	

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonBackReference(value = "nurse-appointment")
	public Nurse getNurse() {
		return this.nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	@JsonBackReference(value = "patient-appointment")
	public Patient getPatientBean() {
		return this.patientBean;
	}

	public void setPatientBean(Patient patientBean) {
		this.patientBean = patientBean;
	}

	@JsonBackReference(value = "physician-appointment")
	public Physician getPhysicianBean() {
		return this.physicianBean;
	}

	public void setPhysicianBean(Physician physicianBean) {
		this.physicianBean = physicianBean;
	}

	@JsonManagedReference(value = "appointment-prescribe")
	public List<Prescribe> getPrescribes() {
		return this.prescribes;
	}

	public void setPrescribes(List<Prescribe> prescribes) {
		this.prescribes = prescribes;
	}

	public Prescribe addPrescribe(Prescribe prescribe) {
		getPrescribes().add(prescribe);
		prescribe.setAppointmentBean(this);

		return prescribe;
	}

	public Prescribe removePrescribe(Prescribe prescribe) {
		getPrescribes().remove(prescribe);
		prescribe.setAppointmentBean(null);

		return prescribe;
	}

}