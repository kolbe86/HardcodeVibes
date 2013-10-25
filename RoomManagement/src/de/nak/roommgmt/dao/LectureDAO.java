/**
 * 
 */
package de.nak.roommgmt.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.roommgmt.model.Lecture;

/**
 * The lecture data access object.
 * @author Stephan Anft
 */
public class LectureDAO extends HibernateDaoSupport {

	/**
	 * Finds and returns all lectures.
	 * @return a list of lectures.
	 */
	@SuppressWarnings("unchecked")
	public List<Lecture> findAll() {
		return getHibernateTemplate().find("from Lecture");
	}
	
	/**
	 * Finds a lecture object with the given id.
	 * @param lectureId The id.
	 * @return a Lecture object or <code>null</code>.
	 */
	public Lecture findById(Long lectureId) {
		return (Lecture)getHibernateTemplate().get(Lecture.class, lectureId);
	}
	
	/**
	 * Finds and returns the lectures with the given room id.
	 * @param roomId The room id.
	 * @return a list of lectures.
	 */
	@SuppressWarnings("unchecked")
	public List<Lecture> findByRoomId(Long roomId) {
		return getHibernateTemplate().findByNamedParam("from Lecture where room.id = :roomId", "roomId", roomId);
	}
	
	/**
	 * Persists the given lecture object.
	 * @param lecture The lecture object to persist.
	 */
	public void save(Lecture lecture) {
		getHibernateTemplate().save(lecture);
	}
	
	/**
	 * Deletes the given lecture object.
	 * @param lecture The object to be removed.
	 */
	public void delete(Lecture lecture) {
		getHibernateTemplate().delete(lecture);
	}
}
