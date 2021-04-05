package com.cg.hospital.exceptions;


	public class PhysicianNotFoundException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PhysicianNotFoundException(String error) {
			super(error);
		}

		public PhysicianNotFoundException() {
		};
}
