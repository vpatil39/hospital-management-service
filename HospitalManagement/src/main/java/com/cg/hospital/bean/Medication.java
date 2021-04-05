package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * The persistent class for the medication database table.
 * 
 */
@Entity
@NamedQuery(name = "Medication.findAll", query = "SELECT m FROM Medication m")
public class Medication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private String brand;

	private String description;

	private String name;

	// bi-directional many-to-one association to Prescribe
	@OneToMany(mappedBy = "medicationBean")
	private List<Prescribe> prescribes;

	public Medication() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonManagedReference(value = "medication-prescribe")
	public List<Prescribe> getPrescribes() {
		return this.prescribes;
	}

	public void setPrescribes(List<Prescribe> prescribes) {
		this.prescribes = prescribes;
	}

	public Prescribe addPrescribe(Prescribe prescribe) {
		getPrescribes().add(prescribe);
		prescribe.setMedicationBean(this);

		return prescribe;
	}

	public Prescribe removePrescribe(Prescribe prescribe) {
		getPrescribes().remove(prescribe);
		prescribe.setMedicationBean(null);

		return prescribe;
	}

}