package de.nak.librarymgmt.service;

import java.util.Date;

/**
 * Interface for the publication service.
 * 
 * @author Mario Kolbe
 */
public interface PublicationService {

	void createPublication(String title, String author, Date dateOfPublication);
}
