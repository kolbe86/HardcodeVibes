package de.nak.librarymgmt.dao;

import java.util.List;

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
	public List<PublicationType> findAll() {
		return getHibernateTemplate().find("from PublicationType");
	}

	public PublicationType findById(Long publicationID) {
		return (PublicationType) getHibernateTemplate().get(
				PublicationType.class, publicationID);
	}
}
