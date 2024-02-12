package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightBookingRepository extends JpaRepository<FlightBooking,Long> {

}
