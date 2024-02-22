package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomBookingDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Person;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import com.AlfonsoMarquez.PruebaTecnica4.model.RoomBooking;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IPersonRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IRoomBookingRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoomBookingService implements IRoomBookingService{

    @Autowired
    private IRoomBookingRepository bookingRepository;
    @Autowired
    private IRoomRepository roomRepository;
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<RoomBooking> getRoomBookings() {
        return new ArrayList<>(bookingRepository.findAll());
    }

    @Override
    public double saveRoomBooking(RoomBookingDTO roomBookingDTO) throws Exception {

        RoomBooking existingBooking = bookingRepository.findByRoomIdAndDatesAndHosts(
                roomBookingDTO.getRoomId(),
                roomBookingDTO.getCheckIn(),
                roomBookingDTO.getCheckOut(),
                roomBookingDTO.getHosts());
        if (existingBooking != null) {
            throw new Exception("Ya existe una reserva con los mismos datos");
        }

        if(roomBookingDTO.getHosts().size()>roomRepository.findByRoomId(roomBookingDTO.getRoomId()).getRoomSize())
        {
            throw new Exception("Más gente de la permitida");
        }

        RoomBooking roomBooking = new RoomBooking();
        roomBooking.setCheckIn(roomBookingDTO.getCheckIn());
        roomBooking.setCheckOut(roomBookingDTO.getCheckOut());
        roomBooking.setNights();
        roomBooking.setPeopleQ(roomBookingDTO.getHosts().size());
        roomBooking.setHosts(roomBookingDTO.getHosts());
        roomBooking.setRoom(roomRepository.findByRoomId(roomBookingDTO.getRoomId()));

        if(roomBooking.getRoom().isAvailable(roomBooking.getCheckIn(),roomBooking.getCheckOut()))
        {
            for(Person person : roomBooking.getHosts())
            {
                personRepository.save(person);
            }
            bookingRepository.save(roomBooking);
            return roomBooking.getNights()*roomBooking.getRoom().getNightPrice();
        }else
            return 0;
    }

    @Override
    public void deleteRoomBooking(Long id) {
    }

    @Override
    public Room findRoomBooking(Long id) {
        return null;
    }
}
