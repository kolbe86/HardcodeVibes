package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.PublicationType;

/**
 * the publication type DAO
 */
public class PublicationTypeDAO extends HibernateDaoSupport {

	/**
	 * persists the given publication type object
	 * 
	 * @param publication
	 *            type
	 */
	public void createOrUpdate(PublicationType publicationType) {
		getHibernateTemplate().saveOrUpdate(publicationType);

	}

	/**
	 * deletes a given publication type
	 * 
	 * @param publicationType
	 */
	public void delete(PublicationType publicationType) {
		getHibernateTemplate().delete(publicationType);
	}

	/**
	 * finds and returns all publication types
	 * 
	 * @return a list of publication types
	 */
	@SuppressWarnings("unchecked")
	public Set<PublicationType> findAll() {
		Set<PublicationType> publicationTypeSet = new HashSet<PublicationType>(
				getHibernateTemplate().find("from PublicationType"));
		return publicationTypeSet;
	}

	/**
	 * finds a publication type with the given name
	 * 
	 * @param name
	 * @return publication type object or <code>null</code>.
	 */
	public PublicationType findByName(String name) {
		return (PublicationType) getHibernateTemplate().get(
				PublicationType.class, name);
	}
}
