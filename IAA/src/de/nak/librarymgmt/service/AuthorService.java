package de.nak.librarymgmt.service;

import de.nak.librarymgmt.model.Author;

/**
 * Interface AuthorService
 */

public interface AuthorService {

	/**
	 * creates and stores a new author entity
	 * @param name
	 */
	Author findOrCreateAuthorWithName(String name);

}
