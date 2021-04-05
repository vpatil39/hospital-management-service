package com.cg.hospital.service;

import java.util.List;

import com.cg.hospital.bean.PhysiNameWithDeptName;
import com.cg.hospital.bean.Physician;

public interface IPhysicianService {

	public Physician add(Physician physician);

	public List<Physician> getAllPhysicians();

	public Physician findByPhysicianId(Integer employeeId);
	
	public String deletePhysicianById(Integer employeeId) ;

	public Physician updatePhysician(Integer employeeId , Physician physician);

	public List<PhysiNameWithDeptName> findAllPhysicianWithDepartmentName(); 
	
	

}
