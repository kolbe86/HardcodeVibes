package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.util.DunningLevelE;
import de.nak.librarymgmt.util.StatusE;

public interface LendingProcessService {

	void createLendingProcess(Borrower borrower, Publication publication,
			Date issueDate) throws PublicationNotFoundException,
			PublicationAlreadyDistributedException,
			PublicationAlreadyReservedException, BorrowerNotFoundException;

	void endLendingProcess(long lendingProcessID);

	void extendLendingProcess(long lendingProcessID);

	void deleteLendingProcess(long lendingProcessID);
	
	void deleteLendingProcessesWithGivenPublicationId(long publicationID);

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

	LendingProcess findLendingProcessByPublicationId(long publicationID);

	List<LendingProcess> listLendingProcess();

	List<LendingProcess> findDunnedLendingProcesses();

	List<LendingProcess> findActiveLendingProcesses();

	void dunLendingProcesses();
	
	void updateDunningLevelForLendingProcess(long lendingProcessID,
			DunningLevelE dunningLevel);

}
