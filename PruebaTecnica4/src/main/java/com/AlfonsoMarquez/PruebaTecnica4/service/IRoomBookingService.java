package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomBookingDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import com.AlfonsoMarquez.PruebaTecnica4.model.RoomBooking;

import java.util.List;

public interface IRoomBookingService {

    public List<RoomBooking> getRoomBookings();
    public double saveRoomBooking(RoomBookingDTO roomBooking) throws Exception;
    public void deleteRoomBooking(Long id);
    public Room findRoomBooking(Long id);


}
