package com.cg.hospital.exceptions;

public class PatientNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(String error) {
		super(error);
	}

	public PatientNotFoundException() {
	};

}
