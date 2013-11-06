package de.nak.librarymgmt.service;


import de.nak.librarymgmt.dao.BorrowerDAO;
import de.nak.librarymgmt.model.Borrower;

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

	public BorrowerDAO getBorrowerDAO() {
		return borrowerDAO;
	}

	public void setBorrowerDAO(BorrowerDAO borrowerDAO) {
		this.borrowerDAO = borrowerDAO;
	}

}
