package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;

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

	@Override
	public void endLendingProcess(long lendingProcessID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extendLendingProcess(long lendingProcessID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDunningLevel(long lendingProcessID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLendingProcess(long lendingProcessID) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findById(lendingProcessID);
		try {
			System.out.println("Try lendingProcessDAO.delete");
			lendingProcessDAO.delete(lendingProcess);
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void updateLendingProcess(long lendingProcessID, Borrower borrower,
			Publication publication, Date issueDate, Date returnDate,
			int extensionOfTimeLevel, String state) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findById(lendingProcessID);
		try {
			lendingProcess.setBorrower(borrower);
			lendingProcess.setPublication(publication);
			lendingProcess.setIssueDate(issueDate);
			lendingProcess.setReturnDate(returnDate);
			lendingProcess.setExtensionOfTimeLevel(extensionOfTimeLevel);
			lendingProcess.setState(state);
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public LendingProcess findLendingProcessById(long lendingProcessID) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findById(lendingProcessID);
		try {
			return lendingProcess;
		} catch (Exception e) {
			return null; // TODO
		}
	}

	@Override
	public List<LendingProcess> listLendingProcess() {
		return lendingProcessDAO.findAll();
	}
}
