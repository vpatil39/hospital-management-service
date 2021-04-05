package com.cg.hospital.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * The persistent class for the procedures database table.
 * 
 */
@Entity
@Table(name = "procedures")
@NamedQuery(name = "Procedure.findAll", query = "SELECT p FROM Procedure p")
public class Procedure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private double cost;

	private String name;

	// bi-directional many-to-one association to TrainedIn
	@OneToMany(mappedBy = "procedure")
	private List<TrainedIn> trainedIns;

	// bi-directional many-to-one association to Undergoe
	@OneToMany(mappedBy = "procedure")
	private List<Undergoe> undergoes;

	public Procedure() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonManagedReference(value = "procedure-trainedIn")
	public List<TrainedIn> getTrainedIns() {
		return this.trainedIns;
	}

	public void setTrainedIns(List<TrainedIn> trainedIns) {
		this.trainedIns = trainedIns;
	}

	public TrainedIn addTrainedIn(TrainedIn trainedIn) {
		getTrainedIns().add(trainedIn);
		trainedIn.setProcedure(this);

		return trainedIn;
	}

	public TrainedIn removeTrainedIn(TrainedIn trainedIn) {
		getTrainedIns().remove(trainedIn);
		trainedIn.setProcedure(null);

		return trainedIn;
	}

	@JsonManagedReference(value = "procedure-undergoes")
	public List<Undergoe> getUndergoes() {
		return this.undergoes;
	}

	public void setUndergoes(List<Undergoe> undergoes) {
		this.undergoes = undergoes;
	}

	public Undergoe addUndergoe(Undergoe undergoe) {
		getUndergoes().add(undergoe);
		undergoe.setProcedure(this);

		return undergoe;
	}

	public Undergoe removeUndergoe(Undergoe undergoe) {
		getUndergoes().remove(undergoe);
		undergoe.setProcedure(null);

		return undergoe;
	}

}