package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.dao.BorrowerDAO;
import de.nak.librarymgmt.model.Borrower;

/**
 * the implementation of the borrower Service
 */
public class BorrowerServiceImpl implements BorrowerService {

	/**
	 * initialization of the borrower DAO
	 */
	private BorrowerDAO borrowerDAO;

	/**
	 * creates or updates a borrower
	 * 
	 * @param matriculation
	 *            , number, first name, last name
	 */
	public void createOrUpdateBorrower(int matriculationNumber,
			String firstName, String lastName) {
		Borrower borrower = new Borrower();
		borrower.setMatriculationNumber(matriculationNumber);
		borrower.setFirstName(firstName);
		borrower.setLastName(lastName);
		borrowerDAO.createOrUpdate(borrower);
	}

	/**
	 * not implemented because of associations to lending processes creates or
	 * updates a borrower
	 * 
	 * @param matriculation
	 */
	public void deleteBorrower(int matriculationNumber) {
		Borrower borrower = borrowerDAO
				.findByMatriculationNumber(matriculationNumber);
		borrowerDAO.delete(borrower);
	}

	/**
	 * finds a borrower by given matriculation number
	 * 
	 * @param matriculationNumber
	 * @return Borrower
	 */
	public Borrower findBorrowerByMatriculationNumber(int matriculationNumber) {
		Borrower borrower = borrowerDAO
				.findByMatriculationNumber(matriculationNumber);
		return borrower;
	}

	//
	// public List<Borrower> findBorrowersByNames(String firstName, String
	// lastName) {
	// List<Borrower> borrowers = borrowerDAO.findByNames(firstName, lastName);
	// try {
	// return borrowers;
	// } catch (Exception e) {
	// return null; // TODO
	//
	// }
	// }

	public List<Borrower> listBorrowers() {
		return borrowerDAO.findAll();
	}

	public BorrowerDAO getBorrowerDAO() {
		return borrowerDAO;
	}

	public void setBorrowerDAO(BorrowerDAO borrowerDAO) {
		this.borrowerDAO = borrowerDAO;
	}

}
