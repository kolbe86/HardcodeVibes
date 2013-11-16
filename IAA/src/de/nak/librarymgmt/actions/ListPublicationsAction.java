package de.nak.librarymgmt.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.PublicationService;

public class ListPublicationsAction extends ActionSupport {

	private PublicationService publicationService;

	// Worklists
	List<Publication> publications;

	private static final long serialVersionUID = 1L;

	public String execute() {

		setPublications(publicationService.listPublications());

		return SUCCESS;
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

}
