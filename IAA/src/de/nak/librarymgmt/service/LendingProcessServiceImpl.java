package de.nak.librarymgmt.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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

	@Override
	public void endLendingProcess(long lendingProcessID) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findById(lendingProcessID);
		try {
			lendingProcess.setStatus(StatusE.CLOSED);
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
	 * Brauchen wir lšschen?
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

	public void dunLendingProcesses() {
		List<LendingProcess> activeLendingProcesses = lendingProcessDAO
				.findActiveProcesses();
		Iterator iterator = activeLendingProcesses.iterator();
		int i = 0;
		while (iterator.hasNext() & i < activeLendingProcesses.size()) {
			LendingProcess lendingProcess = activeLendingProcesses.get(i);
			Date returnDate = lendingProcess.getReturnDate();
			long difference = returnDate.getTime() - new Date().getTime();
			long differenceInDate = difference / (24 * 60 * 60 * 1000);
			if (differenceInDate > 15) {
				activeLendingProcesses.get(i).setDunningLevel(
						DunningLevelE.THIRD);
				lendingProcessDAO.save(lendingProcess);
				iterator.next();
				i = i + 1;
			}
			if (differenceInDate > 8) {
				activeLendingProcesses.get(i).setDunningLevel(
						DunningLevelE.SECOND);
				lendingProcessDAO.save(lendingProcess);

				iterator.next();
				i = i + 1;
			}
			if (differenceInDate > 1) {
				activeLendingProcesses.get(i).setDunningLevel(
						DunningLevelE.FIRST);
				lendingProcessDAO.save(lendingProcess);
				iterator.next();
				i = i + 1;
			} else {
				iterator.next();
				i = i + 1;
			}
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

	private Date calculateReturnDate(Date issueDate) {
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
}
