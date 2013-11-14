package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.util.StatusE;

public interface LendingProcessService {

	void createLendingProcess(Borrower borrower, Publication publication,
			Date issueDate);

	void endLendingProcess(long lendingProcessID);

	void extendLendingProcess(long lendingProcessID);

	/*
	 * void updateDunningLevel(long lendingProcessID);
	 */
	/*
	 * void deleteLendingProcess(long lendingProcessID);
	 */

	void updateLendingProcess(long lendingProcessID, Borrower borrower,
			Publication publication, Date issueDate, Date returnDate,
			int extensionOfTimeLevel, StatusE status);

	LendingProcess findLendingProcessById(long lendingProcessID);

	List<LendingProcess> listLendingProcess();

	List<LendingProcess> findDunnedLendingProcesses();

	List<LendingProcess> findActiveLendingProcesses();

	void dunLendingProcesses();

}
