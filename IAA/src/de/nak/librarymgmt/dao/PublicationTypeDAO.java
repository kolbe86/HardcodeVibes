package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.PublicationType;

public class PublicationTypeDAO extends HibernateDaoSupport {

	public void save(PublicationType publicationType) {
		getHibernateTemplate().saveOrUpdate(publicationType);

	}

	public void delete(PublicationType publicationType) {
		getHibernateTemplate().delete(publicationType);
	}

	@SuppressWarnings("unchecked")
	public Set<PublicationType> findAll() {
		Set<PublicationType> publicationTypeSet = new HashSet<PublicationType>(
				getHibernateTemplate().find("from PublicationType"));
		return publicationTypeSet;
	}

	public PublicationType findByName(String name) {
		return (PublicationType) getHibernateTemplate().get(
				PublicationType.class, name);
	}
}
