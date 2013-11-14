package de.nak.librarymgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.service.AlreadyExistException;

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
	public void save(Borrower borrower) throws AlreadyExistException {
		try {
			getHibernateTemplate().saveOrUpdate(borrower);
			getHibernateTemplate().flush();
		} catch (DataIntegrityViolationException ex) {
			throw new AlreadyExistException(
					"Der Ausleiher ist bereits im System.");
		}
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

	@SuppressWarnings("unchecked")
	public List<Borrower> findByMatriculationNumberList(int matriculationNumber) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Borrower.class);
		criteria.add(Restrictions
				.eq("matriculationNumber", matriculationNumber));
		return ((List<Borrower>) criteria.list());
	}

	@SuppressWarnings("unchecked")
	public List<Borrower> findByNames(String firstName, String lastName) {
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
	public void delete(Borrower borrower) {
		getHibernateTemplate().delete(borrower);
	}
}
