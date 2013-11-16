package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.BorrowerFirstnameComparator;
import de.nak.librarymgmt.comparators.BorrowerIdComparator;
import de.nak.librarymgmt.comparators.BorrowerLastnameComparator;
import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.service.BorrowerService;

public class SortBasicDataBorrower extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Borrower> borrowers;
	private BorrowerService borrowerService;
	private boolean increasing;
	private String whichColumn;

	public String execute() throws Exception {

		setBorrowers(borrowerService.listBorrowers());

		switch (whichColumn) {
		case "firstName":

			Comparator<Borrower> compFirstname = new BorrowerFirstnameComparator();
			Collections.sort(borrowers, compFirstname);
			if (increasing == false) {
				Collections.reverse(borrowers);
			}
			break;

		case "lastName":

			Comparator<Borrower> compLastname = new BorrowerLastnameComparator();
			Collections.sort(borrowers, compLastname);
			if (increasing == false) {
				Collections.reverse(borrowers);
			}
			break;

		// Sort by matriculationnumber

		default:

			Comparator<Borrower> compMatriculation = new BorrowerIdComparator();
			Collections.sort(borrowers, compMatriculation);
			if (increasing == false) {
				Collections.reverse(borrowers);
			}
			break;
		}

		return SUCCESS;

	}

	public List<Borrower> getBorrowers() {
		return borrowers;
	}

	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}

	public BorrowerService getBorrowerService() {
		return borrowerService;
	}

	public void setBorrowerService(BorrowerService borrowerService) {
		this.borrowerService = borrowerService;
	}

	public boolean isIncreasing() {
		return increasing;
	}

	public void setIncreasing(boolean increasing) {
		this.increasing = increasing;
	}

	public String getWhichColumn() {
		return whichColumn;
	}

	public void setWhichColumn(String whichColumn) {
		this.whichColumn = whichColumn;
	}

}
