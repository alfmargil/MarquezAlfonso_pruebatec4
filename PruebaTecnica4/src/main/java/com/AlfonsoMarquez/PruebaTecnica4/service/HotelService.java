package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.HotelDTO;
import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IHotelRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IRoomRepository;
import com.AlfonsoMarquez.PruebaTecnica4.util.WordSplitter;
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
    public void saveHotelWithRooms(Hotel hotel) throws Exception {
        hotelRepository.save(hotel);
        if (!hotel.getRooms().isEmpty()) {
            for (Room room : hotel.getRooms()) {
                room.setHotel(hotel);
                room.setRoomId(hotel.getHotelCode() + "-" + room.getRoomNumber());
                if(roomRepository.existsByHotelAndRoomNumber(hotel,room.getRoomNumber()))
                {
                    throw new Exception("Ya existe una habitacion con el numero "+room.getRoomNumber()+" en el hotel "+hotel.getHotelCode());
                }
                roomRepository.save(room);
            }
        }
    }

    @Override
    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void saveHotelDTO(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setPlace(hotelDTO.getPlace());
        hotel.setName(hotelDTO.getName());
        String cityCode = WordSplitter.getFirstThreeLetters(hotel.getPlace().toUpperCase());
        long hotelCount = hotelRepository.countByPlace(hotelDTO.getPlace())+1;
        String hotelCountString = String.format("%03d", (hotelCount));
        String hotelCode = cityCode+"-"+hotelCountString;
        hotel.setHotelCode(hotelCode);
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(String code) throws Exception {
        Hotel hotel = hotelRepository.getReferenceById(code);
        for (Room room : hotel.getRooms()) {
            if (!room.getRoomBookings().isEmpty()) {
                throw new Exception("El hotel a eliminar tiene alguna reserva en la habitacion: " + room.getRoomId());
            }
        }
        //Como no quiero que se haga un borrado parcial si a mitad del proceso se encuentra una reserva voy a volver a iterar sobre la lista y eliminarla
        for (Room room : hotel.getRooms()) {
            roomRepository.delete(room);
        }
        hotelRepository.deleteById(code);

    }

    @Override
    public Hotel findHotel(String code) {
        return hotelRepository.findById(code).orElse(null);
    }

    @Override
    public List<RoomDTO> findAvailableRooms(LocalDate fromDate, LocalDate toDate, String destination) {
        List<RoomDTO> availableRooms = new ArrayList<>();
        for (Hotel hotel : hotelRepository.findByPlace(destination)) {
            for (Room room : roomRepository.findByHotel(hotel)) {
                if (room.isAvailable(fromDate, toDate)) {
                    availableRooms.add(new RoomDTO(room.getRoomSize(), room.getRoomNumber(), room.getRoomType(), room.getNightPrice(), hotel.getName()));
                }
            }
        }
        return availableRooms;
    }

}

