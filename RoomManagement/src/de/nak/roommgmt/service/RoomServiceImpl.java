package de.nak.roommgmt.service;

import de.nak.roommgmt.dao.RoomDAO;
import de.nak.roommgmt.model.Room;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * The room service implementation.
 *
 * @author Stephan Anft
 */
public class RoomServiceImpl implements RoomService {
	/**
	 * The room data access object.
	 */
	private RoomDAO roomDAO;
	
	/** {@inheritDoc} */
	public void createRoom(String building, int roomNumber, int seats, boolean beamer) throws RoomAlreadyPresentException {
		// Create room object
		Room room = new Room();
		room.setBuilding(building);
		room.setRoomNumber(roomNumber);
		room.setSeats(seats);
		room.setBeamer(beamer);
		try {
			roomDAO.save(room);
		}
		catch (DataIntegrityViolationException ex) {
			throw new RoomAlreadyPresentException();
		}
	}

	/** {@inheritDoc} */
	public List<Room> listRooms() {
		return roomDAO.findAll();
	}

	/** {@inheritDoc} */
	public Room showRoom(Long id) throws RoomNotFoundException {
		Room room = roomDAO.findById(id);
		if (room == null) {
			throw new RoomNotFoundException();
		}
		return room;
	}

	/** {@inheritDoc} */
	public void updateRoom(Long id, int seats, boolean beamer) throws RoomNotFoundException {
		Room room = roomDAO.findById(id);
		if (room == null) {
			throw new RoomNotFoundException();
		}
		room.setSeats(seats);
		room.setBeamer(beamer);
	}

	/** {@inheritDoc} */
	public void deleteRoom(Long id) throws RoomNotFoundException {
		Room room = roomDAO.findById(id);
		if (room == null) {
			throw new RoomNotFoundException();
		}
		roomDAO.delete(room);
	}

	/**
	 * Returns the room DAO.
	 * @return the roomDAO.
	 */
	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	/**
	 * Sets the room DAO.
	 * @param roomDAO the roomDAO to set.
	 */
	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	
	
}
