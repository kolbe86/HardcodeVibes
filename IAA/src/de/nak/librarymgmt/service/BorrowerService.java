package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.model.Borrower;

public interface BorrowerService {

	void createBorrower(String firstName, String lastName);

	void deleteBorrower(long borrowerID);

	void updateBorrower(long borrowerID, String firstName, String lastName);

	Borrower showBorrower(long borrowerID);

	List<Borrower> listBorrowers();
	/*
	 * void addLendingProcess(LendingProcess lendingProcess, Borrower borrower);
	 */

}
