package de.nak.librarymgmt.actions.basicDataActions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.service.BorrowerService;

public class DeleteBorrowerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private BorrowerService borrowerService;
	private Borrower borrowerBean;
	private List<Borrower> borrowers;

	public String execute() throws Exception {

		// Delete borrower and get list for table in jsp
		borrowerService.deleteBorrower(borrowerBean.getMatriculationNumber());

		borrowers = borrowerService.listBorrowers();

		System.out.println("Delete BasicDataType Ende");
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
