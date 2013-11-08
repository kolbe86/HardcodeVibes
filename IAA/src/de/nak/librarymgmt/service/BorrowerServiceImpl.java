package de.nak.librarymgmt.service;

import java.util.List;


import de.nak.librarymgmt.dao.BorrowerDAO;
import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;

public class BorrowerServiceImpl implements BorrowerService {

	private BorrowerDAO borrowerDAO;

	public void createBorrower(String firstName, String lastName) {
		Borrower borrower = new Borrower();
		borrower.setFirstName(firstName);
		borrower.setLastName(lastName);
		try {
			System.out.println("Try borrowerDAO.save");
			borrowerDAO.save(borrower);
		} catch (Exception e) {
			// TODO
		}

	}

	public void deleteBorrower(long borrowerID) {
		Borrower borrower = borrowerDAO.findById(borrowerID);
		try {
			System.out.println("Try borrowerDAO.delete");
			borrowerDAO.delete(borrower);
		} catch (Exception e) {
			// TODO
		}

	}

	public void updateBorrower(long borrowerID, String firstName,
			String lastName) {
		Borrower borrower = borrowerDAO.findById(borrowerID);
		try {
			borrower.setFirstName(firstName);
			borrower.setLastName(lastName);
		} catch (Exception e) {
			// TODO
		}
	}

	public List<Borrower> listBorrowers() {
		return borrowerDAO.findAll();
	}

	public BorrowerDAO getBorrowerDAO() {
		return borrowerDAO;
	}

	public void setBorrowerDAO(BorrowerDAO borrowerDAO) {
		this.borrowerDAO = borrowerDAO;
	}

	public Borrower findBorrowerById(long borrowerID) {
		Borrower borrower = borrowerDAO.findById(borrowerID);
		try {
			return borrower;
		} catch (Exception e) {
			return null; // TODO
		}
	}

	@Override
	public void addLendingProcessToBorrower(long borrowerID,
			LendingProcess lendingProcess) {
		Borrower borrower = borrowerDAO.findById(borrowerID);
		try {
			borrower.getLendingProcesses().add(lendingProcess);
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void deleteLendingProcessFromBorrower(long borrowerID,
			LendingProcess lendingProcess) {
		Borrower borrower = borrowerDAO.findById(borrowerID);
		try {
			borrower.getLendingProcesses().remove(lendingProcess);
		} catch (Exception e) {
			// TODO
		}

	}

	/*
	 * public void addLendingProcess(LendingProcess lendingProcess, Borrower
	 * borrower) { borrower.getLendingProcesses().add(lendingProcess); try {
	 * System.out.println("Try borrowerDAO.addLendingProcess");
	 * borrowerDAO.save(borrower); } catch (Exception e) { // TODO }
	 * 
	 * }
	 */
}
