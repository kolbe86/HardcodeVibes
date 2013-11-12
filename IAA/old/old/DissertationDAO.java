package de.nak.librarymgmt.old;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DissertationDAO extends HibernateDaoSupport {

	public void save(Dissertation dissertation) {
		getHibernateTemplate().save(dissertation);
		System.out.println("Dissertation saved");
	}

	public void delete(Dissertation dissertation) {
		getHibernateTemplate().delete(dissertation);
		System.out.println("Dissertation deleted");
	}

	@SuppressWarnings("unchecked")
	public List<Dissertation> findAll() {
		return getHibernateTemplate().find("from Dissertation");
	}
	
	public Dissertation findById(Long publicationID){
		return (Dissertation) getHibernateTemplate().get(Dissertation.class, publicationID);
	}	
	
}
