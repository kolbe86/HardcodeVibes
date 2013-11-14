package de.nak.librarymgmt.actions;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationService;

public class CreateLPAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Publication> publications;
	private BorrowerService borrowerService;
	private PublicationService publicationService;
	private LendingProcessService lendingProcessService;
	private Publication publicationBean;
	private List<Borrower> borrowers;
	private Long publicationID;
	private int matriculationNumber;

	public String execute() {

		setPublications(publicationService.listPublications());

		lendingProcessService.createLendingProcess(borrowerService
				.findBorrowerByMatriculationNumber(matriculationNumber),
				publicationService.findPublicationById(publicationID),
				new Date());

		publications = publicationService.listPublications();

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

	public Long getPublicationID() {
		return publicationID;
	}

	public void setPublicationID(Long publicationID) {
		this.publicationID = publicationID;
	}

	public int getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(int matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

	public LendingProcessService getLendingProcessService() {
		return lendingProcessService;
	}

	public void setLendingProcessService(
			LendingProcessService lendingProcessService) {
		this.lendingProcessService = lendingProcessService;
	}
}
