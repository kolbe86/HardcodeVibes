package de.nak.roommgmt.service;

import java.util.Date;
import java.util.List;

import de.nak.roommgmt.dao.LectureDAO;
import de.nak.roommgmt.model.Course;
import de.nak.roommgmt.model.Lecture;
import de.nak.roommgmt.model.Room;

/**
 * The lecture service implementation.
 * @author Stephan Anft
 */
public class LectureServiceImpl implements LectureService {
	/**
	 * The lecture data access object.
	 */
	private LectureDAO lectureDAO;
	/**
	 * The room service.
	 */
	private RoomService roomService;
	/**
	 * The course service.
	 */
	private CourseService courseService;
	
	/** {@inheritDoc} */
	public void createLecture(Date begin, Date end, Long courseId, Long roomId) throws CourseNotFoundException, RoomNotFoundException {
		// Get the course entity
		Course course = courseService.showCourse(courseId);
		// Get the room entity
		Room room = roomService.showRoom(roomId);
		// Create a new lecture
		Lecture lecture = new Lecture();
		lecture.setBegin(begin);
		lecture.setEnd(end);
		// Associate lecture to course
		course.associateLecture(lecture);
		// Associate lecture to room
		room.associateLecture(lecture);
		// Save the entity
		lectureDAO.save(lecture);
	}
	
	/** {@inheritDoc} */
	public List<Lecture> listLectures() {
		return lectureDAO.findAll();
	}
	
	/** {@inheritDoc} */
	public List<Lecture> findLecturesInRoom(Long roomId) {
		return lectureDAO.findByRoomId(roomId);
	}
	
	/** {@inheritDoc} */
	public void deleteLecture(Long id) throws LectureNotFoundException {
		Lecture lecture = lectureDAO.findById(id);
		if (lecture == null) {
			throw new LectureNotFoundException();
		}
		lectureDAO.delete(lecture);
	}

	/**
	 * Returns the lecture DAO.
	 * @return the lectureDAO.
	 */
	public LectureDAO getLectureDAO() {
		return lectureDAO;
	}

	/**
	 * Sets the lecture DAO.
	 * @param lectureDAO the lectureDAO to set.
	 */
	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}

	/**
	 * Returns the room service.
	 * @return the roomService.
	 */
	public RoomService getRoomService() {
		return roomService;
	}

	/**
	 * Sets the room service.
	 * @param roomService the roomService to set.
	 */
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	/**
	 * Returns the course service.
	 * @return the courseService.
	 */
	public CourseService getCourseService() {
		return courseService;
	}

	/**
	 * Sets the course service.
	 * @param courseService the courseService to set.
	 */
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	
}
