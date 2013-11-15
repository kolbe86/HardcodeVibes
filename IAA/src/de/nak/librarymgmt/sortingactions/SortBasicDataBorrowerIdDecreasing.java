package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.BorrowerIdComparator;
import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.service.BorrowerService;

public class SortBasicDataBorrowerIdDecreasing extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Borrower> borrowers;
	private BorrowerService borrowerService;

	public String execute() throws Exception {

		Comparator<Borrower> comp = new BorrowerIdComparator();

		setBorrowers(borrowerService.listBorrowers());

		Collections.sort(borrowers, comp);
		Collections.reverse(borrowers);

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

}
