package de.nak.librarymgmt.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.LendingProcess;

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
		getHibernateTemplate().save(lendingProcess);
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
}
