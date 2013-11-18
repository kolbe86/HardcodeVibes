package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import de.nak.librarymgmt.model.Keyword;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * The borrower data access object(DAO).
 * 
 */

public class KeywordDAO extends HibernateDaoSupport {

	/**
	 * Persists the given keyword object.
	 * 
	 * @param keyword
	 */
	public void createOrUpdate(Keyword keyword) {
		getHibernateTemplate().saveOrUpdate(keyword);
	}

	public void delete(Keyword keyword) throws DataAccessException {
		getHibernateTemplate().delete(keyword);
	}

	/**
	 * finds and returns all keywords
	 * 
	 * @return a list of keywords
	 */
	@SuppressWarnings("unchecked")
	public Set<Keyword> findAll() throws DataAccessException {
		Set<Keyword> keywordSet = new HashSet<Keyword>(getHibernateTemplate()
				.find("from Keyword"));
		return keywordSet;
	}

	/**
	 * finds a keyword with the given name
	 * 
	 * @param name
	 */
	public Keyword findByName(String name) throws DataAccessException {
		return (Keyword) getHibernateTemplate().get(Keyword.class, name);
	}
}
