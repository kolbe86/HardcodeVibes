package de.nak.librarymgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.util.DunningLevelE;
import de.nak.librarymgmt.util.StatusE;

/**
 * The borrower data access object(DAO).
 * 
 */

public class LendingProcessDAO extends HibernateDaoSupport {

	/**
	 * persists or updates the given lending process object, depending on
	 * existing object or not
	 * 
	 * @param lendingProcess
	 */
	public void createOrUpdate(LendingProcess lendingProcess) {
		getHibernateTemplate().saveOrUpdate(lendingProcess);
	}

	/**
	 * deletes an given lending process object.
	 * 
	 * @param lendingProcess
	 *            , object to be deleted
	 */
	public void delete(LendingProcess lendingProcess) {
		getHibernateTemplate().delete(lendingProcess);
	}

	/**
	 * deletes all lending processes which contains the publications
	 * 
	 * @param publicationID
	 */
	public void deleteAllLendingProcessesWithLostPublication(long publicationID) {
		List<LendingProcess> lendingProcessesWithGivenPublication = findAllByPublicationID(publicationID);
		for (LendingProcess lendingProcess : lendingProcessesWithGivenPublication) {
			getHibernateTemplate().delete(lendingProcess);
		}
	}

	/**
	 * finds all lending processes with the given publicationID
	 * 
	 * @param publicationID
	 * @result list of lending processes
	 */
	@SuppressWarnings("unchecked")
	private List<LendingProcess> findAllByPublicationID(long publicationID) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(LendingProcess.class);
		criteria.add(Restrictions
				.eq("publication.publicationID", publicationID));
		criteria.setFetchMode("borrower", FetchMode.JOIN);
		criteria.setFetchMode("publication", FetchMode.JOIN);
		return (List<LendingProcess>) criteria.list();
	}

	/**
	 * finds a lending process with the given id.
	 * 
	 * @param lendingProcessID
	 * @return lendingProcess object or <code>null</code>.
	 */
	public LendingProcess findById(Long lendingProcessID) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(LendingProcess.class);
		criteria.setFetchMode("borrower", FetchMode.JOIN);
		criteria.setFetchMode("publication", FetchMode.JOIN);
		criteria.add(Restrictions.eq("lendingProcessID", lendingProcessID));
		return (LendingProcess) criteria.uniqueResult();
	}

	/**
	 * finds a lending processes with the given publicationID
	 * 
	 * @param publicationID
	 * @result list of lending processes
	 */
	public LendingProcess findByPublication(long publicationID) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(LendingProcess.class);
		criteria.add(Restrictions
				.eq("publication.publicationID", publicationID));
		criteria.setFetchMode("borrower", FetchMode.JOIN);
		criteria.setFetchMode("publication", FetchMode.JOIN);
		return (LendingProcess) criteria.list().get(0);

	}

	/**
	 * finds and returns all lending processes.
	 * 
	 * @return a list of lending processes.
	 */
	@SuppressWarnings("unchecked")
	public List<LendingProcess> findAll() {
		return getHibernateTemplate().find("from LendingProcess");
	}

	/**
	 * finds and returns all active lending processes
	 * 
	 * @return a list of active lending processes
	 */
	@SuppressWarnings("unchecked")
	public List<LendingProcess> findActiveProcesses() {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(LendingProcess.class);
		criteria.add(Restrictions.eq("status", StatusE.OPEN));
		criteria.addOrder(Order.desc("returnDate"));
		return ((List<LendingProcess>) criteria.list());
	}

	/**
	 * finds and returns all dunned and open lending processes
	 * 
	 * @return a list of dunned and open lending processes
	 */
	@SuppressWarnings({ "unchecked" })
	public List<LendingProcess> findDunnedProcesses() {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(LendingProcess.class);
		criteria.setFetchMode("borrower", FetchMode.JOIN);
		criteria.setFetchMode("publication", FetchMode.JOIN);
		criteria.add(Restrictions.not(Restrictions.eq("dunningLevel",
				DunningLevelE.ZERO)));
		criteria.add(Restrictions.eq("status", StatusE.OPEN));
		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		criteria.addOrder(Order.asc("issueDate"));
		return ((List<LendingProcess>) criteria.list());
	}

}
