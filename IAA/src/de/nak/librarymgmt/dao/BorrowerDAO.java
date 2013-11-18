package de.nak.librarymgmt.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Borrower;

/**
 * The borrower data access object(DAO).
 * 
 */

public class BorrowerDAO extends HibernateDaoSupport {


	/**
	 * Persists the given borrower object.
	 * 
	 * @param borrower
	 *            , object to persist.
	 */
	public void createOrUpdate(Borrower borrower) {
		getHibernateTemplate().saveOrUpdate(borrower);
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
	public Borrower findByMatriculationNumber(int matriculationNumber) {
		return (Borrower) getHibernateTemplate().get(Borrower.class,
				matriculationNumber);
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
	
//	@SuppressWarnings("unchecked")
//	public List<Borrower> findByMatriculationNumberList(int matriculationNumber) {
//		Criteria criteria = getHibernateTemplate().getSessionFactory()
//				.getCurrentSession().createCriteria(Borrower.class);
//		criteria.add(Restrictions
//				.eq("matriculationNumber", matriculationNumber));
//		return ((List<Borrower>) criteria.list());
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Borrower> findByNames(String firstName, String lastName) {
//		Criteria criteria = getHibernateTemplate().getSessionFactory()
//				.getCurrentSession().createCriteria(Borrower.class);
//		criteria.add(Restrictions.like("firstName", "%" + firstName + "%")
//				.ignoreCase());
//		criteria.add(Restrictions.like("lastName", "%" + lastName + "%")
//				.ignoreCase());
//		criteria.addOrder(Order.asc("lastName"));
//		return ((List<Borrower>) criteria.list());
//	}


}
