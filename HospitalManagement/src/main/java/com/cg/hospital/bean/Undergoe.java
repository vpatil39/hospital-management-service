package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the undergoes database table.
 * 
 */
@Entity
@Table(name="undergoes")
@NamedQuery(name="Undergoe.findAll", query="SELECT u FROM Undergoe u")
public class Undergoe implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UndergoePK id;

	//bi-directional many-to-one association to Nurse
	@ManyToOne
	@JoinColumn(name="AssistingNurse", insertable=false, updatable=false)
	private Nurse nurse;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="Patient", insertable=false, updatable=false)
	private Patient patientBean;

	//bi-directional many-to-one association to Physician
	@ManyToOne
	@JoinColumn(name="Physician", insertable=false, updatable=false)
	private Physician physicianBean;

	//bi-directional many-to-one association to Procedure
	@ManyToOne
	@JoinColumn(name="Procedures", insertable=false, updatable=false)
	private Procedure procedure;

	//bi-directional many-to-one association to Stay
	@ManyToOne
	@JoinColumn(name="Stay", insertable=false, updatable=false)
	private Stay stayBean;

	public Undergoe() {
	}

	public UndergoePK getId() {
		return this.id;
	}

	public void setId(UndergoePK id) {
		this.id = id;
	}
	@JsonBackReference(value = "nurse-undergoes")
	public Nurse getNurse() {
		return this.nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}
	@JsonBackReference(value = "patient-undergoes")
	public Patient getPatientBean() {
		return this.patientBean;
	}

	public void setPatientBean(Patient patientBean) {
		this.patientBean = patientBean;
	}
	@JsonBackReference(value = "physician-undergoes")
	public Physician getPhysicianBean() {
		return this.physicianBean;
	}

	public void setPhysicianBean(Physician physicianBean) {
		this.physicianBean = physicianBean;
	}
	@JsonBackReference(value = "procedure-undergoes")
	public Procedure getProcedure() {
		return this.procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
	@JsonBackReference(value = "stay-undergoes")
	public Stay getStayBean() {
		return this.stayBean;
	}

	public void setStayBean(Stay stayBean) {
		this.stayBean = stayBean;
	}

}