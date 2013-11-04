package de.nak.librarymgmt.service;

import java.util.Date;

import de.nak.librarymgmt.dao.PublicationDAO;
import de.nak.librarymgmt.model.Publication;

/**
 * The publication service implementation.
 * 
 * @author Mario Kolbe
 */

public class PublicationServiceImpl implements PublicationService {

	private PublicationDAO publicationDAO;

	public void createPublication(String title, String author,
			Date dateOfPublication) {
		Publication publication = new Publication() {
		};
		publication.setTitle(title);
		publication.setAuthor(author);
		publication.setDateOfPublication(dateOfPublication);

		try {
			publicationDAO.save(publication);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public PublicationDAO getPublicationDAO() {
		return publicationDAO;
	}

	public void setPublicationDAO(PublicationDAO publicationDAO) {
		this.publicationDAO = publicationDAO;
	}
}
