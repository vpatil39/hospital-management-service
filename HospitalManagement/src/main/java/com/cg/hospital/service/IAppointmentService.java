package com.cg.hospital.service;

import java.util.List;

import com.cg.hospital.bean.Appointment;

public interface IAppointmentService {

	public Appointment addAppointment(Integer ssn,Appointment appointment);
	public Appointment removeAppointment(Integer appointmentID);
	public Appointment updateAppointment(Integer appointmentID, Appointment appointment);
	public Appointment getAppointmentById(Integer appointmentID);
	public List<Appointment> getAllAppointments();
}
