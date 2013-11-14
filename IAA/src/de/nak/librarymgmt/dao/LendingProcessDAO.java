package de.nak.librarymgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.util.DunningLevelE;
import de.nak.librarymgmt.util.StatusE;

/**
 * The borrower data access object(DAO).
 * 
 * @author Kowk Bond Chu
 */

public class LendingProcessDAO extends HibernateDaoSupport {

	/**
	 * Persists the given lending process object.
	 * 
	 * @param lendingProcess
	 *            , object to persist.
	 */
	public void save(LendingProcess lendingProcess) {
		getHibernateTemplate().saveOrUpdate(lendingProcess);
		System.out.println("saved!");
	}

	/**
	 * Deletes an given lending process object.
	 * 
	 * @param lendingProcess
	 *            , object to be deleted
	 * 
	 */
	public void delete(LendingProcess lendingProcess) {
		getHibernateTemplate().delete(lendingProcess);
	}

	/**
	 * Finds a lending process with the given id.
	 * 
	 * @param lendingProcessID
	 *            to be searched for
	 * @return lendingProcess object or <code>null</code>.
	 */
	public LendingProcess findById(Long lendingProcessID) {
		return (LendingProcess) getHibernateTemplate().get(
				LendingProcess.class, lendingProcessID);
	}

	/**
	 * Finds and returns all lending processes.
	 * 
	 * @return a list of lending processes.
	 */
	@SuppressWarnings("unchecked")
	public List<LendingProcess> findAll() {
		return getHibernateTemplate().find("from LendingProcess");
	}

	@SuppressWarnings("unchecked")
	public List<LendingProcess> findActiveProcesses() {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(LendingProcess.class);
		criteria.add(Restrictions.eq("status", StatusE.OPEN));
		criteria.addOrder(Order.desc("returnDate"));
		return ((List<LendingProcess>) criteria.list());
	}

	@SuppressWarnings("unchecked")
	public List<LendingProcess> findDunnedProcesses() {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(LendingProcess.class);
		Criterion first = Restrictions.eq("dunningLevel", DunningLevelE.FIRST);
		Criterion second = Restrictions
				.eq("dunningLevel", DunningLevelE.SECOND);
		Criterion third = Restrictions.eq("dunningLevel", DunningLevelE.THIRD);
		LogicalExpression firstSecond = Restrictions.or(first, second);
		LogicalExpression firstSecondThird = Restrictions
				.or(third, firstSecond);
		criteria.add(firstSecond).add(firstSecondThird);
		criteria.addOrder(Order.asc("issueDate"));
		return ((List<LendingProcess>) criteria.list());
	}

}
