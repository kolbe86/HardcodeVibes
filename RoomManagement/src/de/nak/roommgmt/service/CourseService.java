package de.nak.roommgmt.service;

import java.util.List;

import de.nak.roommgmt.model.Course;

/**
 * The course service interface.
 * @author Stephan Anft
 */
public interface CourseService {

	/**
	 * Creates a new course in the database.
	 * @param fieldOfStudy The field of study.
	 * @param number The course number.
	 * @param lecturer The lecturer's name.
	 * @param title The title.
	 * @throws CourseAlreadyPresentException if the course already exists in the database.
	 */
	void createCourse(String fieldOfStudy, int number,
			String lecturer, String title) throws CourseAlreadyPresentException;

	/**
	 * List all courses currently stored in the database.
	 *
	 * @return a list of course entities. If no course was found an empty list is
	 *         returned.
	 */
	List<Course> listCourses();

	/**
	 * Returns the course identified by the given id.
	 *
	 * @param id The identifier.
	 * @return the found entity.
	 * @throws CourseNotFoundException if no room could be found for the given id.
	 */
	Course showCourse(Long id) throws CourseNotFoundException;

	/**
	 * Updates a course entity and stores the changes into the database.
	 *
	 * @param id The identifier.
	 * @param lecturer The lecturer.
	 * @param title The title.
	 * @throws CourseNotFoundException if no course could be found for the given id.
	 */
	void updateCourse(Long id, String lecturer, String title)
			throws CourseNotFoundException;

	/**
	 * Deletes the course with the given id.
	 *
	 * @param id The identifier.
	 * @throws CourseNotFoundException if no course could be fount for the given id.
	 */
	void deleteCourse(Long id) throws CourseNotFoundException;

}