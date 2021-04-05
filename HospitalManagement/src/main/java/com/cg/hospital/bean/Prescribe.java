package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the prescribes database table.
 * 
 */
@Entity
@Table(name="prescribes")
@NamedQuery(name="Prescribe.findAll", query="SELECT p FROM Prescribe p")
public class Prescribe implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrescribePK id;

	private String dose;

	//bi-directional many-to-one association to Appointment
	@ManyToOne
	@JoinColumn(name="Appointment", insertable=false, updatable=false)
	private Appointment appointmentBean;

	//bi-directional many-to-one association to Medication
	@ManyToOne
	@JoinColumn(name="Medication", insertable=false, updatable=false)
	private Medication medicationBean;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="Patient", insertable=false, updatable=false)
	private Patient patientBean;

	//bi-directional many-to-one association to Physician
	@ManyToOne
	@JoinColumn(name="Physician", insertable=false, updatable=false)
	private Physician physicianBean;

	public Prescribe() {
	}

	public PrescribePK getId() {
		return this.id;
	}

	public void setId(PrescribePK id) {
		this.id = id;
	}

	public String getDose() {
		return this.dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	@JsonBackReference(value = "appointment-prescribe")
	public Appointment getAppointmentBean() {
		return this.appointmentBean;
	}

	public void setAppointmentBean(Appointment appointmentBean) {
		this.appointmentBean = appointmentBean;
	}
	@JsonBackReference(value = "medication-prescribe")
	public Medication getMedicationBean() {
		return this.medicationBean;
	}

	public void setMedicationBean(Medication medicationBean) {
		this.medicationBean = medicationBean;
	}
	@JsonBackReference(value = "patient-prescribe")
	public Patient getPatientBean() {
		return this.patientBean;
	}

	public void setPatientBean(Patient patientBean) {
		this.patientBean = patientBean;
	}
	@JsonBackReference(value = "physician-prescribe")
	public Physician getPhysicianBean() {
		return this.physicianBean;
	}

	public void setPhysicianBean(Physician physicianBean) {
		this.physicianBean = physicianBean;
	}

}