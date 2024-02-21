package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlightBookingRepository extends JpaRepository<FlightBooking,Long> {
    public List<FlightBooking> findByFlightFlightCode(String flightCode);
}
