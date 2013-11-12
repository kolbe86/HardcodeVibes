package de.nak.librarymgmt.old;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MagazineDAO extends HibernateDaoSupport {

	public void save(Magazine magazine) {
		getHibernateTemplate().save(magazine);
		System.out.println("Magazine saved");
	}
}
