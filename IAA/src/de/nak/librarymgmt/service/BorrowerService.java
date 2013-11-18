package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.model.Borrower;

/**
 * the Borrower service interface
 */
public interface BorrowerService {

	/**
	 * creates and stores a new borrower entity or updates firstname and
	 * lastname of an existing one
	 * 
	 * @param matriculationNumber
	 *            , firstName, lastName
	 */
	void createOrUpdateBorrower(int matriculationNumber, String firstName,
			String lastName);

	/**
	 * deletes a given borrower entity
	 * 
	 * @param borrowerID
	 */
	void deleteBorrower(int matriculationNumber);

	/**
	 * returns the Borrower identified by the given id
	 * 
	 * @param borrowerID
	 * @return the found borrower entity
	 */
	Borrower findBorrowerByMatriculationNumber(int matriculationNumber);

	/**
	 * lists all borrowers currently stored in the database
	 * 
	 * @return a list of borrowers.
	 */
	List<Borrower> listBorrowers();

	// List<Borrower> findBorrowersByNames(String firstName, String lastName);

}
