package de.nak.librarymgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.util.ConditionE;

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
	public List<Publication> findByCriteria(String title, boolean distributed,
			boolean reserved, PublicationType publicationType, String isbn,
			String publisher, String issue, String edition, ConditionE condition) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Publication.class);
		criteria.add(Restrictions.like("title", "%" + title + "%").ignoreCase());
		criteria.add(Restrictions.eq("distributed", distributed));
		criteria.add(Restrictions.eq("reserved", reserved));
		criteria.add(Restrictions.eq("publicationType", publicationType));
		criteria.add(Restrictions.like("isbn", "%" + isbn + "%"));
		criteria.add(Restrictions.like("publisher", "%" + publisher + "%").ignoreCase());
		criteria.add(Restrictions.like("issue", "%" + issue + "%").ignoreCase());
		criteria.add(Restrictions.like("edition", "%" + edition + "%").ignoreCase());
		criteria.add(Restrictions.eq("condition", condition));
		criteria.addOrder(Order.asc("title"));
		return ((List<Publication>) criteria.list());
	}
}
