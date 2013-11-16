package de.nak.librarymgmt.service;

import de.nak.librarymgmt.model.Author;

public interface AuthorService {

//	void createAuthor(String firstName, String lastName);

	Author findAuthorById(long id);

	Author findAuthorByName(String name);

}
