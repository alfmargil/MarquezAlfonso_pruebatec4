package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.model.Room;

import java.util.List;

public interface IRoomService {

    public List<Room> getRooms(String hotelCode);

}
