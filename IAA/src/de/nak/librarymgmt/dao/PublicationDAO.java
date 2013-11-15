package de.nak.librarymgmt.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
		return getHibernateTemplate().find("from Publication");
	}

	public Publication findById(Long publicationID) {
		return (Publication) getHibernateTemplate().get(Publication.class,
				publicationID);
	}

	@SuppressWarnings("unchecked")
	public List<Publication> findByCriteria(String title, Set<String> authors,
			String isbn, String publisher, String issue, String edition) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Publication.class);
		criteria.add(Restrictions.like("title", "%" + title + "%").ignoreCase());
		criteria.add(Restrictions.like("isbn", "%" + isbn + "%"));
		criteria.add(Restrictions.like("publisher", "%" + publisher + "%")
				.ignoreCase());
		criteria.add(Restrictions.like("issue", "%" + issue + "%").ignoreCase());
		criteria.add(Restrictions.like("edition", "%" + edition + "%")
				.ignoreCase());
		criteria.addOrder(Order.asc("title"));
		return ((List<Publication>) criteria.list());
	}

	private void addRestrictionsForAuthor(Criteria criteria, Set<String> authors) {
		Iterator<String> iter = authors.iterator();
		Criteria authorsCriteria = criteria.createCriteria("authors");
		while (iter.hasNext()) {
			String author = (String) iter.next();
			authorsCriteria.add(Restrictions.like("name", "%" + author + "%"));
		}
	}
}