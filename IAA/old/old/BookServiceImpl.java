package de.nak.librarymgmt.old;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
			String isbn, String publisher, String edition) {

		Book book = new Book();
		book.setTitle(title);
		book.setAuthors(authors);
		book.setPublicationDate(publicationDate);
		book.setKeywords(keywords);
		book.setCondition(condition);
		book.setIsbn(isbn);
		book.setPublisher(publisher);
		;
		book.setEdition(edition);
		book.setDistributed(false);
		book.setReserved(false);
		// TODO Notwendig oder weg lassen?
		book.setLendingProcess(null);

		try {
			bookDAO.save(book);
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}

	}

	@Override
	public void updateBook(Long publicationID, String title,
			Date publicationDate, String condition, String isbn,
			String publisher, String edition, boolean distributed,
			boolean reserved) {
		Book book = bookDAO.findById(publicationID);
		try {
			book.setPublicationDate(publicationDate);
			book.setTitle(title);
			book.setCondition(condition);
			book.setIsbn(isbn);
			book.setPublisher(publisher);
			book.setEdition(edition);
			book.setDistributed(distributed);
			book.setReserved(reserved);
			System.out.println("Book is updated");
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void addAuthorToBook(Long publicationID, String author) {
		Book book = bookDAO.findById(publicationID);
		try {
			book.getAuthors().add(author);
			System.out.println("Author is added");
		} catch (Exception e) {
			// TODO
		}
	}

	@Override
	public void deleteAuthorFromBook(Long publicationID, String author) {
		Book book = bookDAO.findById(publicationID);
		try {
			book.getAuthors().remove(author);
			System.out.println("Author is deleted");
		} catch (Exception e) {
			// TODO
		}
	}

	@Override
	public void deleteBook(Long publicationID) {
		Book book = bookDAO.findById(publicationID);
		try {
			bookDAO.delete(book);
		} catch (Exception e) {
			// TODO
		}
	}

	@Override
	public List<Book> listBooks() {
		return bookDAO.findAll();
	}

	@Override
	public void addKeywordToBook(Long publicationID, String keyword) {
		Book book = bookDAO.findById(publicationID);
		try {
			book.getKeywords().add(keyword);
			System.out.println("Keyword is deleted");
		} catch (Exception e) {
			// TODO
		}
	}

	@Override
	public void deleteKeywordToBook(Long publicationID, String keyword) {
		Book book = bookDAO.findById(publicationID);
		try {
			book.getKeywords().remove(keyword);
			System.out.println("Keyword is deleted");
		} catch (Exception e) {
			// TODO
		}
	};

	// @Override
	// public Book findBookByID(long id) {
	// Book book = bookDAO.findBookByID(id);
	// try {
	// return book;
	// } catch (Exception e) {
	// // TODO: handle exception
	// return null;
	// }
	// }
}
