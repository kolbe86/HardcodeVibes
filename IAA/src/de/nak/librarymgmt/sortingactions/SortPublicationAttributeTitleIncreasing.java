package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.PublicationAttributeTitleComparator;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.PublicationService;

public class SortPublicationAttributeTitleIncreasing extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Publication> publications;
	private PublicationService publicationService;

	public String execute() throws Exception {

		Comparator<Publication> comp = new PublicationAttributeTitleComparator();

		setPublications(publicationService.listPublications());

		Collections.sort(publications, comp);

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

}
