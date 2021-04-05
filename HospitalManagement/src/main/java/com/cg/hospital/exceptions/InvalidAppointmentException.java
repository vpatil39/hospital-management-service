package com.cg.hospital.exceptions;

public class InvalidAppointmentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAppointmentException(String error) {
		super(error);
	}

	public InvalidAppointmentException() {
	};
}
