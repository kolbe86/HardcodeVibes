package de.nak.librarymgmt.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Book;

public class BookDAO extends HibernateDaoSupport {

	public void save(Book book) {
		getHibernateTemplate().save(book);
		System.out.println("Book saved");
	}
}
