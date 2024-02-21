package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IHotelRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private IRoomRepository roomRepository;
    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public List<Room> getRoomsForHotel(String hotelCode) throws Exception {
        Hotel hotel = hotelRepository.findById(hotelCode).orElse(null);
        if (hotel != null) {
            return hotel.getRooms();
        } else
            throw new Exception("No existe el hotel");
    }

    @Override
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room findRoom(String id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public void saveRoom(RoomDTO roomDTO) throws Exception {
        Room room = new Room();
        Hotel hotel = hotelRepository.findById(roomDTO.getHotelCode()).orElse(null);
        if (hotel == null) throw new Exception("No existe el hotel al que añadir la habitacion");

        room.setRoomType(roomDTO.getRoomType());
        room.setNightPrice(roomDTO.getNightPrice());
        room.setRoomSize(roomDTO.getRoomSize());
        room.setHotel(hotel);
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setRoomId(hotel.getHotelCode() + "-" + room.getRoomNumber());
        if(roomRepository.existsByHotelAndRoomNumber(hotel,room.getRoomNumber()))
        {
            throw new Exception("Ya existe una habitacion con el numero "+room.getRoomNumber()+" en el hotel "+hotel.getHotelCode());
        }
        roomRepository.save(room);

    }

    @Override
    public void editRoom(String id, Double nightPrice, Integer roomSize, String roomType) throws Exception {
        Room room = roomRepository.findById(id).orElse(null);
        if(room == null) throw new Exception("No existe la habitacion a editar");
        if(nightPrice!=null) room.setNightPrice(nightPrice);
        if(roomSize!=null) room.setRoomSize(roomSize);
        if(roomType!=null) room.setRoomType(roomType);
    }

    @Override
    public void deleteRoom(String id) throws Exception {

        Room room = roomRepository.findById(id).orElse(null);
        if(room == null) throw new Exception("No existe la habitacion a borrar");
        if(!room.getRoomBookings().isEmpty()) throw new Exception("La habitacion tiene reservas asignadas");
        roomRepository.delete(room);

    }
}
