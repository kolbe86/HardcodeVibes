package de.nak.librarymgmt.model;

import java.io.Serializable;

/**
 * the borrower POJO
 */

public class Borrower implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * the matriculation number of the borrower
	 */
	private int matriculationNumber;
	/**
	 * names of the borrower
	 */
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(int matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

}
