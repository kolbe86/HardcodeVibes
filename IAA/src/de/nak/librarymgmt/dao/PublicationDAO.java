/**
 * 
 */
package de.nak.librarymgmt.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Publication;

/**
 * @author Mario Kolbe
 * 
 */
public class PublicationDAO extends HibernateDaoSupport {

	public void save(Publication publication) {
		getHibernateTemplate().save(publication);
	}
}
