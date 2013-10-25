package de.nak.roommgmt.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.roommgmt.model.Room;
import de.nak.roommgmt.service.RoomService;

public class showRoomListAction implements Action {

	private List<Room> rooms;
	private RoomService roomService;

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String execute() throws Exception {
		rooms = roomService.listRooms();
		return SUCCESS;
	}

}
