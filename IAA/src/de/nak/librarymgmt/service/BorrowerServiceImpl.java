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
	
	public void deleteBorrower(Long id) {
		Borrower borrower = borrowerDAO.findById(id);
		try {
			System.out.println("Try borrowerDAO.delete");
			borrowerDAO.delete(borrower);
		} catch (Exception e) {
			// TODO
		}

	}
	
	
	public void updateBorrower(Long id, String firstName, String lastName) {
		Borrower borrower = borrowerDAO.findById(id);
		try {
		borrower.setFirstName(firstName);;
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

	public Borrower showBorrower(Long id) {
		Borrower borrower = borrowerDAO.findById(id);
		try {
			return borrower;
		} catch (Exception e) {
			return null; // TODO
		}
	}

/*	public void addLendingProcess(LendingProcess lendingProcess,
			Borrower borrower) {
		borrower.getLendingProcesses().add(lendingProcess);
		try {
			System.out.println("Try borrowerDAO.addLendingProcess");
			borrowerDAO.save(borrower);
		} catch (Exception e) {
			// TODO
		}

	}
*/
}
