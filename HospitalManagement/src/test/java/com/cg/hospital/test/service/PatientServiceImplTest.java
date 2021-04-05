package com.cg.hospital.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.hospital.bean.Patient;
import com.cg.hospital.repository.PatientRepository;
import com.cg.hospital.service.IPatientService;
import com.cg.hospital.serviceImpl.PatientServiceImpl;


//@RunWith(MockitoJUnitRunner.class)
public class PatientServiceImplTest {

	
	@InjectMocks
	private PatientServiceImpl underTest;
	
	@Mock
	private PatientRepository patientRepository;

	@Mock
	private IPatientService patientSer;

	
	@Test 
	public void should_patient_add_in_repository()
	{
		Patient patient = dummyPatient();
		
	
		underTest.addPatient(patient);
		verify(patientRepository).save(argThat(patientMatcher(patient)));
		//assertEquals(patient.getSsn(), patient1.getSsn());
	}

	private ArgumentMatcher<Patient> patientMatcher(Patient patient) {
		return pt -> Integer.toString(pt.getSsn()).equals(Integer.toString(patient.getSsn()));
	}

	//@Test 
	public void should_through_patient_add_in_repository()
	{
		Patient patient = dummyPatient();
		//Patient patient1 = underTest.addPatient(patient );
		//assertEquals(patient.getSsn(), patient1.getSsn());
	}
	
	
	private Patient dummyPatient() {
		Patient patient = new Patient();
		patient.setSsn(1);
		patient.setAddress("Pune");
		return patient;
	}


	//@Test
	public void getAllPatientsTest() {
		List<Patient> patients = new ArrayList<>();

		Patient p1 = new Patient();
		p1.setAddress("MUMBAI");
		p1.setInsuranceID(100);
		p1.setName("Rohit");
		p1.setPhone(1234567890);

		Patient p2 = new Patient();
		p2.setAddress("AMRITSAR");
		p2.setInsuranceID(200);
		p2.setName("Vritesh");
		p2.setPhone(1234567899);

		patients.add(p1);
		patients.add(p2);

		when(patientRepository.findAll()).thenReturn(patients);
		List<Patient> patientList = underTest.getAllPatients();

		assertEquals(2, patientList.size());
		verify(patientRepository, times(1)).findAll();

	}

//	@Test
	public void addPatientTest() {
		Patient p1 = new Patient();
		p1.setSsn(101);
		p1.setAddress("MUMBAI");
		p1.setInsuranceID(100);
		p1.setName("Rohit");
		p1.setPhone(1234567890);

//		when(patientRepository.findById(101)).thenReturn(Optional.of(p1));
//		when(patientRepository.save(p1)).thenReturn(p1);
//		when(patientRepository.findAll()).thenReturn(Stream.of(p1).collect(Collectors.toList()));
//		List<Patient> actual = patientService.getAllPatients();
//		assertEquals(1, actual.size());

		when(patientRepository.save(p1)).thenReturn(p1);
	//	assertEquals(p1, underTest.addPatient(p1));

	}

//	@Test
	public void removePatientTest() {
		final int ssn = 132;
		Patient p1 = new Patient();
		p1.setSsn(ssn);

		given(patientRepository.findById(ssn)).willReturn(Optional.of(p1));
		underTest.removePatient(ssn);
		underTest.removePatient(ssn);
		verify(patientRepository, times(2)).deleteById(ssn);

	}

	//@Test
	public void updatePatientTest() {
		Patient p1 = new Patient();
		p1.setSsn(101);
		p1.setAddress("MUMBAI");
		p1.setInsuranceID(100);
		p1.setName("Rohit");
		p1.setPhone(1234567890);

		given(patientRepository.findById(101)).willReturn(Optional.of(p1));
		given(patientRepository.save(p1)).willReturn(p1);
		Patient expectedPatient = underTest.updatePatient(p1.getSsn(), p1);
		assertThat(expectedPatient).isNotNull();
		//verify(patientRepository).save(any(Patient.class));
	}

	

}
