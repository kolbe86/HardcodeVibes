package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.Set;

import de.nak.librarymgmt.dao.BookDAO;
import de.nak.librarymgmt.model.Book;

public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public void createBook(String title, Set<String> authors,
			Date publicationDate, Set<String> keywords, String condition,
			String isbn, String publisher, String edition, boolean distributed,
			boolean reserved) {

		Book book = new Book();
		book.setTitle(title);
		book.setAuthors(authors);
		book.setPublicationDate(publicationDate);
		book.setKeywords(keywords);
		book.setCondition(condition);
		book.setIsbn(isbn);
		book.setPublisher(publisher);
		book.setEdition(edition);
		book.setDistributed(distributed);
		book.setReserved(reserved);

		try {
			bookDAO.save(book);
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}

	}

	@Override
	public Book findBook(long id) {
		Book book = bookDAO.findBookByID(id);
		try {
			return book;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
