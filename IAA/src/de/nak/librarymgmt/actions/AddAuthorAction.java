package de.nak.librarymgmt.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Book;
import de.nak.librarymgmt.service.BookService;

public class AddAuthorAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Book bookBean;
	private Book book;
	private BookService bookService;

	@Override
	public String execute() throws Exception {

		Map<String, Object> session = ActionContext.getContext().getSession();

		if (session.containsKey("book")) {
			@SuppressWarnings("unchecked")
			Book book = (Book) session.get("book");
			book.addAuthors(bookBean.getAuthors());
			session.put("book", book);
		} else {
			// Book book = new Book();
			session.put("book", bookBean);
			// this.setBook(bookBean);
			// autoren.addAll(bookBean.getAuthors());

		}

		// ActionContext.getContext().getSession().put("autor", "autor");

		Book book = (Book) session.get("book");
		System.out.println(book.getAuthors());
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
