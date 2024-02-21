package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.HotelDTO;
import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {

    public List<Hotel> getHotels();
    public void saveHotel(Hotel hotel);
    public void saveHotelWithRooms(Hotel hotel);

    public void saveHotelDTO(HotelDTO hotelDTO);

    public void deleteHotel(String code) throws Exception;
    public Hotel findHotel(String code);
    public List<RoomDTO> findAvailableRooms(LocalDate fromDate, LocalDate toDate, String Destination);

}
