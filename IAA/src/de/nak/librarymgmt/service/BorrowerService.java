package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.model.Borrower;

/**
 * The Borrower service interface.
 * 
 * @author Kowk Bond Chu
 */
public interface BorrowerService {

	/**
	 * Creates and stores a new Borrower entity.
	 * 
	 * @param firstName
	 *            , first name of the borrower.
	 * @param lastName
	 *            , last name of the borrower.
	 */
	void createBorrower(int matriculationNumber, String firstName,
			String lastName) throws Exception;

	/**
	 * Deletes an given Borrower entity.
	 * 
	 * @param borrowerID
	 *            , ID of the borrower that should be deleted.
	 * 
	 */
	void deleteBorrower(int matriculationNumber);

	/**
	 * Updates a borrower entity and stores the changes into the database.
	 * 
	 * @param borrowerID
	 *            , ID of the borrower that should be updated.
	 * @param firstName
	 *            , the first name of the borrower.
	 * @param lastName
	 *            , the last name of the borrower.
	 */
	void updateBorrower(int matriculationNumber, String firstName,
			String lastName);

	/**
	 * Returns the Borrower identified by the given id.
	 * 
	 * @param borrowerID
	 *            , ID of the borrower that should be found.
	 * @return the found borrower entity.
	 */
	Borrower findBorrowerByMatriculationNumber(int matriculationNumber);

	List<Borrower> findBorrowerByMatriculationNumberList(int matriculationNumber);
	/**
	 * Lists all borrowers currently stored in the database.
	 * 
	 * @return a list of borrowers.
	 */
	List<Borrower> listBorrowers();

	List<Borrower> findBorrowersByNames(String firstName, String lastName);

	/*
	 * void addLendingProcess(LendingProcess lendingProcess, Borrower borrower);
	 */

}
