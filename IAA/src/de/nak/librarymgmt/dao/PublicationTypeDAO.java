package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.PublicationType;

public class PublicationTypeDAO extends HibernateDaoSupport {
	public void save(PublicationType publicationType) {
		getHibernateTemplate().save(publicationType);
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

	public PublicationType findById(Long publicationID) {
		return (PublicationType) getHibernateTemplate().get(
				PublicationType.class, publicationID);
	}
}
