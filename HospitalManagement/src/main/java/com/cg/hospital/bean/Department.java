package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int departmentID;

	private String name;

	// bi-directional many-to-one association to AffiliatedWith
	@OneToMany(mappedBy = "departmentBean")
	private List<AffiliatedWith> affiliatedWiths;

	// bi-directional many-to-one association to Physician
	@ManyToOne
	@JoinColumn(name = "Head")
	private Physician physician;

	public Department() {
	}

	public int getDepartmentID() {
		return this.departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonManagedReference(value="dept-affiliated")
	public List<AffiliatedWith> getAffiliatedWiths() {
		return this.affiliatedWiths;
	}

	public void setAffiliatedWiths(List<AffiliatedWith> affiliatedWiths) {
		this.affiliatedWiths = affiliatedWiths;
	}

	public AffiliatedWith addAffiliatedWith(AffiliatedWith affiliatedWith) {
		getAffiliatedWiths().add(affiliatedWith);
		affiliatedWith.setDepartmentBean(this);

		return affiliatedWith;
	}

	public AffiliatedWith removeAffiliatedWith(AffiliatedWith affiliatedWith) {
		getAffiliatedWiths().remove(affiliatedWith);
		affiliatedWith.setDepartmentBean(null);

		return affiliatedWith;
	}

	@JsonBackReference(value = "physician-department")
	public Physician getPhysician() {
		return this.physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

}