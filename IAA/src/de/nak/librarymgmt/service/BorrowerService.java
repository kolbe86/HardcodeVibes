package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;

public interface BorrowerService {

	void createBorrower(String firstName, String lastName);

	void deleteBorrower(Long id);

	void updateBorrower(Long id, String firstName, String lastName);

	List<Borrower> listBorrowers();
	/*
	 * void addLendingProcess(LendingProcess lendingProcess, Borrower borrower);
	 */

}
