package de.nak.librarymgmt.actions;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.BorrowerNotFoundException;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationAlreadyDistributedException;
import de.nak.librarymgmt.service.PublicationAlreadyReservedException;
import de.nak.librarymgmt.service.PublicationNotFoundException;
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
		// Unnštig?
		publications = publicationService.listPublications();

		Publication publication = publicationService
				.findPublicationById(publicationID);
		Borrower borrower = borrowerService
				.findBorrowerByMatriculationNumber(matriculationNumber);

		try {
			lendingProcessService.createLendingProcess(borrower, publication,
					new Date());

			publication.setDistributed(true);
			publicationService.updatePublication(
					publication.getPublicationID(), publication.getTitle(),
					publication.getAuthors(), publication.getPublicationDate(),
					publication.getCondition(),
					publication.getPublicationType(),
					publication.getKeywords(), publication.getIsbn(),
					publication.getPublisher(), publication.getIssue(),
					publication.getEdition(), publication.isDistributed());
		} catch (PublicationNotFoundException e) {
			System.out.println("Publication nicht gefunden");
			return "error";
		} catch (PublicationAlreadyDistributedException e) {
			System.out.println("Publication ist bereits verliehen");
			return "error";
		} catch (PublicationAlreadyReservedException e) {
			System.out.println("Publication ist bereits reserviert");
			return "error";
		} catch (BorrowerNotFoundException e) {
			System.out.println("Der Ausleiher wurde nicht gefunden");
			return "error";
		}

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
