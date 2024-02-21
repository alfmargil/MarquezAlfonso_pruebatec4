package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;

import java.util.List;

public interface IRoomService {

    public List<Room> getRoomsForHotel(String hotelCode) throws Exception;
    public List<Room> getRooms();
    public void saveRoom(RoomDTO roomDTO) throws Exception;
    public Room findRoom(String id);
}
