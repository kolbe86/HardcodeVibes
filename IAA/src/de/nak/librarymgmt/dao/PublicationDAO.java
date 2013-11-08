package de.nak.librarymgmt.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Publication;

public class PublicationDAO extends HibernateDaoSupport {

	public Publication findPublicationByID(long publicationID) {
		return (Publication) getHibernateTemplate().get(Publication.class,
				publicationID);
	}
}
