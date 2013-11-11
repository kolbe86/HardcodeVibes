package de.nak.librarymgmt.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;

import de.nak.librarymgmt.dao.LendingProcessDAO;
import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.util.StatusE;
import de.nak.librarymgmt.util.DunningLevelE;

public class LendingProcessServiceImpl implements LendingProcessService {

	private LendingProcessDAO lendingProcessDAO;
	private int loanPeriodInDays = 28;
	private Calendar calender = new GregorianCalendar();

	@Override
	public void createLendingProcess(Borrower borrower,
			Publication publication, Date issueDate) {
		LendingProcess lendingProcess = new LendingProcess();
		lendingProcess.setBorrower(borrower);
		lendingProcess.setPublication(publication);
		lendingProcess.setIssueDate(issueDate);
		lendingProcess.setReturnDate(calculateReturnDate(issueDate));
		lendingProcess.setExtensionOfTimeLevel(0);
		lendingProcess.setStatus(StatusE.OPEN);
		lendingProcess.setDunningLevel(DunningLevelE.ZERO);

		try {

			lendingProcessDAO.save(lendingProcess);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Date calculateReturnDate(Date issueDate) {
		calender.setTime(issueDate);
		calender.add(Calendar.DAY_OF_MONTH, loanPeriodInDays);
		return calender.getTime();
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

	/* fürs testen
	 * 
	 * 
	 */
	public void setDunningLevel(long lendingProcessID,
			DunningLevelE dunningLevel) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findById(lendingProcessID);
		try {
			lendingProcess.setDunningLevel(dunningLevel);
			;
		} catch (Exception e) {
			// TODO
		}
	}

	@Override
	public void extendLendingProcess(long lendingProcessID) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findById(lendingProcessID);
		try {
			if (lendingProcess.getExtensionOfTimeLevel() < 2) {
				lendingProcess.setExtensionOfTimeLevel(lendingProcess
						.getExtensionOfTimeLevel() + 1);
				lendingProcess.setReturnDate(calculateReturnDate(lendingProcess
						.getReturnDate()));
				lendingProcess.setDunningLevel(DunningLevelE.ZERO);
			}
		} catch (Exception e) {
			// TODO
		}
	}

	/*
	 * @Override public void updateDunningLevel(long lendingProcessID) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * 
	 * Brauchen wir löschen?
	 * 
	 * @Override public void deleteLendingProcess(long lendingProcessID) {
	 * LendingProcess lendingProcess = lendingProcessDAO
	 * .findById(lendingProcessID); try {
	 * System.out.println("Try lendingProcessDAO.delete");
	 * lendingProcessDAO.delete(lendingProcess); } catch (Exception e) { // TODO
	 * }
	 * 
	 * }
	 */
	@Override
	public void updateLendingProcess(long lendingProcessID, Borrower borrower,
			Publication publication, Date issueDate, Date returnDate,
			int extensionOfTimeLevel, StatusE status) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findById(lendingProcessID);
		try {
			lendingProcess.setBorrower(borrower);
			lendingProcess.setPublication(publication);
			lendingProcess.setIssueDate(issueDate);
			lendingProcess.setReturnDate(returnDate);
			lendingProcess.setExtensionOfTimeLevel(extensionOfTimeLevel);
			lendingProcess.setStatus(status);
			;
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

	@Override
	public List<LendingProcess> findDunnedLendingProcesses() {
		return lendingProcessDAO.findDunnedProcesses();
	}

	@Override
	public List<LendingProcess> findActiveLendingProcesses() {
		return lendingProcessDAO.findActiveProcesses();
	}
}
