package de.nak.librarymgmt.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Borrower;

/**
 * The borrower data access object(DAO).
 * 
 * @author Kowk Bond Chu
 */
public class BorrowerDAO extends HibernateDaoSupport {

	/**
	 * Persists the given borrower object.
	 * 
	 * @param borrower
	 *            , object to persist.
	 */
	public void save(Borrower borrower) {
		getHibernateTemplate().save(borrower);
		System.out.println("saved!");
	}

	/**
	 * Finds and returns all borrowers.
	 * 
	 * @return a list of borrowers.
	 */
	@SuppressWarnings("unchecked")
	public List<Borrower> findAll() {
		return getHibernateTemplate().find("from Borrower");
	}

	/**
	 * Finds a Borrower with the given id.
	 * 
	 * @param borrowerID
	 *            to be searched for
	 * @return borrower object or <code>null</code>.
	 */
	public Borrower findById(Long borrowerID) {
		return (Borrower) getHibernateTemplate()
				.get(Borrower.class, borrowerID);
	}

	/**
	 * Deletes an given Borrower object.
	 * 
	 * @param borrower
	 *            , object to be deleted
	 * 
	 */
	public void delete(Borrower borrower) {
		getHibernateTemplate().delete(borrower);
	}
}
