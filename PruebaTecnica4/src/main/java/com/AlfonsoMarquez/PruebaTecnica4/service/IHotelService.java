package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IHotelService {

    public List<Hotel> getHotels();
    public void saveHotel(Hotel hotel);
    public void saveHotelWithRooms(Hotel hotel);
    public void deleteHotel(String code) throws Exception;
    public Hotel findHotel(String code);
    public List<RoomDTO> findAvailableRooms(LocalDate fromDate, LocalDate toDate, String Destination);

}
