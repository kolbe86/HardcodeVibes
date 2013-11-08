package de.nak.librarymgmt.service;

import java.util.Date;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.Publication;

public interface LendingProcessService {

	void createLendingProcess(Borrower borrower, Publication publication,
			Date issueDate, Date returnDate, int extensionOfTimeLevel,
			String state);

}
