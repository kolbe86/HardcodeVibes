package de.nak.librarymgmt.actions.basicDataActions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.service.BorrowerService;

public class BorrowerStartupAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Borrower> borrowers;
	private BorrowerService borrowerService;
	private Long tempFieldBorrower;
	private Long paramBorrower;

	public String execute() throws Exception {

		// Get Borrowers
		borrowers = borrowerService.listBorrowers();

		setTempFieldBorrower(paramBorrower);

		// Publication Bean
		// if (publicationBean == null) {
		// // initialize
		// publicationBean = new Publication();
		// publicationBean.setTitle("Initial Title");
		// publicationBean.setPublicationDate(new Date());
		// publicationBean.setDistributed(false);
		// publicationBean.setReserved(false);
		// publicationBean.setIsbn("Initial ISBN");
		// publicationBean.setPublisher("InitialPublisher");
		// publicationBean.setIssue("Initial Issue");
		// publicationBean.setEdition("Initial Edition");
		//
		// }

		System.out.println("Startup BasicDataBorrower Ende");
		return "basicDataSuccess";

	}

	public Long getTempFieldBorrower() {
		return tempFieldBorrower;
	}

	public void setTempFieldBorrower(Long tempFieldBorrower) {
		this.tempFieldBorrower = tempFieldBorrower;
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

	public Long getParamBorrower() {
		return paramBorrower;
	}

	public void setParamBorrower(Long paramBorrower) {
		this.paramBorrower = paramBorrower;
	}

}
