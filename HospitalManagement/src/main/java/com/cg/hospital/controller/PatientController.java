package com.cg.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.bean.Patient;
import com.cg.hospital.bean.User;
import com.cg.hospital.enums.UserRoles;
import com.cg.hospital.payloads.BaseResponse;
import com.cg.hospital.service.IPatientService;
import com.cg.hospital.serviceImpl.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/patient")
@Api(value = "Patient Module", description = "Operations on Patients")
public class PatientController {

	@Autowired
	IPatientService patientService;

	@Autowired
	UserServiceImpl userService;

	@PostMapping("/add")
	@ApiOperation(value = "Add a new Patient")
	public ResponseEntity<?> savePatient(@Valid @RequestBody Patient patient) {
		User user = patient.getUser();
		user.setRole(UserRoles.PATIENT);
		user.setEnabled(true);
		//user = userService.saveUser(user);
		patient.setUser(user);
		patient = patientService.addPatient(patient);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(patient);
		return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	@ApiOperation(value = "Show all Patients")
	public ResponseEntity<?> getAllPatients() {
		List<Patient> patients = patientService.getAllPatients();
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(patients);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	@ApiOperation(value = "Remove a Patient")
	public ResponseEntity<?> deletePatientByCardId(@PathVariable("userId") int userId) {

		User user = userService.findUserById(userId).get();
		Patient retrivedPatient = user.getPatient();
		patientService.removePatient(retrivedPatient.getSsn());
	//	patientService.removePatient(userId);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse("Patient deleted");
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

//	@PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
	@PutMapping("/update/{userId}")
	@ApiOperation(value = "Update a Patient")
	public ResponseEntity<?> updatePatient(@PathVariable("userId") int userId, @Valid @RequestBody Patient patient) {
		User user = userService.findUserById(userId).get();
		int retrivedPatient = user.getPatient().getSsn();
		Patient patientNew = patientService.updatePatient(retrivedPatient, patient);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(patientNew);
		return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
	}

//	@PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
	@GetMapping("/get/userId/{userId}")
	@ApiOperation(value = "Search a Patient with userId", response = Patient.class)
	public ResponseEntity<?> findPatientBySsn(@PathVariable("userId") int userId) {
	//	User user = userService.findUserById(userId).get();
		// Patient retrivedPatient=user.getPatient();
		// Patient patient=patientService.getPatientBySsn(retrivedPatient.getSsn());
		Patient patient = patientService.getPatientBySsn(userId);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(patient);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

}
