package de.nak.librarymgmt.dao;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	public List<Borrower> findAll(){
		return getHibernateTemplate().find("from Borrower");
	}
	
	/**
	 * Finds a Borrower with the given id.
	 * 
	 * @param borrowerId
	 *            The id.
	 * @return a borrower object or <code>null</code>.
	 */
	public Borrower findById(Long borrowerID) {
		return (Borrower) getHibernateTemplate()
				.get(Borrower.class, borrowerID);
	}

	/**
	 * Deletes an given Borrower object.
	 * 
	 * @param borrower
	 *            The borrower.
	 */
	public void delete(Borrower borrower) {
		getHibernateTemplate().delete(borrower);
	}
}
