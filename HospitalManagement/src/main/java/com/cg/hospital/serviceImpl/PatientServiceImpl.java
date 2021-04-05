package com.cg.hospital.serviceImpl;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.bean.Patient;
import com.cg.hospital.constants.PatientConstants;
import com.cg.hospital.repository.PatientRepository;
import com.cg.hospital.service.IPatientService;
import com.cg.hospital.exceptions.InvalidPatientException;
import com.cg.hospital.exceptions.PatientNotFoundException;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient) {
		
		if (patient == null) {
			throw new InvalidPatientException(
					PatientConstants.INVALID_PATIENT_CONST + "Please enter all the patient details");
		}
		Optional<Patient> checking = patientRepository.findById(patient.getSsn());
		if (checking.isPresent())
			throw new InvalidPatientException("Patient Already Exists");
		try {
		patient =	patientRepository.save(patient);
		} catch (Exception e) {
			throw new InvalidPatientException(PatientConstants.INVALID_PATIENT_CONST + e.getMessage());
		}
		return patient;
	}

	@Override
	public String removePatient(Integer ssn) {
		if (ssn == null)
			throw new InvalidPatientException(
					PatientConstants.INVALID_PATIENT_CONST + "SSN cannot be null.Please enter patient SSN.");
		Optional<Patient> checking = patientRepository.findById(ssn);
		if (!checking.isPresent()) {
			throw new PatientNotFoundException(PatientConstants.PATIENT_NOT_FOUND_BY_SSN_CONST + ssn);
		}
	//	Patient patient = patientRepository.findById(ssn).get();
		try {
			patientRepository.deleteById(ssn);
		} catch (Exception e) {
			throw new InvalidPatientException(PatientConstants.INVALID_PATIENT_CONST + e.getMessage());
		}

		return "Patient's record deleted successfully";
	}

	@Override
	public Patient updatePatient(Integer ssn, Patient patient) {
		int patientssn = patient.getSsn();
		if (patient == null || ssn == null) {
			throw new InvalidPatientException(
					PatientConstants.INVALID_PATIENT_CONST + "Please enter all the patient details");
		}

		else {
			Optional<Patient> checking = patientRepository.findById(ssn);
			if (!checking.isPresent()) {
				throw new PatientNotFoundException(PatientConstants.PATIENT_NOT_FOUND_BY_SSN_CONST + ssn);
			} else {
				Patient patientFound = patientRepository.findById(patientssn).get();
				patientFound = (patient);
				try {
					patientRepository.save(patientFound);
				} catch (Exception e) {
					throw new InvalidPatientException(PatientConstants.INVALID_PATIENT_CONST + e.getMessage());
				}
			}
		}
		return patient;
	}

	@Override
	public Patient getPatientBySsn(Integer userId) {
		if (userId == null)
			throw new InvalidPatientException(
					PatientConstants.INVALID_PATIENT_CONST + "SSN cannot be null.Please enter patient SSN.");
		Optional<Patient> checking = patientRepository.findByUserId(userId);
		if (!checking.isPresent()) {
			throw new PatientNotFoundException(PatientConstants.PATIENT_NOT_FOUND_BY_SSN_CONST + userId);
		}
		Patient patient = null;
		try {
			patient = patientRepository.findByUserId(userId).get();
		} catch (Exception e) {
			throw new InvalidPatientException(PatientConstants.INVALID_PATIENT_CONST + e.getMessage());
		}
		return patient;
	}

	@Override
	public List<Patient> getAllPatients() {
		/*
		 * List<Patient> patients = new ArrayList<>(); for (Patient c :
		 * patientRepository.findAll()) { patients.add(c); } if (patients.isEmpty()) {
		 * 
		 * throw new PatientNotFoundException("No Patients present in the database"); }
		 */
		List<Patient> patients = patientRepository.findAll();
		
		if (patients.isEmpty()) {
		
			throw new PatientNotFoundException("No Patients present in the database");
		}
		return patients;
	}

}
