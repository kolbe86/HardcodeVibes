package de.nak.librarymgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Borrower;

/**
 * The borrower data access object(DAO).
 * 
 * @author Kowk Bond Chu
 */

public class BorrowerDAO extends HibernateDaoSupport {

	SessionFactory sessionFactory;

	/**
	 * Persists the given borrower object.
	 * 
	 * @param borrower
	 *            , object to persist.
	 */
	public void save(Borrower borrower) {
		getHibernateTemplate().saveOrUpdate(borrower);
	}

	/**
	 * Finds and returns all borrowers.
	 * 
	 * @return a list of borrowers.
	 */
	@SuppressWarnings("unchecked")
	public List<Borrower> findAll() throws DataAccessException {
		return getHibernateTemplate().find("from Borrower");
	}

	/**
	 * Finds a Borrower with the given id.
	 * 
	 * @param borrowerID
	 *            to be searched for
	 * @return borrower object or <code>null</code>.
	 */
	public Borrower findByMatriculationNumber(int matriculationNumber)
			throws DataAccessException {
		return (Borrower) getHibernateTemplate().get(Borrower.class,
				matriculationNumber);
	}

	@SuppressWarnings("unchecked")
	public List<Borrower> findByMatriculationNumberList(int matriculationNumber)
			throws DataAccessException {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Borrower.class);
		criteria.add(Restrictions
				.eq("matriculationNumber", matriculationNumber));
		return ((List<Borrower>) criteria.list());
	}

	@SuppressWarnings("unchecked")
	public List<Borrower> findByNames(String firstName, String lastName)
			throws DataAccessException {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Borrower.class);
		criteria.add(Restrictions.like("firstName", "%" + firstName + "%")
				.ignoreCase());
		criteria.add(Restrictions.like("lastName", "%" + lastName + "%")
				.ignoreCase());
		criteria.addOrder(Order.asc("lastName"));
		return ((List<Borrower>) criteria.list());
	}

	/**
	 * Deletes an given Borrower object.
	 * 
	 * @param borrower
	 *            , object to be deleted
	 * 
	 */
	public void delete(Borrower borrower) throws DataAccessException {
		getHibernateTemplate().delete(borrower);
	}
}
