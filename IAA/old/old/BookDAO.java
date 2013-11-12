package de.nak.librarymgmt.old;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BookDAO extends HibernateDaoSupport {

	public void save(Book book) {
		getHibernateTemplate().save(book);
		System.out.println("Book saved");
	}

	public void delete(Book book) {
		getHibernateTemplate().delete(book);
		System.out.println("Book deleted");
	}

	@SuppressWarnings("unchecked")
	public List<Book> findAll() {
		return getHibernateTemplate().find("from Book");
	}

	public Book findById(Long publicationID) {
		return (Book) getHibernateTemplate().get(Book.class, publicationID);
	}
}
