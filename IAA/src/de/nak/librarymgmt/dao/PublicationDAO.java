package de.nak.librarymgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Publication;

public class PublicationDAO extends HibernateDaoSupport {

	public Publication findPublicationByID(long publicationID) {
		return (Publication) getHibernateTemplate().get(Publication.class,
				publicationID);
	}

	@SuppressWarnings("unchecked")
	public List<Publication> findAll() {
		return getHibernateTemplate().find("from Publication");
	}

	@SuppressWarnings("unchecked")
	public List<Publication> findByCriteria(String title, String condition) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Publication.class);
		criteria.add(Restrictions.like("title", "%" + title + "%").ignoreCase());
		criteria.add(Restrictions.like("condition", "%" + condition + "%")
				.ignoreCase());
		return ((List<Publication>) criteria.list());
	}
}
