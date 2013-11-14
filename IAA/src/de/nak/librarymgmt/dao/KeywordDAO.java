package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import de.nak.librarymgmt.model.Keyword;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class KeywordDAO extends HibernateDaoSupport {

	public void save(Keyword keyword) {
		getHibernateTemplate().saveOrUpdate(keyword);
	}

	public void delete(Keyword keyword) throws DataAccessException{
		getHibernateTemplate().delete(keyword);
	}

	@SuppressWarnings("unchecked")
	public Set<Keyword> findAll() throws DataAccessException{
		Set<Keyword> keywordSet = new HashSet<Keyword>(getHibernateTemplate()
				.find("from Keyword"));
		return keywordSet;
	}

	public Keyword findByName(String name) throws DataAccessException{
		return (Keyword) getHibernateTemplate().get(Keyword.class, name);
	}
}
