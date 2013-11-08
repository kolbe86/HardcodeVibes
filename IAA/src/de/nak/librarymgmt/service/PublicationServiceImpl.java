package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.dao.PublicationDAO;
import de.nak.librarymgmt.model.Publication;

public class PublicationServiceImpl implements PublicationService {

	private PublicationDAO publicationDAO;

	@Override
	public Publication findPublicationById(long publicationID) {
		Publication publication = publicationDAO
				.findPublicationByID(publicationID);
		try {
			return publication;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public PublicationDAO getPublicationDAO() {
		return publicationDAO;
	}

	public void setPublicationDAO(PublicationDAO publicationDAO) {
		this.publicationDAO = publicationDAO;
	}

	@Override
	public List<Publication> listPublications() {
		return publicationDAO.findAll();
	}
}
