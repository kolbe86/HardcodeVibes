package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.service.AlreadyExistException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class KeywordDAO extends HibernateDaoSupport {

	public void save(Keyword keyword) throws AlreadyExistException {
		try {
			getHibernateTemplate().saveOrUpdate(keyword);
			getHibernateTemplate().flush();
		} catch (DataIntegrityViolationException ex) {
			throw new AlreadyExistException("keyword already exists");
		}
	}

	public void delete(Keyword keyword) {
		getHibernateTemplate().delete(keyword);
	}

	@SuppressWarnings("unchecked")
	public Set<Keyword> findAll() {
		Set<Keyword> keywordSet = new HashSet<Keyword>(getHibernateTemplate()
				.find("from Keyword"));
		return keywordSet;
	}

	public Keyword findByName(String name) {
		return (Keyword) getHibernateTemplate().get(Keyword.class, name);
	}
}
