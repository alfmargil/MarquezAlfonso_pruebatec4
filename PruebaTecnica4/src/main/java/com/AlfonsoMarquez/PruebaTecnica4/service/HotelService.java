package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IHotelRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private IHotelRepository hotelRepository;
    @Autowired
    private IRoomRepository roomRepository;

    @Override
    public List<Hotel> getHotels() {
        return new ArrayList<>(hotelRepository.findAll());
    }

    @Override
    public void saveHotelWithRooms(Hotel hotel) {
        hotelRepository.save(hotel);
        if (!hotel.getRooms().isEmpty()) {
            for (Room room : hotel.getRooms()) {
                room.setHotel(hotel);
                room.setRoomId(hotel.getHotelCode() + "-" + room.getRoomNumber());
                roomRepository.save(room);
            }
        }

    }

    @Override
    public void deleteHotel(String code) {
        hotelRepository.deleteById(code);
    }

    @Override
    public Hotel findHotel(String code) {
        return hotelRepository.findById(code).orElse(null);
    }

    @Override
    public List<Hotel> findAvailableHotels(LocalDate fromDate, LocalDate toDate, String destination) {
        return null;

    }

}

