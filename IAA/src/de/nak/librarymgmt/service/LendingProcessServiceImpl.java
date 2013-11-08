package de.nak.librarymgmt.service;

import java.util.Date;

import de.nak.librarymgmt.dao.LendingProcessDAO;
import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;

public class LendingProcessServiceImpl implements LendingProcessService {

	private LendingProcessDAO lendingProcessDAO;

	@Override
	public void createLendingProcess(Borrower borrower,
			Publication publication, Date issueDate, Date returnDate,
			int extensionOfTimeLevel, String state) {

		LendingProcess lendingProcess = new LendingProcess();
		lendingProcess.setBorrower(borrower);
		lendingProcess.setPublication(publication);
		lendingProcess.setIssueDate(issueDate);
		lendingProcess.setReturnDate(returnDate);
		lendingProcess.setExtensionOfTimeLevel(extensionOfTimeLevel);
		lendingProcess.setState(state);

		try {

			lendingProcessDAO.save(lendingProcess);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public LendingProcessDAO getLendingProcessDAO() {
		return lendingProcessDAO;
	}

	public void setLendingProcessDAO(LendingProcessDAO lendingProcessDAO) {
		this.lendingProcessDAO = lendingProcessDAO;
	}
}
