package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationService;

public class CreateLendingProcessAction extends ActionSupport {

	private Publication publicationBean;
	private LendingProcessService lendingProcessService;
	private BorrowerService borrowerService;
	private PublicationService publicationService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {

		// lendingProcessService.createLendingProcess(, publication,
		// new Date());

		System.out.println(publicationBean.toString());
		return SUCCESS;
	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public LendingProcessService getLendingProcessService() {
		return lendingProcessService;
	}

	public void setLendingProcessService(
			LendingProcessService lendingProcessService) {
		this.lendingProcessService = lendingProcessService;
	}

	public BorrowerService getBorrowerService() {
		return borrowerService;
	}

	public void setBorrowerService(BorrowerService borrowerService) {
		this.borrowerService = borrowerService;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}
}
