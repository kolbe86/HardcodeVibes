/**
 * 
 */
package de.nak.roommgmt.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.roommgmt.model.Course;

/**
 * Course data access object.
 * @author Stephan Anft
 */
public class CourseDAO extends HibernateDaoSupport {
	
	/**
	 * Finds and returns all courses.
	 * @return a list of courses.
	 */
	@SuppressWarnings("unchecked")
	public List<Course> findAll() {
		return getHibernateTemplate().find("from Course");
	}
	
	/**
	 * Finds a course with the given id.
	 * @param courseId The id.
	 * @return a course object or <code>null</code>.
	 */
	public Course findById(Long courseId) {
		return (Course)getHibernateTemplate().get(Course.class, courseId);
	}
	
	/**
	 * Persists the given course object.
	 * @param course The course.
	 */
	public void save(Course course) {
		getHibernateTemplate().save(course);
	}
	
	/**
	 * Deletes the given course object.
	 * @param course The course.
	 */
	public void delete(Course course) {
		getHibernateTemplate().delete(course);
	}
}
