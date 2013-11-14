package de.nak.librarymgmt.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.PublicationService;

public class ChooseBorrowerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Publication> publications;
	private PublicationService publicationService;
	// private Long publicationID;
	private Publication publicationBean;
	private BorrowerService borrowerService;
	private List<Borrower> borrowers;

	public String execute() {

		setPublications(publicationService.listPublications());

		setPublicationBean(publicationService
				.findPublicationById(publicationBean.getPublicationID()));
		setBorrowers(borrowerService.listBorrowers());
		return SUCCESS;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public BorrowerService getBorrowerService() {
		return borrowerService;
	}

	public void setBorrowerService(BorrowerService borrowerService) {
		this.borrowerService = borrowerService;
	}

	public List<Borrower> getBorrowers() {
		return borrowers;
	}

	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}

}
