package de.nak.librarymgmt.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Author;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.PublicationNotDeletableException;
import de.nak.librarymgmt.util.ConditionE;

public class PublicationDAO extends HibernateDaoSupport {

	public void save(Publication publication) {
		getHibernateTemplate().save(publication);
	}

	public void delete(Publication publication)
			throws PublicationNotDeletableException {
		try {
			getHibernateTemplate().delete(publication);

		} catch (DataIntegrityViolationException e) {
			throw new PublicationNotDeletableException();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Publication> findAll() {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Publication.class);
		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		criteria.setFetchMode("authors", FetchMode.JOIN);
		criteria.setFetchMode("publicationType", FetchMode.JOIN);
		criteria.setFetchMode("keywords", FetchMode.JOIN);
		return (List<Publication>) criteria.list();
	}

	public Publication findById(Long publicationID) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Publication.class);
		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		criteria.setFetchMode("keywords", FetchMode.JOIN);
		criteria.setFetchMode("publicationType", FetchMode.JOIN);
		criteria.setFetchMode("authors", FetchMode.JOIN);
		criteria.add(Restrictions.eq("publicationID", publicationID));
		return (Publication) criteria.uniqueResult();

	}

	@SuppressWarnings({ "unchecked" })
	public List<Publication> findByCriteria(String title, Set<Author> authors,
			PublicationType publicationType, Set<Keyword> keywords,
			ConditionE condition, String isbn, String publisher,
			String edition, String issue) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Publication.class);
		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		criteria.setFetchMode("keywords", FetchMode.JOIN);
		criteria.setFetchMode("publicationType", FetchMode.JOIN);
		criteria.setFetchMode("authors", FetchMode.JOIN);
		if (authors != null) {
			addRestrictionsForAuthors(criteria, authors);
		}
		if (keywords != null) {
			addRestrictionsForKeywords(criteria, keywords);
		}
		criteria.add(Restrictions.like("title", "%" + title + "%").ignoreCase());
		criteria.add(Restrictions.eq("publicationType", publicationType));
		criteria.add(Restrictions.eq("condition", condition));
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
		while (iter.hasNext()) {
			Keyword keyword = (Keyword) iter.next();
			String name = keyword.getName();
			criteria.add(Restrictions
					.sqlRestriction("'"
							+ name
							+ "' IN (SELECT NAME FROM PUBLICATIONS_KEYWORDS WHERE PUBLICATION_ID = this.id)"));
		}
	}

	private void addRestrictionsForAuthors(Criteria criteria,
			Set<Author> authors) {
		Iterator<Author> iter = authors.iterator();
		while (iter.hasNext()) {
			Author author = (Author) iter.next();
			String name = author.getName();
			criteria.add(Restrictions
					.sqlRestriction("'"
							+ name
							+ "' IN (SELECT NAME FROM PUBLICATIONS_AUTHORS WHERE PUBLICATION_ID = this.id)"));
		}
	}
}