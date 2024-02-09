package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {

    public List<Hotel> getHotels();
    public void saveHotel(Hotel hotel);
    public void deleteHotel(String code);
    public Hotel findHotel(String code);
    public List<Hotel> findAvailableHotels(LocalDate fromDate, LocalDate toDate, String Destination);

}
