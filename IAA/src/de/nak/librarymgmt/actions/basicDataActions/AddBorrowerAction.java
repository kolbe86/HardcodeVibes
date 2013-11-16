package de.nak.librarymgmt.actions.basicDataActions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.service.BorrowerService;

public class AddBorrowerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private BorrowerService borrowerService;
	private Borrower borrowerBean;
	private List<Borrower> borrowers;

	public String execute() throws Exception {

		borrowerService.createBorrower(borrowerBean.getMatriculationNumber(),
				borrowerBean.getLastName(), borrowerBean.getLastName());

		borrowers = borrowerService.listBorrowers();

		System.out.println("Add BasicDataType Ende");
		return "basicDataSuccess";

	}

	public BorrowerService getBorrowerService() {
		return borrowerService;
	}

	public void setBorrowerService(BorrowerService borrowerService) {
		this.borrowerService = borrowerService;
	}

	public Borrower getBorrowerBean() {
		return borrowerBean;
	}

	public void setBorrowerBean(Borrower borrowerBean) {
		this.borrowerBean = borrowerBean;
	}

	public List<Borrower> getBorrowers() {
		return borrowers;
	}

	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}
}