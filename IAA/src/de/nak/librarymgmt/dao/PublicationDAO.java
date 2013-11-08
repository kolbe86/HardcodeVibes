package de.nak.librarymgmt.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Publication;

public class PublicationDAO extends HibernateDaoSupport {

	public Publication findPublicationByID(long publicationID) {
		return (Publication) getHibernateTemplate().get(Publication.class,
				publicationID);
	}

	@SuppressWarnings("unchecked")
	public List<Publication> findAll() {
		return getHibernateTemplate().find("from Publication");
	}
}
