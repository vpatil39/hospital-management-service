package com.cg.hospital.exceptions;

public class InvalidPatientException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPatientException(String error) {
		super(error);
	}

	public InvalidPatientException() {
	};
}
