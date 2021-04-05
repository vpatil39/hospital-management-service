package com.cg.hospital.exceptions;

public class InvalidPhysicianException  extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;

	public InvalidPhysicianException(String error) {
		super(error);
	}

	public InvalidPhysicianException() {
	};

}
