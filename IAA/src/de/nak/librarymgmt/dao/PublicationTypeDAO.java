package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.AlreadyExistException;

public class PublicationTypeDAO extends HibernateDaoSupport {

	public void save(PublicationType publicationType)
			throws AlreadyExistException {
		try {
			getHibernateTemplate().saveOrUpdate(publicationType);
			getHibernateTemplate().flush();
		} catch (DataIntegrityViolationException ex) {
			throw new AlreadyExistException("keyword already exists");
		}
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
