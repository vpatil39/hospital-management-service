package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the trained_in database table.
 * 
 */
@Entity
@Table(name="trained_in")
@NamedQuery(name="TrainedIn.findAll", query="SELECT t FROM TrainedIn t")
public class TrainedIn implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrainedInPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date certificationDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date certificationExpires;

	//bi-directional many-to-one association to Physician
	@ManyToOne
	@JoinColumn(name="Physician", insertable=false, updatable=false)
	private Physician physicianBean;

	//bi-directional many-to-one association to Procedure
	@ManyToOne
	@JoinColumn(name="Treatment", insertable=false, updatable=false)
	private Procedure procedure;

	public TrainedIn() {
	}

	public TrainedInPK getId() {
		return this.id;
	}

	public void setId(TrainedInPK id) {
		this.id = id;
	}

	public Date getCertificationDate() {
		return this.certificationDate;
	}

	public void setCertificationDate(Date certificationDate) {
		this.certificationDate = certificationDate;
	}

	public Date getCertificationExpires() {
		return this.certificationExpires;
	}

	public void setCertificationExpires(Date certificationExpires) {
		this.certificationExpires = certificationExpires;
	}
	@JsonBackReference(value = "physician-trainedIn")
	public Physician getPhysicianBean() {
		return this.physicianBean;
	}

	public void setPhysicianBean(Physician physicianBean) {
		this.physicianBean = physicianBean;
	}
	@JsonBackReference(value = "procedure-trainedIn")
	public Procedure getProcedure() {
		return this.procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

}