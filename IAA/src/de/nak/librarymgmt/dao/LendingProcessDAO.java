package de.nak.librarymgmt.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import de.nak.librarymgmt.model.LendingProcess;

/**
 * @author Kowk Bond Chu
 * 
 */

public class LendingProcessDAO extends HibernateDaoSupport {

	public void save(LendingProcess lendingProcess) {
		getHibernateTemplate().save(lendingProcess);
		System.out.println("saved!");
	}
}
