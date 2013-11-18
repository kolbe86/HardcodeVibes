package de.nak.librarymgmt.service;

import de.nak.librarymgmt.dao.AuthorDAO;
import de.nak.librarymgmt.model.Author;

/**
 * the implementation for the author service
 */

public class AuthorServiceImpl implements AuthorService {

	/**
	 * initialization of the author DAO
	 */
	private AuthorDAO authorDAO;

	/**
	 * finds or creates an Author, depending on already existing name or not
	 * @param name 
	 */
	public Author findOrCreateAuthorWithName(String name) {
		Author author = new Author();
		author.setName(name);
		Author existingAuthor = authorDAO.findByName(name);
		if (existingAuthor != null) {
			return authorDAO.findByName(name);
		} else {
			authorDAO.createOrUpdate(author);
			return authorDAO.findByName(name);
		}

	}

	public AuthorDAO getAuthorDAO() {
		return authorDAO;
	}

	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

}
