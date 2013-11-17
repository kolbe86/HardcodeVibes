package de.nak.librarymgmt.service;

import org.springframework.dao.DataIntegrityViolationException;

import de.nak.librarymgmt.dao.AuthorDAO;
import de.nak.librarymgmt.model.Author;

public class AuthorServiceImpl implements AuthorService {

	private AuthorDAO authorDAO;

	@Override
	/*
	 * public void createAuthor(String firstName, String lastName) { Author
	 * author = new Author(); author.setFirstName(firstName);
	 * author.setLastName(lastName);
	 * 
	 * if (author == authorDAO.findByName(firstName, lastName)) { } else {
	 * authorDAO.save(author); }
	 * 
	 * }
	 */
	public Author findAuthorByName(String name) {
		Author author = new Author();
		author.setName(name);
		Author existingAuthor = authorDAO.findByName(name);
		if (existingAuthor != null) {
			return authorDAO.findByName(name);
		} else {
			authorDAO.save(author);
			return authorDAO.findByName(name);
		}

	}

	public Author findAuthorById(long id) {
		Author author = authorDAO.findById(id);
		try {
			return author;
		} catch (Exception e) {
			return null; // TODO
		}
	}

	public AuthorDAO getAuthorDAO() {
		return authorDAO;
	}

	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

}
