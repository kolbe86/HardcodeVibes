package de.nak.librarymgmt.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Dissertation;

public class DissertationDAO extends HibernateDaoSupport {

	public void save(Dissertation dissertation) {
		getHibernateTemplate().save(dissertation);
		System.out.println("Dissertation saved");
	}
}
