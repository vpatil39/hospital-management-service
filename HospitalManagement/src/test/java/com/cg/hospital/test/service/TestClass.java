package com.cg.hospital.test.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.hospital.bean.Patient;
import com.cg.hospital.repository.PatientRepository;
import com.cg.hospital.serviceImpl.PatientServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestClass {
	
	@InjectMocks
	private PatientServiceImpl underTest;
	
	@Mock
	private PatientRepository patientRepository;

	@Test
	public void should_patient_add_in_repository() {
		Patient patient = dummyPatient();
		given(patientRepository.save(patient))
		  .willReturn(patient);
		Patient patient1 = underTest.addPatient(patient);
		
		verify(patientRepository).save(patient);
		assertEquals(patient.getAddress(), patient1.getAddress());
		
	}
	private Patient dummyPatient() {
		Patient patient = new Patient();
		patient.setSsn(1);
		patient.setAddress("Pune");
		return patient;
	}

}
