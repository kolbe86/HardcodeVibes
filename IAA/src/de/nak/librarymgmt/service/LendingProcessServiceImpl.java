package de.nak.librarymgmt.service;

import java.util.Date;

import de.nak.librarymgmt.dao.LendingProcessDAO;
import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.service.BorrowerService;

public class LendingProcessServiceImpl implements LendingProcessService {

	private LendingProcessDAO lendingProcessDAO;
	private BorrowerService borrowerService;

	public void createLendingProcess(Date issueDate,
			Date returnDate, int extensionOfTimeLevel) {
		LendingProcess lendingProcess = new LendingProcess();
/*
 * 		lendingProcess.setBorrower(borrower);
 */
		lendingProcess.setIssueDate(issueDate);
		lendingProcess.setReturnDate(returnDate);
		lendingProcess.setExtensionOfTimeLevel(extensionOfTimeLevel);
/*
 * 		borrowerService.addLendingProcess(lendingProcess, borrower);
 */
		try {
			System.out.println("Try LendingProcessDAO.save");
			lendingProcessDAO.save(lendingProcess);
		} catch (Exception e) {
			// TODO
		}

	}

	public LendingProcessDAO getLendingProcessDAO() {
		return lendingProcessDAO;
	}

	public void setLendingProcessDAO(LendingProcessDAO lendingProcessDAO) {
		this.lendingProcessDAO = lendingProcessDAO;
	}

}
