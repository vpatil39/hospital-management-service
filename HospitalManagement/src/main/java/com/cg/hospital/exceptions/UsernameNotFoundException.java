package com.cg.hospital.exceptions;

public class UsernameNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameNotFoundException(String error) {
		super(error);
	}

	public UsernameNotFoundException() {
	};
}
