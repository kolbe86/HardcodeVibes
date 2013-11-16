package de.nak.librarymgmt.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.librarymgmt.model.Author;

public class AuthorDAO extends HibernateDaoSupport {

	public void save(Author author) {
		getHibernateTemplate().saveOrUpdate(author);

	}

	public void delete(Author publicationType) {
		getHibernateTemplate().delete(publicationType);
	}

	@SuppressWarnings("unchecked")
	public Set<Author> findAll() {
		Set<Author> authorSet = new HashSet<Author>(getHibernateTemplate()
				.find("from Author"));
		return authorSet;
	}

	public Author findById(long id) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Author.class);
		criteria.add(Restrictions.eq("id", id));
		return (Author) getHibernateTemplate().get(Author.class, id);

	}

	public Author findByName(String name) {
		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Author.class);
		criteria.add(Restrictions.eq("name", name));
		return (Author) criteria.uniqueResult();
	}

}
