package de.nak.librarymgmt.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Borrower;

/**
 * @author Mario Kolbe
 * 
 */
public class BorrowerDAO extends HibernateDaoSupport {
	public void save(Borrower borrower) {
		getHibernateTemplate().save(borrower);
		System.out.println("saved!");
	}
}
