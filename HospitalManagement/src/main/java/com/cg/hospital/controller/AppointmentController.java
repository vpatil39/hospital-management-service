package com.cg.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.bean.Appointment;
import com.cg.hospital.payloads.BaseResponse;
import com.cg.hospital.service.IAppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/appointment")
@Api(value = "Appointment Module", description = "Operations on Appointments")
public class AppointmentController {
	@Autowired
	IAppointmentService appointmentService;

	@PostMapping("/add/{ssn}")
	@ApiOperation(value = "Add a new Appointment")
	public ResponseEntity<?> savePatient(@PathVariable("ssn") int ssn, @Valid @RequestBody Appointment appointment) {
		appointment = appointmentService.addAppointment(ssn, appointment);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(appointment);
		return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	@ApiOperation(value = "Show all Appointments")
	public ResponseEntity<?> getAllPatients() {
		List<Appointment> appointments = appointmentService.getAllAppointments();
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(appointments);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Remove an Appointment")
	public ResponseEntity<?> deletePatientByCardId(@PathVariable("id") int id) {
		appointmentService.removeAppointment(id);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse("Appointment deleted");
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	@ApiOperation(value = "Update an Appointment")
	public ResponseEntity<?> updatePatient(@PathVariable("id") int id, @Valid @RequestBody Appointment appointment) {
		appointment = appointmentService.updateAppointment(id, appointment);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(appointment);
		return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
	}

	@GetMapping("/get/id/{id}")
	@ApiOperation(value = "Search a Patient with an Id", response = Appointment.class)
	public ResponseEntity<?> findPatientBySsn(@PathVariable("id") int id) {
		Appointment appointment=appointmentService.getAppointmentById(id);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(appointment);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

}
