package de.nak.librarymgmt.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 */

public class Borrower implements Serializable {

	private static final long serialVersionUID = 1L;
	private long borrowerID;
	private String firstName;
	private String lastName;
/*
 * 	private Set<LendingProcess> lendingProcesses;
 */




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

	public long getBorrowerID() {
		return borrowerID;
	}

	public void setBorrowerID(long borrowerID) {
		this.borrowerID = borrowerID;
	}

/*	public Set<LendingProcess> getLendingProcesses() {
		return lendingProcesses;
	}

	public void setLendingProcesses(Set<LendingProcess> lendingProcesses) {
		this.lendingProcesses = lendingProcesses;
	}
	*/
}
