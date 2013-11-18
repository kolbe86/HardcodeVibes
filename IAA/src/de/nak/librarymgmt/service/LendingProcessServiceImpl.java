package de.nak.librarymgmt.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import de.nak.librarymgmt.dao.LendingProcessDAO;
import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.util.DunningLevelE;
import de.nak.librarymgmt.util.StatusE;

/**
 * the implementation of the lending process service
 */
public class LendingProcessServiceImpl implements LendingProcessService {

	/**
	 * initialization of the lending process DAO
	 */
	private LendingProcessDAO lendingProcessDAO;
	/**
	 * the given loan period in days
	 */
	private static final int loanPeriodInDays = 28;
	/**
	 * the given days for the dunning levels of lending processes
	 */
	private static final int daysForFirstDunning = 1;
	private static final int daysForSecondDunning = 8;
	private static final int daysForThirdDunning = 15;

	/**
	 * initialization of a calender
	 */
	private Calendar calender = new GregorianCalendar();

	/**
	 * creates and stores a new lending process entity
	 * 
	 * @param borrower
	 *            , publication, issueDate
	 */
	@Override
	public void createLendingProcess(Borrower borrower,
			Publication publication, Date issueDate)
			throws PublicationNotFoundException,
			PublicationAlreadyDistributedException, BorrowerNotFoundException {

		LendingProcess lendingProcess = new LendingProcess();
		lendingProcess.setBorrower(borrower);
		lendingProcess.setPublication(publication);
		lendingProcess.setIssueDate(issueDate);
		lendingProcess.setReturnDate(calculateReturnDate(issueDate));
		lendingProcess.setExtensionOfTimeLevel(0);
		lendingProcess.setStatus(StatusE.OPEN);
		lendingProcess.setDunningLevel(DunningLevelE.ZERO);

		if ((lendingProcess.getPublication() == null)) {
			throw new PublicationNotFoundException();
		} else if (lendingProcess.getPublication().isDistributed()) {
			throw new PublicationAlreadyDistributedException();
		} else if (lendingProcess.getBorrower() == null) {
			throw new BorrowerNotFoundException();
		} else {
			lendingProcessDAO.createOrUpdate(lendingProcess);
		}

		lendingProcessDAO.createOrUpdate(lendingProcess);
	}

	/**
	 * ends a lending process by given lending processID
	 * 
	 * @param lendingProcessID
	 */
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

	/**
	 * extends a lending process by given lendingProcessID
	 * 
	 * @param lendingProcessID
	 */
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

	/**
	 * deletes a lending process by given lendingProcessID
	 * 
	 * @param lendingProcessID
	 */
	@Override
	public void deleteLendingProcess(long lendingProcessID) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findById(lendingProcessID);
		try {
			System.out.println("Try lendingProcessDAO.delete");
			lendingProcessDAO.delete(lendingProcess);
		} catch (Exception e) { // TODO
		}

	}

	/**
	 * duns automatically all active lending processes by the given dunning
	 * periods
	 * 
	 */

	public void dunLendingProcesses() {
		List<LendingProcess> activeLendingProcesses = lendingProcessDAO
				.findActiveProcesses();
		Iterator<LendingProcess> iterator = activeLendingProcesses.iterator();
		int i = 0;
		while (iterator.hasNext() & i < activeLendingProcesses.size()) {
			LendingProcess lendingProcess = activeLendingProcesses.get(i);
			Date returnDate = lendingProcess.getReturnDate();
			long difference = new Date().getTime() - returnDate.getTime();
			long differenceInDate = difference / (24 * 60 * 60 * 1000);
			if (differenceInDate > daysForThirdDunning) {
				activeLendingProcesses.get(i).setDunningLevel(
						DunningLevelE.THIRD);

				lendingProcessDAO.createOrUpdate(lendingProcess);
				iterator.next();
				i = i + 1;
			}
			if (differenceInDate > daysForSecondDunning) {
				activeLendingProcesses.get(i).setDunningLevel(
						DunningLevelE.SECOND);
				lendingProcessDAO.createOrUpdate(lendingProcess);

				iterator.next();
				i = i + 1;
			}
			if (differenceInDate > daysForFirstDunning) {
				activeLendingProcesses.get(i).setDunningLevel(
						DunningLevelE.FIRST);
				lendingProcessDAO.createOrUpdate(lendingProcess);
				iterator.next();
				i = i + 1;
			} else {
				iterator.next();
				i = i + 1;
			}
		}
	}

	/**
	 * finds a lending process by given lending process id
	 * 
	 * @param lendingProcessID
	 * @return LendingProcess
	 */
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

	/**
	 * finds lending process by given publicationID
	 * 
	 * @param publicationID
	 * @return LendingProcess
	 */
	@Override
	public LendingProcess findLendingProcessByPublicationId(long publicationID) {
		LendingProcess lendingProcess = lendingProcessDAO
				.findByPublication(publicationID);
		return lendingProcess;
	}

	/**
	 * deletes lending process by given publicationID
	 * 
	 * @param publicationID
	 */
	@Override
	public void deleteLendingProcessesWithGivenPublicationId(long publicationID) {
		lendingProcessDAO
				.deleteAllLendingProcessesWithLostPublication(publicationID);
	}

	/**
	 * list all lending processes
	 * 
	 * @return list of Lending Processes
	 */
	@Override
	public List<LendingProcess> listLendingProcesses() {
		return lendingProcessDAO.findAll();
	}

	/**
	 * list all dunned lending processes
	 * 
	 * @return list of Lending Processes
	 */
	@Override
	public List<LendingProcess> findDunnedLendingProcesses() {
		return lendingProcessDAO.findDunnedProcesses();
	}

	/**
	 * finds all active lending processes @ list of Lending Processes
	 */
	@Override
	public List<LendingProcess> findActiveLendingProcesses() {
		return lendingProcessDAO.findActiveProcesses();
	}

	/**
	 * calculates the return date automatically by given loan period
	 * 
	 * @param issueDate
	 * @return Date
	 */
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
