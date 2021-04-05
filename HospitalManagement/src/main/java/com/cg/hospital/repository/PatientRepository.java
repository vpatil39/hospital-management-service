package com.cg.hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hospital.bean.Patient;
import com.cg.hospital.bean.Appointment;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	public List<Appointment> findAllAppointmentsBySsn(int ssn);

	@Query (value ="select * from Patient where user_Id= :userId ",nativeQuery = true)
	public Optional<Patient> findByUserId(Integer userId);
	
}
