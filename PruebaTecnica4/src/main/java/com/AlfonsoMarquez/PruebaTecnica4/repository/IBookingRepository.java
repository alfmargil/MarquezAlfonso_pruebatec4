package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<RoomBooking,Long> {

}
