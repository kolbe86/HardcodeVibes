package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;

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
	void createBorrower(String firstName, String lastName);

	/**
	 * Deletes an given Borrower entity.
	 * 
	 * @param borrowerID
	 *            , ID of the borrower that should be deleted.
	 * 
	 */
	void deleteBorrower(long borrowerID);

	/**
	 * Updates a borrower entity and stores the changes into the database.
	 *
	 * @param borrowerID
	 *            , ID of the borrower that should be updated.
	 * @param firstName, the first name of the borrower.
	 * @param lastName, the last name of the borrower.
	 */
	void updateBorrower(long borrowerID, String firstName, String lastName);

	void addLendingProcessToBorrower(long borrowerID, LendingProcess lendingProcess);
	
	void deleteLendingProcessFromBorrower(long borrowerID, LendingProcess lendingProcess);
	/**
	 * Returns the Borrower identified by the given id.
	 * 
	 * @param borrowerID
	 *            , ID of the borrower that should be found.
	 * @return the found borrower entity.
	 */
	Borrower findBorrowerById(long borrowerID);

	/**
	 * Lists all borrowers currently stored in the database.
	 * 
	 * @return a list of borrowers.
	 */
	List<Borrower> listBorrowers();

	/*
	 * void addLendingProcess(LendingProcess lendingProcess, Borrower borrower);
	 */

}
