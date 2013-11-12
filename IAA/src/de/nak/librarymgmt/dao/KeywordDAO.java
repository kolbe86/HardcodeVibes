package de.nak.librarymgmt.dao;

import java.util.List;

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
	public List<Keyword> findAll() {
		return getHibernateTemplate().find("from Keyword");
	}

	public Keyword findById(Long keywordID) {
		return (Keyword) getHibernateTemplate().get(Keyword.class, keywordID);
	}
}
