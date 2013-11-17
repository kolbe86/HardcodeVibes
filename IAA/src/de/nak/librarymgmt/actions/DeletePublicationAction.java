package de.nak.librarymgmt.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationNotDeletableException;
import de.nak.librarymgmt.service.PublicationService;

public class DeletePublicationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Publication> publications;
	private PublicationService publicationService;
	private LendingProcessService lendingProcessService;

	private Publication publicationBean;

	@Override
	public String execute() throws Exception {

		try {
			lendingProcessService
					.deleteLendingProcessesWithGivenPublicationId(publicationBean
							.getPublicationID());
			publicationService.deletePublication(publicationBean
					.getPublicationID());

		} catch (PublicationNotDeletableException ex) {
			return "error";
		}

		setPublications(publicationService.listPublications());
		return "success";

	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
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
}
