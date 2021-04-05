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

import com.cg.hospital.bean.PhysiNameWithDeptName;
import com.cg.hospital.bean.Physician;
import com.cg.hospital.payloads.BaseResponse;
import com.cg.hospital.service.IPhysicianService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/physician")
@Api(value = "Physician Module", description = "Operations on Physicians")
public class PhysicianController {
	@Autowired
	private IPhysicianService service;

	// -----------------------

	// URL: http://localhost:8880/PhysicianService/add
	@PostMapping(value = "/add", consumes = "application/json")
	@ApiOperation(value = "Add a new Physician")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Physician physician) {
		physician = service.add(physician);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(physician);

		return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);

	}

	// ---------------------------------
	// URL: http://localhost:8880/PhysicianService/list
	@GetMapping(value = "/getall", produces = "application/json")
	@ApiOperation(value = "Show all Physicians")
	public ResponseEntity<?> listAllPhysicians() {
		List<Physician> physician = service.getAllPhysicians();
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(physician);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	// --------------------------------------------------------------------
	// URL: http://localhost:8880/PhysicianService/get?id=123
	@GetMapping(value = "/get{employeeId}", produces = "application/json")
	@ApiOperation(value = "Show  Physician by Id", response = Physician.class)
	public ResponseEntity<?> getPhysicianById(@PathVariable("employeeId") int employeeId) {
		Physician physician = service.findByPhysicianId(employeeId);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(physician);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

//-----------------------------------------------------------------		
	// URL: http://localhost:8880/PhysicianService/update
	@PutMapping(value = "/update/{employeeId}", consumes = "application/json")
	@ApiOperation(value = "Update a Physician")
	public ResponseEntity<?> updatePhysician(@PathVariable("employeeId") int employeeId,
			@Valid @RequestBody Physician physician) {
		physician = service.updatePhysician(employeeId, physician);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(physician);
		return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
	}

	// ------------------------------------------------------------------------------------------------------
	// URL:http://localhost:8880/PhysicianService/delete/id
	@DeleteMapping(value = "/delete/{employeeId}")
	@ApiOperation(value = "Delete Physician by id")
	public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") int employeeId) {
		service.deletePhysicianById(employeeId);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse("Physician's record deleted successfully");
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getAllPhysiWithDeptName}", produces = "application/json")
	@ApiOperation(value = "Show  Physician by Id", response = Physician.class)
	public ResponseEntity<?> getAllPhysicianWithDepartmentName() {
		List<PhysiNameWithDeptName> physician = service.findAllPhysicianWithDepartmentName();
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(physician);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}
}
