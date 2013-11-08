package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.model.Publication;

public interface PublicationService {

	Publication findPublicationById(long publicationID);
	List<Publication> listPublications();
}
