package com.cg.hospital.service;

import java.util.List;

import com.cg.hospital.bean.Patient;

public interface IPatientService {

	public Patient addPatient(Patient patient);
	public String removePatient(Integer ssn);
	public Patient updatePatient(Integer ssn, Patient patient);
	public Patient getPatientBySsn(Integer ssn);
	public List<Patient> getAllPatients();
	
}
