package de.nak.librarymgmt.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Author;

/**
 * the author DAO
 */

public class AuthorDAO extends HibernateDaoSupport {

	/**
	 * persists or updates given author object
	 * 
	 * @param author
	 */
	public void createOrUpdate(Author author) {
		getHibernateTemplate().saveOrUpdate(author);

	}

	/**
	 * deletes an given author
	 * 
	 * @param author
	 *            not implemented because of associations with Books
	 */
	public void delete(Author author) {
		getHibernateTemplate().delete(author);
	}

	/**
	 * finds an author with a given name
	 * 
	 * @param name
	 * @return author
	 */
	public Author findByName(String name) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Author.class);
		criteria.add(Restrictions.eq("name", name));
		return (Author) criteria.uniqueResult();
	}

}
