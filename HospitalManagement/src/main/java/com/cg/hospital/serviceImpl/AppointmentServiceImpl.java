package com.cg.hospital.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.bean.Appointment;
import com.cg.hospital.bean.Patient;
import com.cg.hospital.constants.AppointmentConstants;
import com.cg.hospital.repository.AppointmentRepository;
import com.cg.hospital.repository.PatientRepository;
import com.cg.hospital.service.IAppointmentService;
import com.cg.hospital.exceptions.InvalidAppointmentException;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public Appointment addAppointment(Integer ssn, Appointment appointment) {
		if (appointment == null || ssn == null)
		{
			throw new InvalidAppointmentException(AppointmentConstants.INVALID_APPOINTMENT_CONST
					+ "Please enter all the appointment details with the patient ssn.");
		}
		Patient patient = patientRepository.findById(ssn).get();

		Optional<Appointment> checking = appointmentRepository.findById(appointment.getAppointmentID());
		if (checking.isPresent())
			throw new InvalidAppointmentException("Appointment Already Exists");

		try {
			appointment.setPatientBean(patient);
			appointmentRepository.save(appointment);
		} catch (Exception e) {
			throw new InvalidAppointmentException(AppointmentConstants.INVALID_APPOINTMENT_CONST + e.getMessage());
		}
		
		return appointment;
	}

	@Override
	public Appointment removeAppointment(Integer appointmentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment updateAppointment(Integer appointmentID, Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment getAppointmentById(Integer appointmentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return null;
	}

}
