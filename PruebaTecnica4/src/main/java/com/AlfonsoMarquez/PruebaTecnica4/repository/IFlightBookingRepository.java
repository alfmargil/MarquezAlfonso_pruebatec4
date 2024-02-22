package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.FlightBooking;
import com.AlfonsoMarquez.PruebaTecnica4.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IFlightBookingRepository extends JpaRepository<FlightBooking,Long> {
    public List<FlightBooking> findByFlightFlightCode(String flightCode);
    public FlightBooking findByFlightCodeAndDepartureDateAndPassengers(String flightCode, LocalDate departureDate, List<Person> passengers);
}
