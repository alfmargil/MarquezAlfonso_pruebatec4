package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IFlightRepository extends JpaRepository<Flight,String> {

    public Flight findByFlightCode(String flightCode);
    public int countByPlaneAndDepartureDate(Plane plane, LocalDate departureDate);
}
