package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import de.nak.librarymgmt.model.Book;

public interface BookService {

	void createBook(String title, Set<String> authors, Date publicationDate,
			Set<String> keywords, String condition, String isbn,
			String publisher, String edition);

	void updateBook(Long publicationID, String title, Date publicationDate,
			String condition, String isbn, String publisher, String edition,
			boolean distributed, boolean reserved);

	void addAuthorToBook(Long publicationID, String author);

	void deleteAuthorFromBook(Long publicationID, String author);

	void addKeywordToBook(Long publicationID, String keyword);

	void deleteKeywordToBook(Long publicationID, String keyword);

	void deleteBook(Long publicationID);

	List<Book> listBooks();

}
