/**
 * 
 */
package de.nak.roommgmt.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import de.nak.roommgmt.model.Room;

/**
 * Room data access object.
 * @author Stephan Anft
 */
public class RoomDAO extends HibernateDaoSupport {
	
	/**
	 * Finds and returns all rooms.
	 * @return a list of rooms.
	 */
	@SuppressWarnings("unchecked")
	public List<Room> findAll() {
		return getHibernateTemplate().find("from Room");
	}
	
	/**
	 * Finds a room with the given id.
	 * @param roomId The id.
	 * @return a room object or <code>null</code>.
	 */
	public Room findById(Long roomId) {
		return (Room)getHibernateTemplate().get(Room.class, roomId);
	}
	
	/**
	 * Persists the given room object.
	 * @param room The room.
	 */
	public void save(Room room) {
		getHibernateTemplate().save(room);
	}
	
	/**
	 * Deletes the given room object.
	 * @param room The room.
	 */
	public void delete(Room room) {
		getHibernateTemplate().delete(room);
	}
}
