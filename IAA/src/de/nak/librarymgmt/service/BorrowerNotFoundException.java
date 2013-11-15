package de.nak.librarymgmt.service;

public class BorrowerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BorrowerNotFoundException() {
		super();
	}

	public BorrowerNotFoundException(String message) {
		super(message);
	}
}
