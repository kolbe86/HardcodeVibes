package de.nak.roommgmt.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import de.nak.roommgmt.dao.CourseDAO;
import de.nak.roommgmt.model.Course;

/**
 * The course service implementation..
 *
 * @author Stephan Anft
 */
public class CourseServiceImpl implements CourseService {
	/**
	 * The course DAO.
	 */
	private CourseDAO courseDAO;
	
	/** {@inheritDoc} */
	public void createCourse(String fieldOfStudy, int number, String lecturer, String title) throws CourseAlreadyPresentException {
		// Create course object
		Course course = new Course();
		course.setFieldOfStudy(fieldOfStudy);
		course.setNumber(number);
		course.setLecturer(lecturer);
		course.setTitle(title);
		try {
			courseDAO.save(course);
		}
		catch (DataIntegrityViolationException ex) {
			throw new CourseAlreadyPresentException();
		}
	}
	
	/** {@inheritDoc} */
	public List<Course> listCourses() {
		return courseDAO.findAll();
	}

	/** {@inheritDoc} */
	public Course showCourse(Long id) throws CourseNotFoundException {
		Course course = courseDAO.findById(id);
		if (course == null) {
			throw new CourseNotFoundException();
		}
		return course;
	}

	/** {@inheritDoc} */
	public void updateCourse(Long id, String lecturer, String title) throws CourseNotFoundException {
		Course course = courseDAO.findById(id);
		if (course == null) {
			throw new CourseNotFoundException();
		}
		course.setLecturer(lecturer);
		course.setTitle(title);
	}

	/** {@inheritDoc} */
	public void deleteCourse(Long id) throws CourseNotFoundException {
		Course course = courseDAO.findById(id);
		if (course == null) {
			throw new CourseNotFoundException();
		}
		courseDAO.delete(course);
	}

	/**
	 * Returns the course DAO.
	 * @return the courseDAO.
	 */
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	/**
	 * Sets the course DAO.
	 * @param courseDAO the courseDAO to set.
	 */
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
}
