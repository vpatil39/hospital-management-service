package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the affiliated_with database table.
 * 
 */
@Entity
@Table(name="affiliated_with")
@NamedQuery(name="AffiliatedWith.findAll", query="SELECT a FROM AffiliatedWith a")
public class AffiliatedWith implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AffiliatedWithPK id;

	private byte primaryAffiliation;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="Department", insertable=false, updatable=false)
	private Department departmentBean;

	//bi-directional many-to-one association to Physician
	@ManyToOne
	@JoinColumn(name="Physician", insertable=false, updatable=false)
	private Physician physicianBean;

	public AffiliatedWith() {
	}

	public AffiliatedWithPK getId() {
		return this.id;
	}

	public void setId(AffiliatedWithPK id) {
		this.id = id;
	}

	public byte getPrimaryAffiliation() {
		return this.primaryAffiliation;
	}

	public void setPrimaryAffiliation(byte primaryAffiliation) {
		this.primaryAffiliation = primaryAffiliation;
	}

	@JsonBackReference(value="dept-affiliated")
	public Department getDepartmentBean() {
		return this.departmentBean;
	}

	public void setDepartmentBean(Department departmentBean) {
		this.departmentBean = departmentBean;
	}
	@JsonBackReference(value="phy-affiliated")
	public Physician getPhysicianBean() {
		return this.physicianBean;
	}

	public void setPhysicianBean(Physician physicianBean) {
		this.physicianBean = physicianBean;
	}

}