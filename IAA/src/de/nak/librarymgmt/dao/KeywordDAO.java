package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import de.nak.librarymgmt.model.Keyword;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class KeywordDAO extends HibernateDaoSupport {

	public void save(Keyword keyword) {
		getHibernateTemplate().save(keyword);
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

	public Keyword findById(Long keywordID) {
		return (Keyword) getHibernateTemplate().get(Keyword.class, keywordID);
	}
}
