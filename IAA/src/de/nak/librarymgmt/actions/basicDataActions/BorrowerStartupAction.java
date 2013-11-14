package de.nak.librarymgmt.actions.basicDataActions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.service.BorrowerService;

public class BorrowerStartupAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Borrower> borrowers;
	private BorrowerService borrowerService;
	private Integer paramBorrower;
	private Borrower borrowerBean;

	public String execute() throws Exception {

		// Get Borrowers
		borrowers = borrowerService.listBorrowers();

		if (!(paramBorrower == null)) {

			setBorrowerBean(borrowerService
					.findBorrowerByMatriculationNumber(paramBorrower));

		}

		System.out.println("Startup BasicDataBorrower Ende");
		return "basicDataSuccess";

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

	public Integer getParamBorrower() {
		return paramBorrower;
	}

	public void setParamBorrower(Integer paramBorrower) {
		this.paramBorrower = paramBorrower;
	}

	public Borrower getBorrowerBean() {
		return borrowerBean;
	}

	public void setBorrowerBean(Borrower borrowerBean) {
		this.borrowerBean = borrowerBean;
	}

}
