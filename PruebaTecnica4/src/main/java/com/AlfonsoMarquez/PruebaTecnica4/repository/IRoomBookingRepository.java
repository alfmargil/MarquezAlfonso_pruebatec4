package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.Person;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import com.AlfonsoMarquez.PruebaTecnica4.model.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IRoomBookingRepository extends JpaRepository<RoomBooking,Long> {

    public RoomBooking findByRoomIdAndDatesAndHosts(String roomId, LocalDate checkIn, LocalDate checkOut, List<Person> hosts);

}
