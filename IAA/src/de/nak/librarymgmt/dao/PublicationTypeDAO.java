package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.PublicationType;

public class PublicationTypeDAO extends HibernateDaoSupport {

	public void save(PublicationType publicationType) {
		getHibernateTemplate().saveOrUpdate(publicationType);

	}

	public void delete(PublicationType publicationType)
			throws DataAccessException {
		getHibernateTemplate().delete(publicationType);
	}

	@SuppressWarnings("unchecked")
	public Set<PublicationType> findAll() throws DataAccessException {
		Set<PublicationType> publicationTypeSet = new HashSet<PublicationType>(
				getHibernateTemplate().find("from PublicationType"));
		return publicationTypeSet;
	}

	public PublicationType findByName(String name) throws DataAccessException {
		return (PublicationType) getHibernateTemplate().get(
				PublicationType.class, name);
	}
}
