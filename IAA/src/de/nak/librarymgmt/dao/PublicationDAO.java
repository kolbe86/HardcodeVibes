package de.nak.librarymgmt.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;

public class PublicationDAO extends HibernateDaoSupport {

	public void save(Publication publication) {
		getHibernateTemplate().save(publication);
		System.out.println("saved!");
	}

	public void delete(Publication publication) {
		getHibernateTemplate().delete(publication);
		System.out.println("saved!");
	}

	@SuppressWarnings("unchecked")
	public List<Publication> findAll() {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Publication.class);
		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		criteria.setFetchMode("publicationType", FetchMode.JOIN);
		criteria.setFetchMode("keywords", FetchMode.JOIN);
		return (List<Publication>) criteria.list();
	}

	public Publication findById(Long publicationID) {
		return (Publication) getHibernateTemplate().get(Publication.class,
				publicationID);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Publication> findByCriteria(String title,
			Set<Keyword> keywords, String isbn, String publisher, String issue,
			String edition) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Publication.class);
		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		criteria.setFetchMode("keywords", FetchMode.EAGER);
		if (keywords != null) {
			addRestrictionsForKeywords(criteria, keywords);
		}
		criteria.add(Restrictions.like("title", "%" + title + "%").ignoreCase());
		criteria.add(Restrictions.like("isbn", "%" + isbn + "%"));
		criteria.add(Restrictions.like("publisher", "%" + publisher + "%")
				.ignoreCase());
		criteria.add(Restrictions.like("issue", "%" + issue + "%").ignoreCase());
		criteria.add(Restrictions.like("edition", "%" + edition + "%")
				.ignoreCase());
		criteria.addOrder(Order.asc("title"));

		return (List<Publication>) criteria.list();
	}

	private void addRestrictionsForKeywords(Criteria criteria,
			Set<Keyword> keywords) {
		Iterator<Keyword> iter = keywords.iterator();
		Criteria authorsCriteria = criteria.createCriteria("keywords");
		while (iter.hasNext()) {
			Keyword keyword = (Keyword) iter.next();
			authorsCriteria.add(Restrictions.like("name", "%" + keyword + "%"));
		}
	}

	private void addRestrictionsForAuthors(Criteria criteria,
			Set<String> authors) {
		Iterator<String> iter = authors.iterator();
		Criteria authorsCriteria = criteria.createCriteria("authors");
		while (iter.hasNext()) {
			String author = (String) iter.next();
			authorsCriteria.add(Restrictions.like("", "%" + author + "%"));
		}
	}
}