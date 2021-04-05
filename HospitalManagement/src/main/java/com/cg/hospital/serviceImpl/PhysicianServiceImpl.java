package com.cg.hospital.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.cg.hospital.bean.Department;
import com.cg.hospital.bean.PhysiNameWithDeptName;
import com.cg.hospital.bean.Physician;
import com.cg.hospital.constants.PhysicianConstants;
import com.cg.hospital.exceptions.InvalidPatientException;
import com.cg.hospital.exceptions.InvalidPhysicianException;
import com.cg.hospital.exceptions.PhysicianNotFoundException;
import com.cg.hospital.repository.PhysicianRepository;
import com.cg.hospital.service.IPhysicianService;

@Service
public class PhysicianServiceImpl implements IPhysicianService {
	@Autowired
	private PhysicianRepository repo;

//------------------------------------------------------------
	/*
	 * @Override
	 * 
	 * @Transactional public Physician add(Physician physician) { return
	 * repo.save(physician);
	 * 
	 * }
	 */
	public Physician add(Physician physician) {
		if (physician == null) {
			throw new InvalidPatientException(
					PhysicianConstants.INVALID_PHYSICIAN_CONST + "Please enter all the physician details");
		}
		Optional<Physician> checking = repo.findById(physician.getEmployeeID());
		if (checking.isPresent())
			throw new InvalidPatientException("Physician Already Exists");
		try {
			repo.save(physician);
		} catch (Exception e) {
			throw new InvalidPatientException(PhysicianConstants.INVALID_PHYSICIAN_CONST + e.getMessage());
		}
		return physician;

	}

//-----------------------------------------------------------------------------	
	/*
	 * @Override public List<Physician> getPhysicians() { List<Physician>
	 * physicians= repo.findAll();
	 * 
	 * return physicians; }
	 */
	@Override
	public List<Physician> getAllPhysicians() {
		List<Physician> physician = new ArrayList<>();
		for (Physician c : repo.findAll()) {
			physician.add(c);
		}
		if (physician.isEmpty()) {

			throw new PhysicianNotFoundException("No Physicians present in the database");
		}
		return physician;
	}

//-----------------------------------------------------------------------------
	/*
	 * @Override public Physician findByPhysicianId(int employeeId) { return
	 * repo.findById(employeeId).get(); }
	 */

	@Override
	public Physician findByPhysicianId(Integer employeeId) {
		if (employeeId == null)
			throw new InvalidPhysicianException(PhysicianConstants.INVALID_PHYSICIAN_CONST
					+ "Employee ID cannot be null.Please enter Employee Id.");
		Optional<Physician> checking = repo.findById(employeeId);
		if (!checking.isPresent()) {
			throw new PhysicianNotFoundException(
					PhysicianConstants.PHYSICIAN_NOT_FOUND_BY_EMPLOYEEID_CONST + employeeId);
		}
		Physician physician;
		try {
			physician = repo.findById(employeeId).get();
		} catch (Exception e) {
			throw new InvalidPhysicianException(PhysicianConstants.INVALID_PHYSICIAN_CONST + e.getMessage());
		}
		return physician;
	}

//------------------------------------------------------------------------------------
	/*
	 * @Override public void deletePhysicianById(int employeeId) {
	 * 
	 * repo.deleteById(employeeId); }
	 */
	@Override
	public String deletePhysicianById(Integer employeeId) {
		if (employeeId == null)
			throw new InvalidPhysicianException(PhysicianConstants.INVALID_PHYSICIAN_CONST
					+ "EmployeeId cannot be null.Please enter Physcian EmployeeID.");
		Optional<Physician> checking = repo.findById(employeeId);
		if (!checking.isPresent()) {
			throw new PhysicianNotFoundException(
					PhysicianConstants.PHYSICIAN_NOT_FOUND_BY_EMPLOYEEID_CONST + employeeId);
		}
		Physician physician = repo.findById(employeeId).get();
		try {
			repo.deleteById(employeeId);
		} catch (Exception e) {
			throw new InvalidPhysicianException(PhysicianConstants.INVALID_PHYSICIAN_CONST + e.getMessage());
		}

		return "Deleted Successfully";
	}

//------------------------------------------------------------------------------------------
	/*
	 * @Override public Physician updatePhysician(Physician physician) { Physician
	 * phy= repo.findById(physician.getEmployeeID()).get(); return
	 * repo.saveAndFlush(physician); }
	 */
	@Override
	public Physician updatePhysician(Integer employeeId, Physician physician) {
		int physicianEmployeeId = physician.getEmployeeID();
		if (physician == null || employeeId == null) {
			throw new InvalidPhysicianException(
					PhysicianConstants.INVALID_PHYSICIAN_CONST + "Please enter all the physician details");
		}

		else {
			Optional<Physician> checking = repo.findById(employeeId);
			if (!checking.isPresent()) {
				throw new PhysicianNotFoundException(
						PhysicianConstants.PHYSICIAN_NOT_FOUND_BY_EMPLOYEEID_CONST + employeeId);
			} else {
				Physician physicianFound = repo.findById(physicianEmployeeId).get();
				physicianFound = (physician);
				try {
					repo.save(physicianFound);
				} catch (Exception e) {
					throw new InvalidPhysicianException(PhysicianConstants.INVALID_PHYSICIAN_CONST + e.getMessage());
				}
			}
		}
		return physician;
	}
	

	@Override
	public List<PhysiNameWithDeptName> findAllPhysicianWithDepartmentName() {
		List<PhysiNameWithDeptName> physiNameWithDeptNames = new ArrayList<PhysiNameWithDeptName>();

		List<Physician> physician = repo.findAll();

		physiNameWithDeptNames = getPhysiNameWithDeptNames(physician);

		return physiNameWithDeptNames;

	}

	private List<PhysiNameWithDeptName> getPhysiNameWithDeptNames(List<Physician> physician) {
		return physician.stream().map(cpnwdn -> createPhysiNameWithDeptName(cpnwdn)).collect(Collectors.toList());

	}

	private PhysiNameWithDeptName createPhysiNameWithDeptName(Physician physician) {
		PhysiNameWithDeptName physiNameWithDeptName = new PhysiNameWithDeptName();
		List<Department> dname = physician.getDepartments();
		List<String> ldname = dname.stream().map(dn -> createList(dn)).collect(Collectors.toList());
		physiNameWithDeptName.setPhysicianName(physician.getName());
		physiNameWithDeptName.setPhysicianPosition(physician.getPosition());
		physiNameWithDeptName.setDeptName(ldname);
		return physiNameWithDeptName;
	}

	private String createList(Department dn) {
		return dn.getName();
	}
}
