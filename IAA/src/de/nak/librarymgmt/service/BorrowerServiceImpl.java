package de.nak.librarymgmt.service;

import de.nak.librarymgmt.dao.BorrowerDAO;
import de.nak.librarymgmt.model.Borrower;

public class BorrowerServiceImpl implements BorrowerService {

	private BorrowerDAO borrowerDAO;

	@Override
	public void createBorrower(String firstName, String lastName) {
		Borrower borrower = new Borrower();
		borrower.setFirstName(firstName);
		borrower.setLastName(lastName);

		try {
			System.out.println("Try borrowerDAO.save");
			borrowerDAO = new BorrowerDAO();
			borrowerDAO.save(borrower);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BorrowerDAO getBorrowerDAO() {
		return borrowerDAO;
	}

	public void setBorrowerDAO(BorrowerDAO borrowerDAO) {
		this.borrowerDAO = borrowerDAO;
	}
}
