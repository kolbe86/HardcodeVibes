/**
 * 
 */
package de.nak.roommgmt.service;

import java.util.List;

import de.nak.roommgmt.model.Room;

/**
 * Interface for the room service.
 * @author Stephan Anft
 */
public interface RoomService {
	/**
	 * Creates a new room and stores it in the database.
	 *
	 * @param building   The building.
	 * @param roomNumber The room number.
	 * @param seats	  The number of seats.
	 * @param beamer	 The beamer flag.
	 * @throws RoomAlreadyPresentException if a room with the same building/room number
	 *                                     combination is already present in the database.
	 */
	void createRoom(String building, int roomNumber, int seats, boolean beamer) throws RoomAlreadyPresentException;

	/**
	 * List all rooms currently stored in the database.
	 *
	 * @return a list of Room entities. If no room was found an empty list is
	 *         returned.
	 */
	List<Room> listRooms();

	/**
	 * Returns the room identified by the given id.
	 *
	 * @param id The identifier.
	 * @return the found entity.
	 * @throws RoomNotFoundException if no room could be found for the given id.
	 */
	Room showRoom(Long id) throws RoomNotFoundException;

	/**
	 * Updates a room entity and stores the changes into the database.
	 *
	 * @param id	 The identifier.
	 * @param seats  The number of seats.
	 * @param beamer The beamer flag.
	 * @throws RoomNotFoundException if no room could be found for the given id.
	 */
	void updateRoom(Long id, int seats, boolean beamer) throws RoomNotFoundException;

	/**
	 * Deletes the room with the given id.
	 *
	 * @param id The identifier.
	 * @throws RoomNotFoundException if no room could be fount for the given id.
	 */
	void deleteRoom(Long id) throws RoomNotFoundException;

}
