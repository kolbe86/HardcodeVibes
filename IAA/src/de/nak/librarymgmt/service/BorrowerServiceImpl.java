package de.nak.librarymgmt.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import de.nak.librarymgmt.dao.BorrowerDAO;
import de.nak.librarymgmt.model.Borrower;

public class BorrowerServiceImpl implements BorrowerService {

	private BorrowerDAO borrowerDAO;

	public void createBorrower(int matriculationNumber, String firstName,
			String lastName) throws Exception {
		Borrower borrower = new Borrower();
		borrower.setMatriculationNumber(matriculationNumber);
		borrower.setFirstName(firstName);
		borrower.setLastName(lastName);
		try {

			borrowerDAO.save(borrower);
		} catch (DataIntegrityViolationException ex) {
			// TODO
		}

	}

	public void deleteBorrower(int matriculationNumber) {
		Borrower borrower = borrowerDAO
				.findByMatriculationNumber(matriculationNumber);
		try {
			System.out.println("Try borrowerDAO.delete");
			borrowerDAO.delete(borrower);
		} catch (Exception e) {
			// TODO
		}

	}

	public void updateBorrower(int matriculationNumber, String firstName,
			String lastName) {
		Borrower borrower = borrowerDAO
				.findByMatriculationNumber(matriculationNumber);
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

	public Borrower findBorrowerByMatriculationNumber(int matriculationNumber) {
		Borrower borrower = borrowerDAO
				.findByMatriculationNumber(matriculationNumber);
		try {
			return borrower;
		} catch (Exception e) {
			return null; // TODO
		}
	}

	public List<Borrower> findBorrowerByMatriculationNumberList(
			int matriculationNumber) {
		List<Borrower> borrowers = borrowerDAO
				.findByMatriculationNumberList(matriculationNumber);
		try {
			return borrowers;
		} catch (Exception e) {
			return null; // TODO

		}
	}

	@Override
	public List<Borrower> findBorrowersByNames(String firstName, String lastName) {
		List<Borrower> borrowers = borrowerDAO.findByNames(firstName, lastName);
		try {
			return borrowers;
		} catch (Exception e) {
			return null; // TODO

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
