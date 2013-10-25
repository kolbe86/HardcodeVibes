package de.nak.roommgmt.service;

import java.util.Date;
import java.util.List;

import de.nak.roommgmt.model.Lecture;

/**
 * The lecture service interface.
 * @author Stephan Anft
 */
public interface LectureService {

	/**
	 * Creates and stores a new lecture entity.
	 * @param begin The begin of the lecture.
	 * @param end The end of the lecture.
	 * @param courseId The id of the course entity.
	 * @param roomId The id of the room entity.
	 * @throws CourseNotFoundException if the given course is not found.
	 * @throws RoomNotFoundException if the given room is not found.
	 */
	void createLecture(Date begin, Date end, Long courseId,
			Long roomId) throws CourseNotFoundException, RoomNotFoundException;

	/**
	 * Lists all lectures currently stored in the database.
	 * @return a list of lectures.
	 */
	List<Lecture> listLectures();

	/**
	 * Finds all lectures in a given room.
	 * @param roomId The room id.
	 * @return the list of lectures.
	 */
	List<Lecture> findLecturesInRoom(Long roomId);

	/**
	 * Deletes the given lecture entity.
	 * @param id The identifier.
	 * @throws LectureNotFoundException if no lecture was found using
	 * the given identifier.
	 */
	void deleteLecture(Long id) throws LectureNotFoundException;

}