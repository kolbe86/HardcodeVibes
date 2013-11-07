package de.nak.librarymgmt.service;

import java.util.Date;

import de.nak.librarymgmt.model.Borrower;

public interface LendingProcessService {

	void createLendingProcess(Date issueDate, Date returnDate,
			int ExtensionOfTimeLevel);

}
