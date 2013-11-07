package de.nak.librarymgmt.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Magazine;

public class MagazineDAO extends HibernateDaoSupport {

	public void save(Magazine magazine) {
		getHibernateTemplate().save(magazine);
		System.out.println("Magazine saved");
	}
}
