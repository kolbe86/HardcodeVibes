/**
 * 
 */
package de.nak.librarymgmt.model;

import java.util.Set;

/**
 * The Lender POJO.
 * 
 * @author Kowk Bond Chu
 */

public class Lender {
	// ------------------------------ FIELDS ------------------------------

	/** The identifier. */
	private Long id;
	/** The first name of the lender. */
	private String firstName;
	/** The last name of the lender. */
	private String lastName;
	/** The set of associated lending processes. */
	private Set<LendingProcess> lendingProcesses;

	// --------------------- GETTER / SETTER METHODS ---------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<LendingProcess> getLendingProcesses() {
		return lendingProcesses;
	}

	public void setLendingProcesses(Set<LendingProcess> lendingProcesses) {
		this.lendingProcesses = lendingProcesses;
	}

}
