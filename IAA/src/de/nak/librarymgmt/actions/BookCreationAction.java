package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Book;
import de.nak.librarymgmt.service.BookService;

public class BookCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Book bookBean;
	private BookService bookService;

	@Override
	public String execute() throws Exception {

		bookService.createBook(bookBean.getTitle(), bookBean.getAuthors(),
				bookBean.getPublicationDate(), bookBean.getKeywords(),
				bookBean.getCondition(), bookBean.getIsbn(),
				bookBean.getPublisher(), bookBean.getEdition());
		System.out.println("Book anlegen");

		return SUCCESS;

	}

	public Book getBookBean() {
		return bookBean;
	}

	public void setBookBean(Book bookBean) {
		this.bookBean = bookBean;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
